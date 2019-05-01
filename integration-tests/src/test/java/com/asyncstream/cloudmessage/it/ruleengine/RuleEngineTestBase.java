package com.asyncstream.cloudmessage.it.ruleengine;

import com.asyncstream.cloudmessage.rule.api.engine.RuleEngine;
import com.asyncstream.cloudmessage.rule.impl.RuleEngineConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {RuleEngineConfig.class})
@SpringBootTest
public abstract class RuleEngineTestBase {

    @Autowired
    protected RuleEngine ruleEngine;

}
