package com.asyncstream.cloudmessage.rule.impl;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.asyncstream.cloudmessage.rule.api.engine.RuleEngine.RuleCode.MESSAGE_CHARGE_RULE;

public class RuleRegistry {

    private Map<String, DmnDecision> registry = new ConcurrentHashMap<>();

    private final DmnEngine dmnEngine;

    private final String rulesRootPath;

    public RuleRegistry(final DmnEngine dmnEngine,final String ruleRepositoryPath){
        this.dmnEngine=dmnEngine;
        this.rulesRootPath=ruleRepositoryPath;
        if (StringUtils.isEmpty(rulesRootPath)) {
            throw new RuleEngineException("The policy rule resource path is empty!");
        }
        loadAll();
    }
    private void loadAll(){
        register(MESSAGE_CHARGE_RULE);
    }
    private void register(String ruleCode){this.registry.put(ruleCode,createDmnDecision(ruleCode));}

    public DmnDecision getRule(String ruleCode){return this.registry.get(ruleCode);}

    private DmnDecision createDmnDecision(String ruleCode){
        String rulePath=new StringBuilder(this.rulesRootPath).append("/").append(ruleCode).append(".dmn").toString();

        InputStream input = ruleFileStream(rulePath);
        return this.dmnEngine.parseDecision(ruleCode,input);
    }

    private InputStream ruleFileStream(String rulePath){
        Path path = Paths.get(rulePath);
        if(Files.isReadable(path)){
            try{
                return Files.newInputStream(path, StandardOpenOption.READ);
            }catch (IOException ioe){
                throw new RuleEngineException("Error while reading the DMN file definition from path: "+rulePath,ioe);
            }
        }
        return this.getClass().getResourceAsStream(rulePath);
    }


}
