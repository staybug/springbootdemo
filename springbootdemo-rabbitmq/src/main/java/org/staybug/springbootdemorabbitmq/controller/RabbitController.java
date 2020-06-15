/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/11
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemorabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.staybug.springbootdemorabbitmq.config.RabbitDirectConfig;
import org.staybug.springbootdemorabbitmq.config.RabbitFanoutConfig;
import org.staybug.springbootdemorabbitmq.config.RabbitTopicConfig;

@RestController
public class RabbitController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @GetMapping("/direct")
    public void sendToDirect(){
        //路由消息到routingKey为direct1的队列中
        rabbitTemplate.convertAndSend(RabbitDirectConfig.DIRECTNAME,"direct1","hello direct");
    }
    @GetMapping("/fanout")
    public void sendToFanout(){
        //发送消息到所有与FanoutExchange绑定的队列中
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"hello fanout");
    }
    @GetMapping("/topic")
    public void sendToTopic(){
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.news","小米新闻");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.iphone","小米手机");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"iphone.news","苹果新闻");
    }
}
