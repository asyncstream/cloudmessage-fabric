package com.asyncstream.cloudmessage.rule.api.model;

import java.util.Map;

public class MessageChargingCriteria extends RuleCriteria{
    private final String LICENSE_TYPE="licenseType";
    private final String MESSAGE_COUNT="messageCount";

    private final String licenseType;
    private final long messageCount;

    public MessageChargingCriteria(String licenseType, long messageCount) {
        this.licenseType = licenseType;
        this.messageCount = messageCount;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public long getMessageCount() {
        return messageCount;
    }

    @Override
    public Map<String, Object> contextMap() {
        this.contextMap.put(LICENSE_TYPE,licenseType);
        this.contextMap.put(MESSAGE_COUNT,messageCount);
        return this.contextMap;
    }
}
