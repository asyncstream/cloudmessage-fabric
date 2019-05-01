package com.asyncstream.cloudmessage.rule.api.engine;

import com.asyncstream.cloudmessage.rule.api.model.MessageChargingCriteria;
import com.asyncstream.cloudmessage.rule.api.model.MessageChargeResult;

public interface RuleEngine {
    public class RuleCode{
        public static String MESSAGE_CHARGE_RULE;

        static {
            MESSAGE_CHARGE_RULE = "MESSAGE-CHARGE";
        }
        private RuleCode(){}
    }

    public MessageChargeResult executeMessageChargingRule(String code, MessageChargingCriteria criteria);
}
