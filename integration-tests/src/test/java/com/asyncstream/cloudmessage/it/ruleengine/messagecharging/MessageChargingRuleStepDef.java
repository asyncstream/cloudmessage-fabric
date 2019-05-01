package com.asyncstream.cloudmessage.it.ruleengine.messagecharging;

import com.asyncstream.cloudmessage.it.ruleengine.RuleEngineTestBase;
import com.asyncstream.cloudmessage.rule.api.model.MessageChargingCriteria;
import com.asyncstream.cloudmessage.rule.api.model.MessageChargeResult;
import cucumber.api.java8.En;
import org.junit.Assert;
import static com.asyncstream.cloudmessage.rule.api.engine.RuleEngine.RuleCode.MESSAGE_CHARGE_RULE;

public class MessageChargingRuleStepDef extends RuleEngineTestBase implements En {

    private String licenseType;
    private Long messageCount;
    private Double result;

    public MessageChargingRuleStepDef(){

        Given("the license type is LIC-FREE", () -> {
            this.licenseType = "LIC-FREE";
        });

        When("the message count is {long}", (Long messageCount) -> {
            this.messageCount = messageCount;
        });

        Then("calculate the charge", () -> {
            MessageChargingCriteria messageChargingCriteria = new MessageChargingCriteria(this.licenseType,this.messageCount);
            MessageChargeResult messageChargeResult=this.ruleEngine.executeMessageChargingRule(MESSAGE_CHARGE_RULE, messageChargingCriteria);
            this.result = messageChargeResult.getResult();
        });

        Then("the charge is {double}", (Double expectedResult) -> {
            Assert.assertEquals(expectedResult,this.result);
        });
    }
}
