package org.xcolab.portlets.contestmanagement.entities;

public class LabelValue implements Comparable<LabelValue> {
    private String lable;
    private Long value;

    public LabelValue(Long value, String lable) {
        this.value = value;
        this.lable = lable;
    }


    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public int compareTo(LabelValue o) {
        return this.getLable().compareTo(o.getLable());
    }
}
