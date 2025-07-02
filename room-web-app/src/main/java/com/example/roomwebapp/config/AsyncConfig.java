package com.example.roomwebapp.config;

import com.example.roomwebapp.aysnc.RoomCleanerListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AsyncConfig {
    private static final String QUEUE_NAME = "room-cleaner";
    private static final String EXCHANGE_NAME = "operations";

    @Bean
    //定义了一个名为 "room-cleaner" 的队列，true 表示这个队列是 持久化的，RabbitMQ 服务器重启后不会丢失。
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }
    @Bean
    //将 "room-cleaner" 队列绑定到 "operations" 交换机，使用 routing key（路由键）为 "landon.rooms.cleaner"。
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("landon.rooms.cleaner");

    }

    @Bean
    //将你之前写的 RoomCleanerListener 类包装为一个适配器，指定它用的方法是 "receiveMessage"。
    // 这样 Spring Boot 就知道，当有消息到达时，调用哪个方法处理。
    public MessageListenerAdapter listenerAdapter (RoomCleanerListener listener){
        return new MessageListenerAdapter(listener, "receiveMessage");
    }

    @Bean
    //设置消息监听容器
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

}
