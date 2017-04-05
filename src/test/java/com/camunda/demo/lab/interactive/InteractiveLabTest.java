package com.camunda.demo.lab.interactive;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareAssertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.execute;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.job;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE, //
    properties = { //
        "camunda.bpm.job-execution.enabled=false", //
        "camunda.bpm.auto-deployment-enabled=false" })
public class InteractiveLabTest {

  @Autowired
  private ProcessEngine camunda;
  
  @Autowired
  private RestTemplate restTemplate;

  private MockRestServiceServer mockRestServer;

  @Before
  public void setup() throws Exception {
    mockRestServer = MockRestServiceServer.createServer(restTemplate);
  }  

  @Test
  @Deployment(resources = {"interactive-lab-solution.bpmn" })
  public void testTick() {
    RuntimeService runtimeService = camunda.getRuntimeService();
        
    mockRestServer
      .expect(requestTo("http://" + "localhost:8080" + "/rest/engine/default/message/")) //
      .andExpect(method(HttpMethod.POST))
      .andExpect(jsonPath("$.messageName", is("Message_IHaveDoneIt_Test")))
      .andExpect(jsonPath("$.correlationKeys.event.value", is("test")))
      .andExpect(jsonPath("$.correlationKeys.group.value", is("a")))
      .andExpect(jsonPath("$.processVariables.name.value", is("bernd")))
      .andRespond(withSuccess());
   
    VariableMap variables = Variables //
        .putValue("host", "localhost:8080") //
        .putValue("event", "test") // 
        .putValue("name", "bernd") //
        .putValue("group", "a") //
        .putValue("message", "Message_IHaveDoneIt_Test");

    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("interactive-lab-participant", variables);

    assertThat(processInstance).job(); // safe point for retry behavior
    execute(job());

    assertThat(processInstance).isEnded();     
  }
  
}
