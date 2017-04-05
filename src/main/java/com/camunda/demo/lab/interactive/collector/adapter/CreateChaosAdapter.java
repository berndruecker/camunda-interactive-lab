package com.camunda.demo.lab.interactive.collector.adapter;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class CreateChaosAdapter implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    
  }

}
