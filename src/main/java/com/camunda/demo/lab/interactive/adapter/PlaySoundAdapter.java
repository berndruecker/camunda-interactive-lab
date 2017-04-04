package com.camunda.demo.lab.interactive.adapter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PlaySoundAdapter implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Clip clip = AudioSystem.getClip();
    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
        PlaySoundAdapter.class.getResourceAsStream("/path/to/sounds/" + url));
    clip.open(inputStream);
    clip.start(); 
  }

}
