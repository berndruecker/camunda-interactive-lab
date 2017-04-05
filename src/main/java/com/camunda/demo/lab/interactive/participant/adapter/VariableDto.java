package com.camunda.demo.lab.interactive.participant.adapter;

public class VariableDto {

  private String type = "String";
  private String value;
  private Object valueInfo;
  
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

  public Object getValueInfo() {
    return valueInfo;
  }

  public void setValueInfo(Object valueInfo) {
    this.valueInfo = valueInfo;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
