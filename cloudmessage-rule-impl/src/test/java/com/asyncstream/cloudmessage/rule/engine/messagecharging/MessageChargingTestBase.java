package com.asyncstream.cloudmessage.rule.engine.messagecharging;

import com.asyncstream.cloudmessage.rule.engine.RuleEngineTestBase;
import org.assertj.core.api.Assertions;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStream;

import static com.asyncstream.cloudmessage.rule.api.engine.RuleEngine.RuleCode.MESSAGE_CHARGE_RULE;

@RunWith(Parameterized.class)
public class MessageChargingTestBase extends RuleEngineTestBase {

    private static DmnDecision dmnDecision;

    protected double expectedCharge;

    protected static void start() {
        InputStream input = RuleEngineTestBase.class.getResourceAsStream(rulesRootPath+"MESSAGE-CHARGE.dmn");
        dmnDecision = dmnEngine.parseDecision(MESSAGE_CHARGE_RULE, input);
    }

    @Test
    public void validateCharge() {
        Double result = dmnEngine.evaluateDecision(dmnDecision, inputParameters).getSingleResult().getEntry("charge");
        Assertions.assertThat(result).isEqualTo(expectedCharge);
    }
}
