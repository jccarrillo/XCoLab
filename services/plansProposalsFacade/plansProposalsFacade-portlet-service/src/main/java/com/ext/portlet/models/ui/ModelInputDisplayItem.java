/*
 * Copyright (c) 2010. M.I.T. All Rights Reserved
 * Licensed under the MIT license. Please see http://www.opensource.org/licenses/mit-license.php
 * or the license.txt file included in this distribution for the full text of the license.
 */

package com.ext.portlet.models.ui;

import java.io.Serializable;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;

import edu.mit.cci.roma.client.MetaData;
import edu.mit.cci.roma.client.Simulation;

/**
 * Top level class for all input elements in a model / simulation
 *
 *
 * @author: jintrone
 * @date: May 24, 2010
 */
public abstract class ModelInputDisplayItem extends ModelDisplayItem implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MetaData md;

    public ModelInputDisplayItem(Simulation sim, MetaData md) {
      super(sim);
      this.md = md;
    }


    /**
     * All input elements may have meta data associated with them.
     *
     * @return
     */
    public MetaData getMetaData() {
     return md;
    }

    /**
     * Convenience method - reaches through to associated metadata
     * @return
     */
    public String getName() {
        return md.getName();
    }


    /**
     * Convenience method - reaches through to associated metadata
     * @return
     */
    public String getDescription() {
       return md.getDescription();
    }
    
    /**
     * Returns display item type.
     * @return ModelDisplayItemType
     */
    public abstract ModelInputDisplayItemType getDisplayItemType();
    
    /**
     * Gets input widget type
     */
    public ModelInputWidgetType getType() {
        return ModelInputWidgetType.TEXT_FIELD;
    }
    
    /**
     * Sets input widget type
     * @throws SystemException 
     */
    public void setType(ModelInputWidgetType type) throws SystemException{
        // by default do nothing, in individual display item appropriate action should be taken
    }
    
    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = super.toJson();
        
        jsonObject.put("description", getDescription());
        
        jsonObject.put("displayItemType", getDisplayItemType().name());
        jsonObject.put("widgetType", getType().name());
        
        return jsonObject;    
    }
}
