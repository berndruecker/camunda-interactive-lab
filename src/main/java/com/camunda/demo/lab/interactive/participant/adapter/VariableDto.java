package com.camunda.demo.lab.interactive.participant.adapter;

public class VariableDto {

  private String type = "String";
  private String value;
  
  public VariableDto() {    
  }

  public String getType() {
    return type;
  }
  public VariableDto type(String type) {
    this.type = type;
    return this;
  }
  public String getValue() {
    return value;
  }
  public VariableDto value(String value) {
    this.value = value;
    return this;
  }
}
