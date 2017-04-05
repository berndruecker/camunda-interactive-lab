package com.camunda.demo.lab.interactive.collector.adapter;

import javax.inject.Named;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class PlaySoundAdapter implements JavaDelegate {
  
  private Expression sound;

  @Override
  public void execute(DelegateExecution ctx) throws Exception {
    Clip clip = AudioSystem.getClip();
    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
        PlaySoundAdapter.class.getResourceAsStream("/sounds/" + sound.getValue(ctx) + ".wav"));
    clip.open(inputStream);
    clip.start(); 
  }

}
