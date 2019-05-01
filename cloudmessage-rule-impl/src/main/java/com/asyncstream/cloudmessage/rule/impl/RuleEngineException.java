package com.asyncstream.cloudmessage.rule.impl;

public class RuleEngineException extends RuntimeException{

    public RuleEngineException(String message) {
        super(message);
    }

    public RuleEngineException(String message, Throwable cause) {
        super(message, cause);
    }
}
