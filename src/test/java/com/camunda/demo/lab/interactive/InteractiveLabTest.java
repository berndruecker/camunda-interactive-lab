package com.camunda.demo.lab.interactive;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;


import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE, //
    // classes = TestApplication.class, //
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
  
  // @Rule
  // public ProcessEngineRule rule = new ProcessEngineRule();

  @Test
  @Deployment(resources = { "interactive-lab.bpmn" })
  public void testTick() {
    RuntimeService runtimeService = camunda.getRuntimeService();
        
    mockRestServer
      .expect(requestTo("http://" + "localhost:8080" + "/rest/engine/default/message/")) //
      .andExpect(method(HttpMethod.POST))
      .andExpect(jsonPath("$.messageName", is("Message_IHaveDoneIt_Test")))
      .andExpect(jsonPath("$.correlationKeys.event.value", is("test")))
      .andExpect(jsonPath("$.processVariables.name.value", is("bernd")))
      .andRespond(withSuccess());
   
    VariableMap variables = Variables //
        .putValue("host", "localhost:8080") //
        .putValue("event", "test") // 
        .putValue("name", "bernd");

    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Interactive-lab-participant", variables);

    assertThat(processInstance).job(); // safe point for retry behavior
    execute(job());

    assertThat(processInstance).isEnded();     
  }
  
}
