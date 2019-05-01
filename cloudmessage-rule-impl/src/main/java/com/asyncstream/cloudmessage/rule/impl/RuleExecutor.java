package com.asyncstream.cloudmessage.rule.impl;

import com.asyncstream.cloudmessage.rule.api.model.RuleCriteria;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

abstract class RuleExecutor<R> {
    private final RuleRegistry ruleRegistry;
    private final DmnEngine dmnEngine;

    private final static Logger _LOG = LoggerFactory.getLogger(RuleExecutor.class);

    protected RuleExecutor(RuleRegistry ruleRegistry, DmnEngine dmnEngine) {
        this.ruleRegistry = ruleRegistry;
        this.dmnEngine = dmnEngine;
    }

    public R execute(final String ruleCode, final RuleCriteria criteria){
        return this.execute(this.gerDecisionRule(ruleCode),criteria.contextMap());
    }
    abstract R execute(final DmnDecision decision, final Map<String,Object> contextMap);

    protected RuleRegistry getRuleRegistry() {
        return ruleRegistry;
    }

    protected DmnEngine getDmnEngine() {
        return dmnEngine;
    }

    private DmnDecision gerDecisionRule(String ruleCode){return this.ruleRegistry.getRule(ruleCode);}
}
