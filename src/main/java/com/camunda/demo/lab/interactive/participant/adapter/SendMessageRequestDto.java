package com.camunda.demo.lab.interactive.participant.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendMessageRequestDto {

  private String messageName;
  private Map<String, VariableDto> correlationKeys = new HashMap<String, VariableDto>();
  private Map<String, VariableDto> processVariables = new HashMap<String, VariableDto>();
  
  public String getMessageName() {
    return messageName;
  }
  public void setMessageName(String messageName) {
    this.messageName = messageName;
  }
  public Map<String, VariableDto> getCorrelationKeys() {
    return correlationKeys;
  }
  public void setCorrelationKeys(Map<String, VariableDto> correlationKeys) {
    this.correlationKeys = correlationKeys;
  }
  public Map<String, VariableDto> getProcessVariables() {
    return processVariables;
  }
  public void setProcessVariables(Map<String, VariableDto> processVariables) {
    this.processVariables = processVariables;
  }
  
}
