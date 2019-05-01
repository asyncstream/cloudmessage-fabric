package com.asyncstream.cloudmessage.rule.impl;

import com.asyncstream.cloudmessage.rule.api.model.MessageChargeResult;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionRuleResult;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;

import java.util.Map;

public class MessageChargingRuleExecutor extends RuleExecutor<MessageChargeResult>{

    public MessageChargingRuleExecutor(final RuleRegistry registry,final DmnEngine dmnEngine) {
        super(registry,dmnEngine);
    }

    @Override
    public MessageChargeResult execute(DmnDecision decision, Map<String, Object> contextMap) {
        try {
            final DmnDecisionTableResult tableResult = this.getDmnEngine().evaluateDecisionTable(decision, contextMap);
            final DmnDecisionRuleResult ruleResult = tableResult.getSingleResult();
            final Double charge = (Double) ruleResult.get("charge");
            return new MessageChargeResult( decision.getKey(),charge);
        } catch (NullPointerException npe) {
            return new MessageChargeResult(decision.getKey(),0d);
        }
    }
}
