package com.asyncstream.cloudmessage.rule.engine;

import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.variable.VariableMap;

public abstract  class RuleEngineTestBase {
    protected static String rulesRootPath="/dmn/";
    protected static DmnEngine dmnEngine;

    protected String name;
    protected VariableMap inputParameters;

    static {
        DmnEngineConfiguration config = DmnEngineConfiguration.createDefaultDmnEngineConfiguration();
        dmnEngine = config.buildEngine();
    }


}
