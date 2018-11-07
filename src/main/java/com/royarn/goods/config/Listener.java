package com.royarn.goods.config;

import com.google.gson.Gson;
import com.royarn.goods.entity.MsgInfo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author dell
 * @date 2018-11-05
 */
public class Listener {

    private final Logger logger = LoggerFactory.getLogger(Listener.class);

    @Resource
    private MongoTemplate template;

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
        template.insert(new Gson().fromJson(record.value().toString(), MsgInfo.class));
    }
}
