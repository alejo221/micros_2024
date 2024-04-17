package com.msexcercise.notificationservice.service;

import com.msexcercise.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @KafkaListener(topics="notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        // sending email or any notification
        log.info("Recieved Notification Order: {}",orderPlacedEvent.getOrderNumber());
    }
}
