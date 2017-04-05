package com.camunda.demo.lab.interactive.soundworker;

import java.util.ArrayList;
import java.util.List;

public class FetchAndLockRequestDto {
  private String workerId;
  private long maxTasks;
  private List<TopicDto> topics = new ArrayList<TopicDto>();
  
  public String getWorkerId() {
    return workerId;
  }
  public void setWorkerId(String workerId) {
    this.workerId = workerId;
  }
  public long getMaxTasks() {
    return maxTasks;
  }
  public void setMaxTasks(long maxTasks) {
    this.maxTasks = maxTasks;
  }
  public List<TopicDto> getTopics() {
    return topics;
  }
  public void setTopics(List<TopicDto> topics) {
    this.topics = topics;
  }
}
