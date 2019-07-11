package com.lcg.kafka.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lcg.kafka.beans.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: licg
 * @Date: 2019/7/11
 * @Description：
 */

@Slf4j
@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    // send message
    public void send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("message = {}", gson.toJson(message));

        kafkaTemplate.send("kafka", gson.toJson(message));
    }
}