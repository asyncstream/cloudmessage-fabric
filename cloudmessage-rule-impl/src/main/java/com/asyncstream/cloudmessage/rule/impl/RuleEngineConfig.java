package com.asyncstream.cloudmessage.rule.impl;

import com.asyncstream.cloudmessage.rule.api.engine.RuleEngine;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleEngineConfig {

    @Bean
    public DmnEngine dmnEngine(){
        return DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();
    }

    @Bean
    public RuleRegistry ruleRegistry(final DmnEngine dmnEngine, @Value("${cloudmessage.rules.dmn-path}") final String ruleRepositoryPath){
        return new RuleRegistry(dmnEngine,ruleRepositoryPath);
    }

    @Bean
    public MessageChargingRuleExecutor messageChargingRuleExecutor(final RuleRegistry ruleRegistry,final DmnEngine dmnEngine) {
        return new MessageChargingRuleExecutor(ruleRegistry,dmnEngine);
    }

    @Bean
    public RuleEngine ruleEngine(final MessageChargingRuleExecutor messageChargingRuleExecutor){
        return new RuleEngineImpl(messageChargingRuleExecutor);
    }

}
