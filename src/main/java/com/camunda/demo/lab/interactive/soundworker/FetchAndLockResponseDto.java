package com.camunda.demo.lab.interactive.soundworker;

import java.util.List;
import java.util.Map;

import com.camunda.demo.lab.interactive.participant.adapter.VariableDto;

public class FetchAndLockResponseDto {
  private String activityId;
  private String activityInstanceId;
  private String errorMessage;
  private String executionId;
  private String id;
  private String lockExpirationTime;
  private String processDefinitionId;
  private String processDefinitionKey;
  private String processInstanceId;
  private String tenantId;
  private long retries;
  private String workerId;
  private long priority;
  private String topicName;
  private String errorDetails;
  private boolean suspended;
  private Map<String, VariableDto> variables;
  public String getActivityId() {
    return activityId;
  }
  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }
  public String getActivityInstanceId() {
    return activityInstanceId;
  }
  public void setActivityInstanceId(String activityInstanceId) {
    this.activityInstanceId = activityInstanceId;
  }
  public String getErrorMessage() {
    return errorMessage;
  }
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  public String getExecutionId() {
    return executionId;
  }
  public void setExecutionId(String executionId) {
    this.executionId = executionId;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getLockExpirationTime() {
    return lockExpirationTime;
  }
  public void setLockExpirationTime(String lockExpirationTime) {
    this.lockExpirationTime = lockExpirationTime;
  }
  public String getProcessDefinitionId() {
    return processDefinitionId;
  }
  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }
  public String getProcessDefinitionKey() {
    return processDefinitionKey;
  }
  public void setProcessDefinitionKey(String processDefinitionKey) {
    this.processDefinitionKey = processDefinitionKey;
  }
  public String getProcessInstanceId() {
    return processInstanceId;
  }
  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }
  public String getTenantId() {
    return tenantId;
  }
  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }
  public long getRetries() {
    return retries;
  }
  public void setRetries(long retries) {
    this.retries = retries;
  }
  public String getWorkerId() {
    return workerId;
  }
  public void setWorkerId(String workerId) {
    this.workerId = workerId;
  }
  public long getPriority() {
    return priority;
  }
  public void setPriority(long priority) {
    this.priority = priority;
  }
  public String getTopicName() {
    return topicName;
  }
  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }
  public Map<String, VariableDto> getVariables() {
    return variables;
  }
  public void setVariables(Map<String, VariableDto> variables) {
    this.variables = variables;
  }
  public String getErrorDetails() {
    return errorDetails;
  }
  public void setErrorDetails(String errorDetails) {
    this.errorDetails = errorDetails;
  }
  public boolean isSuspended() {
    return suspended;
  }
  public void setSuspended(boolean suspended) {
    this.suspended = suspended;
  }

}
