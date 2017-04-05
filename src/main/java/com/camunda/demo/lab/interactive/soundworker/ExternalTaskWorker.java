package com.camunda.demo.lab.interactive.soundworker;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.camunda.demo.lab.interactive.collector.adapter.PlaySoundAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExternalTaskWorker {

  public static String URL = "http://localhost:8080/rest/engine/default";
//  public static String URL = "https://camunda-interactive-lab.cfapps.io/rest/engine/default";
  public static String workerId = "me";
  
  public static void main(String[] args) throws Exception {
    RestTemplate restTemplate = new RestTemplate();
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
    jsonMessageConverter.setObjectMapper(new ObjectMapper());
    messageConverters.add(jsonMessageConverter);
    restTemplate.setMessageConverters(messageConverters); // This line was
                                                          // missing, but needs
                                                          // to be here. See
                                                          // answer.

    FetchAndLockRequestDto request = new FetchAndLockRequestDto();
    request.setWorkerId(workerId);
    request.setMaxTasks(100);
    TopicDto topic = new TopicDto();
    topic.setTopicName("playSound");
    topic.setLockDuration(1000);
    request.getTopics().add(topic);

    while (true) {
      ResponseEntity<FetchAndLockResponseDto[]> response = restTemplate.postForEntity(URL + "/external-task/fetchAndLock", request,
          FetchAndLockResponseDto[].class);
      FetchAndLockResponseDto[] tasks = response.getBody();
      for (FetchAndLockResponseDto task : tasks) {
        String sound = task.getVariables().get("sound").getValue();

         System.out.println("PLAY " + sound);
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(PlaySoundAdapter.class.getResourceAsStream("/sounds/" + sound + ".wav"));
        clip.open(inputStream);
        clip.start();        

        CompleteExternalTaskRequestDto completeRequest = new CompleteExternalTaskRequestDto();
        completeRequest.setWorkerId(workerId);
        restTemplate.postForEntity(URL + "/external-task/" + task.getId() + "/complete", completeRequest, Object.class);
      }
      Thread.sleep(1000);
    }
  }
}
