package com.lcg.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: licg
 * @Date: 2019/7/11
 * @Description：
 */

@Slf4j
@Component
public class KafkaReceiver {
    @KafkaListener(topics = "kafka")
    public void listen(ConsumerRecord<?, ?> cr){
        Optional<?> kafkaMsg = Optional.ofNullable(cr.value());

        if (kafkaMsg.isPresent()){
            Object msg = kafkaMsg.get();
            log.info("ConsumerRecord = {}", cr);
            log.info("msg = {}", msg);
        }
    }
}