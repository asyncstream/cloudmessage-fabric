package com.asyncstream.cloudmessage.rule.api.model;

import java.util.HashMap;
import java.util.Map;

public abstract class RuleCriteria {
    protected Map<String,Object> contextMap=new HashMap<>();

    public abstract Map<String,Object> contextMap();
}
