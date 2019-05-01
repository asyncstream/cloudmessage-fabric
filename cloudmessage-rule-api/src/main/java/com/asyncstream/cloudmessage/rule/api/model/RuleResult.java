package com.asyncstream.cloudmessage.rule.api.model;

import java.util.Objects;

public class RuleResult<T> {
    private String ruleCode;
    private T result;

    public RuleResult(String ruleCode, T result) {
        this.ruleCode = ruleCode;
        this.result = result;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public T getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleResult<?> that = (RuleResult<?>) o;
        return Objects.equals(ruleCode, that.ruleCode) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleCode, result);
    }
}
