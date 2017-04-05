# camunda-interactive-lab
Interactive lab to do a plublic exercise to get Camunda running on participant machines, communicating with a central cloud Camunda instance to showcase some things - and to play around :-)

# What you need

* Java 8 installed
* Maven 3 installed and working
* Internet connection (for Maven dependencies)
* Preferrably a Java-IDE of your choice (for programming)

# Instructions

Model an executable version of the *participant* flow. 

It will be very easy and just contains:

* Start Event
* Service Task
* End Event

The Service Task shall do a REST request to the Collector. 

In order to define the flow you can either use

* Model API
* Camunda Modeler, which you can download for free: https://camunda.org/download/modeler/

# Hints

## Develop test driven

There is a JUnit testcase in the project. If that testcase turns green, you are ready to go!

Therefor you have to model a BPMN flow in a file named *interactive-lab-solution.bpmn* and save it in the *src/main/resources* folder.

You will have to implement the class *com.camunda.demo.lab.interactive.participant.adapter.SendMessageAdapter* properly, it is only a stub!

## Using model API

If you prefer using the model API, you do not need the modeler. As I do not want to give you the real code here some other model API sample:

```
engine.getRepositoryService().createDeployment().addModelInstance(
  "flowName.bpmn", 
  Bpmn.createExecutableProcess("Order")
          .startEvent()
          .serviceTask().name("Do payment")
              .camundaClass(DoPaymentAdapter.class.getName()).camundaAsyncBefore()
          .sendTask().name("Initiate delivery")
              .camundaClass(InitiateDeliveryAdapter.class.getName())
          .receiveTask().name("Wait for delivery")
              .message("MessageDeliveryDone")
          .endEvent()
          .done()
        );
```

The REST API deployment can be hooked in the *com.camunda.demo.lab.interactive.InteractiveLabApplication* class and will then be used for tests as well as in the real application.

## Doing the REST call and prepare for failure

The *SendMessageAdapter* sends a message to the Collector flow by using the Camunda REST API (https://docs.camunda.org/manual/latest/reference/rest/message/post-message/).

The collector flow will fail in 1 out of two cases by purpose! So prepare your flow to do proper retrying! Hint: you need an additional safe point for doing that, this is named *asynchronousBefore" in Camunda.


## Run the application and start real instances

When the test case is ready start your application by running the *com.camunda.demo.lab.interactive.InteractiveLabApplication* main method. This starts up Spring Boot and Camunda. Now go to http://localhost:8080/index.html and start a new participant flow.

Hint: Use the *Message_IHaveDoneIt_Test* message to see if everything working. When you feel ready send your *Message_IHaveDoneIt* message, please only once. This gets counted.

