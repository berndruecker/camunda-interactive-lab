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
    
//    engine.getRuntimeService().startProcessInstanceByKey("SendAmqpTest");

    // and add default users to Camunda to be ready-to-go
//    UserGenerator.createDefaultUsers(engine);
//    LicenseHelper.setLicense(engine);
    
//    // create default "all tasks" filter
//    addFilterUserAuthorization(engine, "demo", FILTER_alleAufgaben);    
//    
//    String clientManager = FilterGenerator.createFilter(engine, "Client Manager", 50, "Tasks for Client Manager", //
//        engine.getTaskService().createTaskQuery().taskCandidateGroupIn(Arrays.asList("ClientManager")).taskUnassigned());    
//    authorizeForFilter(engine, "demo",  clientManager);
//
//    String underwriter = FilterGenerator.createFilter(engine, "Underwriter", 40, "Tasks for Underwriter", //
//        engine.getTaskService().createTaskQuery().taskCandidateGroupIn(Arrays.asList("Underwriter")).taskUnassigned());
//    authorizeForFilter(engine, "demo",  underwriter);
//
//    String catAnalyst = FilterGenerator.createFilter(engine, "Cat Analyst", 30, "Tasks for CAT Analyst", //
//        engine.getTaskService().createTaskQuery().taskCandidateGroupIn(Arrays.asList("CatAnalyst")).taskUnassigned());
//    authorizeForFilter(engine, "demo",  catAnalyst);

//    VariableMap variables = Variables.createVariables();
//    List<String> alternativen = new ArrayList<String>();
//    alternativen.add("alternative1");
//    alternativen.add("alternative2");
//    variables.put("alternatives", Variables.objectValue(alternativen).serializationDataFormat(SerializationDataFormats.JSON).create());
//    ProcessInstance pi = engine.getRuntimeService().startProcessInstanceByKey("Underwriting", variables);
//

  }

//  private static void authorizeForFilter(ProcessEngine engine, String userId,  String filterId) {
//    Authorization managementGroupFilterRead = engine.getAuthorizationService().createNewAuthorization(Authorization.AUTH_TYPE_GRANT);
//    managementGroupFilterRead.setResource(FILTER);
//    managementGroupFilterRead.setResourceId(filterId);
//    managementGroupFilterRead.addPermission(READ);
//    managementGroupFilterRead.setUserId(userId);
//    engine.getAuthorizationService().saveAuthorization(managementGroupFilterRead);
//  }

}
