package org.xcolab.portlets.contestmanagement.beans;

import com.ext.portlet.model.Contest;
import com.liferay.portal.kernel.exception.SystemException;
import org.xcolab.portlets.contestmanagement.entities.LabelValue;
import org.xcolab.util.exceptions.DatabaseAccessException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Thomas on 6/9/2015.
 */
public class ContestFlagTextToolTipBean implements Serializable {

    private final static List<LabelValue> FLAG_OPTIONS = Arrays.asList(
            new LabelValue(-1L, "Hide flag"),
            new LabelValue(0L, "Phase default"),
            new LabelValue(1L, "Green theme"),
            new LabelValue(2L, "Grey theme"));

    private int flagNumber;
    private String flagText;
    private String flagTooltip;

    public ContestFlagTextToolTipBean() {
        this.flagNumber = 0;
        this.flagText = "";
        this.flagTooltip = "";
    }

    public ContestFlagTextToolTipBean(int flagNumber, String flagText) {
        this.flagNumber = flagNumber;
        this.flagText = flagText;
        this.flagTooltip = "";
    }

    public ContestFlagTextToolTipBean(int flagNumber, String flagText, String flagTooltip) {
        this.flagNumber = flagNumber;
        this.flagText = flagText;
        this.flagTooltip = flagTooltip;
    }

    public ContestFlagTextToolTipBean(Contest contest) {
        this.flagNumber = contest.getFlag();
        this.flagText = contest.getFlagText();
    }

    public void persist(Contest contest) {
        contest.setFlag(flagNumber);
        contest.setFlagText(flagText);
        contest.setFlagTooltip(flagTooltip);
        try {
            contest.persist();
        } catch (SystemException e) {
            throw new DatabaseAccessException(e);
        }
    }

    public static List<LabelValue> getFlagOptions() {
        return FLAG_OPTIONS;
    }

    public int getFlagNumber() {
        return flagNumber;
    }

    public void setFlagNumber(int flagNumber) {
        this.flagNumber = flagNumber;
    }

    public String getFlagText() {
        return flagText;
    }

    public void setFlagText(String flagText) {
        this.flagText = flagText;
    }

    public String getFlagTooltip() {
        return flagTooltip;
    }

    public void setFlagTooltip(String flagTooltip) {
        this.flagTooltip = flagTooltip;
    }
}
