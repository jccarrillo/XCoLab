package org.xcolab.portlets.proposals.view;

import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.ModelRunnerServiceUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.portlets.proposals.utils.ProposalsContext;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;

@Controller
@RequestMapping("view")
public class ContestModelController extends BaseProposalsController {
    private final static String COOKIE_PREFERRED_MODEL = "cc_contests_preferredModels";
    
    @Autowired
    private ProposalsContext proposalsContext;

    @RequestMapping(params = "pageToDisplay=contestModel")
    public String showContestProposals(RenderRequest request, RenderResponse response, Model model, @RequestParam(required = false) boolean refreshModels) 
            throws PortalException, SystemException, IOException {
    	
    	if (refreshModels) {
    		ModelRunnerServiceUtil.refreshModels();
    	}
    	Long contestPK = proposalsContext.getContest(request).getContestPK();
    	Long modelId = ContestLocalServiceUtil.getDefaultModelId(contestPK);
    	Map<Long, String> modelIdsWithNames;
    	if (modelId != null) {
        	modelIdsWithNames = ContestLocalServiceUtil.getModelIdsAndNames(proposalsContext.getContest(request).getContestPK());
        	model.addAttribute("availableModels", modelIdsWithNames);
    	}    
    	else {
    		modelIdsWithNames = new HashMap<>();
    	}

        for (Cookie cookie: request.getCookies()) {
            if (cookie.getName().equals(COOKIE_PREFERRED_MODEL)) {
            	try {
            		JsonElement element = new JsonParser().parse(URLDecoder.decode(cookie.getValue()));
            		JsonObject object = element.getAsJsonObject();
            		if (object.has(String.valueOf(proposalsContext.getContest(request).getContestPK()))) {
            			
            			long preferredModelId = object.get(String.valueOf(contestPK)).getAsLong();
            			if (modelIdsWithNames.containsKey(preferredModelId)) {
            				modelId = preferredModelId;
            			}
            			
            		}
            				
            	}
            	catch (JsonSyntaxException e) {
					//ignored
            	}
            } 
        }
    	
    	
    	model.addAttribute("modelId", modelId);
        return "contestModel";
        
    }
}
