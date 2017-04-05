package com.camunda.demo.lab.interactive.collector.adapter;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class CreateChaosAdapter implements JavaDelegate {

  private static int counter = 0;
  
  @Override
  public void execute(DelegateExecution ctx) throws Exception {
    counter++;
    if (counter > 2) {
      counter = 1;
    }
    if (counter==1) {
      throw new RuntimeException("I am a chaos monkey and trow errors!");
    } else {
    }
  }

}
