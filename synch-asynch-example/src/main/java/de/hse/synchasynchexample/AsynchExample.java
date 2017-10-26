package de.hse.synchasynchexample;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Corvin on 25.10.2017.
 */
public class AsynchExample {

    class AMQPConfig{
        @Bean
        public Queue hello(){
            return new Queue("hello-queue");
        }

        @Bean
        public AMQPSender sender(){
            return new AMQPSender();
        }

        @Bean
        public AMQPReceiver receiver(){
            return new AMQPReceiver();
        }
    }

    class AMQPSender{

        @Autowired
        RabbitTemplate template;

        @Autowired
        private Queue queue;

        public void sendToQueue(String message){
            template.convertAndSend(queue.getName(), message);
            System.out.println("AMQPSender send message to Receiver: " + message);
        }
    }

    @RabbitListener(queues = "hello-queue")
    class AMQPReceiver{
        List<String> messageList = new LinkedList<>();
        @RabbitHandler
        public void receiveFromQueue(String input){
            System.out.println("AMQPReceiver took message from queue: " + input);
            messageList.add(input);
        }
    }
}
