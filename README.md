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

## Get started with the model API

## Doing a REST call

This sends a message to the Collector flow by using the Camunda REST API (https://docs.camunda.org/manual/latest/reference/rest/message/post-message/).

## Prepare for failure

## Run the application and start real instances