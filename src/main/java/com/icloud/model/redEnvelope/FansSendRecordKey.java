package com.icloud.model.redEnvelope;

public class FansSendRecordKey {
    private String openId;

    private Long activityId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId == null ? null : activityId;
    }
}