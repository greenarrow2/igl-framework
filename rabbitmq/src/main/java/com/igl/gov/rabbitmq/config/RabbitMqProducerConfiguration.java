package com.igl.gov.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * RabbitMq 生产者配置
 */
@Configuration
public class RabbitMqProducerConfiguration {

    final static String message = "topic.message";

    final static String messages = "topic.messages";

    final static String exchange = "exchange";

    final static String topics = "topic.#";

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory factory){
          return  new RabbitAdmin(factory);
    }

    @Bean
    public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
        RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
        rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
        rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
        return rabbitMessagingTemplate;
    }
    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        return converter;
    }

    @Bean
   public Queue queueMessage(){
       return new Queue(RabbitMqProducerConfiguration.message);
   }

    @Bean
    public Queue queueMessages(){
        return new Queue(RabbitMqProducerConfiguration.messages);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(RabbitMqProducerConfiguration.exchange);
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(RabbitMqProducerConfiguration.message);
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with(RabbitMqProducerConfiguration.topics);
    }
}
