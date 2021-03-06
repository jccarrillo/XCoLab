package org.xcolab.portlets.userprofile.wrappers;

import com.ext.portlet.Activity.SubscriptionType;

import org.xcolab.activityEntry.ActivitySubscriptionNameGenerator;
import org.xcolab.client.activities.pojo.ActivitySubscription;

import java.io.Serializable;
import java.util.Date;

public class ActivitySubscriptionWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private ActivitySubscription subscription;
    private boolean selected;
    private long subscriptionPk;

    public ActivitySubscriptionWrapper() {
    }

    public ActivitySubscriptionWrapper(ActivitySubscription subscription) {
        this.subscription = subscription;
        this.subscriptionPk = subscription.getPk();
    }

    public String getName() {
        return ActivitySubscriptionNameGenerator.getName(subscription);
    }

    public Date getUpdated() {
        return subscription.getModifiedDate();
    }

    public SubscriptionType getType() {
        return SubscriptionType.getSubscriptionType(subscription);
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ActivitySubscription getWrapped() {
        return subscription;
    }

    public ActivitySubscription getSubscription() {
        return subscription;
    }

    public void setSubscription(ActivitySubscription subscription) {
        this.subscription = subscription;
    }

    public long getSubscriptionPk() {
        return subscriptionPk;
    }

    public void setSubscriptionPk(long subscriptionPk) {
        this.subscriptionPk = subscriptionPk;
    }
}
