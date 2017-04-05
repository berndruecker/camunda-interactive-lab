package com.camunda.demo.lab.interactive.soundworker;

public class TopicDto {

  private String topicName;
  private long lockDuration;
  
  public String getTopicName() {
    return topicName;
  }
  public void setTopicName(String topicId) {
    this.topicName = topicId;
  }
  public long getLockDuration() {
    return lockDuration;
  }
  public void setLockDuration(long lockDuration) {
    this.lockDuration = lockDuration;
  }
}
