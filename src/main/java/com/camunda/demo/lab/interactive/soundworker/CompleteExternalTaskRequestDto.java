package com.camunda.demo.lab.interactive.soundworker;

import java.util.HashMap;
import java.util.Map;

import com.camunda.demo.lab.interactive.participant.adapter.VariableDto;

public class CompleteExternalTaskRequestDto {
  private String workerId;
  private Map<String, VariableDto> variables = new HashMap<String, VariableDto>();
  
  public String getWorkerId() {
    return workerId;
  }
  public void setWorkerId(String workerId) {
    this.workerId = workerId;
  }
  public Map<String, VariableDto> getVariables() {
    return variables;
  }
  public void setVariables(Map<String, VariableDto> variables) {
    this.variables = variables;
  }
}