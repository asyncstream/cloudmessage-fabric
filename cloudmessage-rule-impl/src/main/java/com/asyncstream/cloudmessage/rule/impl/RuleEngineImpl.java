package com.asyncstream.cloudmessage.rule.impl;

import com.asyncstream.cloudmessage.rule.api.engine.RuleEngine;
import com.asyncstream.cloudmessage.rule.api.model.MessageChargeResult;
import com.asyncstream.cloudmessage.rule.api.model.MessageChargingCriteria;

public class RuleEngineImpl implements RuleEngine {

    private final MessageChargingRuleExecutor messageChargingRuleExecutor;

    public RuleEngineImpl(MessageChargingRuleExecutor messageChargingRuleExecutor){
        this.messageChargingRuleExecutor=messageChargingRuleExecutor;
    }

    @Override
    public MessageChargeResult executeMessageChargingRule(String code, MessageChargingCriteria criteria) {
        return this.messageChargingRuleExecutor.execute(code,criteria);
    }
}
