package com.camunda.demo.lab.interactive.participant.adapter;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

//@Named
public class SendMessageAdapterSolution implements JavaDelegate {

  @Autowired
  private RestTemplate rest;

  @Override
  public void execute(DelegateExecution ctx) throws Exception {
    String host = (String) ctx.getVariable("host");
    String name = (String) ctx.getVariable("name");
    String event = (String) ctx.getVariable("event");
    String group = (String) ctx.getVariable("group");
    String message = (String) ctx.getVariable("message");    

    SendMessageRequestDto request = new SendMessageRequestDto();
    request.getCorrelationKeys().put("event", new VariableDto().value(event));
    request.getCorrelationKeys().put("group", new VariableDto().value(group));
    request.getProcessVariables().put("name", new VariableDto().value(name));
    request.setMessageName(message);
    rest.postForEntity(
        "http://" + host + "/rest/engine/default/message/",
        request, 
        String.class); 
  }

}
