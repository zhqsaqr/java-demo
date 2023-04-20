package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {

    /**
     * 消费
     */
    @KafkaListener(topics = "test-001",groupId = "test3")
    public void listen(String record) {
        System.out.println("【*** 消费者开始接收消息 ***】======" + record);
    }


    /**
     * 批量消费并指定分区
     */
//    @KafkaListener(topicPartitions = { @TopicPartition(topic = "test", partitions = {"2" })})
//    public void listenBatch(List<ConsumerRecord<String, String>> records) {
//        System.out.println("【*** 消费者批量开始接收消息 ***大小】======" + records.size());
//        records.forEach(record -> System.out.println("【*** 消费者批量开始接收消息 ***】======" + record.value()));
//    }


}
