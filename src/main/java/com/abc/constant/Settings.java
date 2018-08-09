package com.abc.constant;

import com.abc.util.SpringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Settings {

    private static Settings settings() {
        return SpringUtil.getBean(Settings.class);
    }

    @Value("${kafka.producer.event-topic:}")
    private String kafkaEventTopic;

    @Value("${kafka.producer.user-topic:}")
    private String kafkaUserTopic;

    public static String getKafkaEventTopic() {
        return settings().kafkaEventTopic;
    }

    public static String getKafkaUserTopic() {
        return settings().kafkaUserTopic;
    }
}
