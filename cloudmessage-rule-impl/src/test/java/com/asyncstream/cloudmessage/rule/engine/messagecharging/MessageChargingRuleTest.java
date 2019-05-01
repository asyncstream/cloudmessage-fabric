package com.asyncstream.cloudmessage.rule.engine.messagecharging;

import org.camunda.bpm.engine.variable.Variables;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MessageChargingRuleTest extends MessageChargingTestBase {

    @BeforeClass
    public static void init() {
        start();
    }

    public MessageChargingRuleTest(String licenseType, long messageCount, double expectedCharge, String name) {
        this.name = name;
        inputParameters = Variables.createVariables()
                .putValue("licenseType", licenseType)
                .putValue("messageCount", messageCount);
        this.expectedCharge = expectedCharge;
    }

    @Parameterized.Parameters(name = "{4}")
    public static Collection<Object[]> testCaseData() {
        return Arrays.asList(new Object[][]{
                {"LIC-FREE", 100000,0, "Free Tier::Calculate charge for message count < 1000000"},
                {"LIC-GOLD", 1000000,0, "Gold Tier::Calculate charge for message count < 1000000"},
                {"LIC-PREMIUM", 5000000,0, "Premium Tier::Calculate charge for message count < 1000000"}
        });
    }



}
