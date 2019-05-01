package com.asyncstream.cloudmessage.it.ruleengine.messagecharging;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/rules-test/messagecharging/free-tier.feature",
        glue = "com.asyncstream.cloudmessage.it.ruleengine.messagecharging",
        plugin = {"pretty", "html:target/cucumber"})
public class MessageChargingRulesIT {
}
