package com.stackroute.websocket.config;

import com.stackroute.websocket.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfiguration {

    @Autowired
    SimpMessagingTemplate template;
    @Scheduled(fixedDelay = 3000)
    public void sendAdhocMessage(){
        template.convertAndSend("/topic/user",new UserResponse("Fixed Delay Schedule"));

    }

}
