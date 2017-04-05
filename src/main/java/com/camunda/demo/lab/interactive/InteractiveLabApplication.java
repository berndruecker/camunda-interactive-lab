package com.camunda.demo.lab.interactive;


import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EnableProcessApplication
@ComponentScan
public class InteractiveLabApplication {

  public static void main(String... args) {
    SpringApplication.run(InteractiveLabApplication.class, args);   

    // do default setup of platform (everything is only applied if not yet there)
    ProcessEngine engine = BpmPlatform.getDefaultProcessEngine();
    
//    engine.getRepositoryService().createDeployment().addModelInstance(
//        "flowName.bpmn", 
//        modelInstance);
  }


}
