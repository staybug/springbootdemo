/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/11
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemorabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
    public static final String TOPICNAME="hello-topic";
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPICNAME,true,false);
    }
    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }
    @Bean
    Queue huawei(){
        return new Queue("huawei");
    }
    @Bean
    Queue iphone(){
        return new Queue("iphone");
    }
    @Bean
    Binding xiaomiBinding(){
        // 凡是 routingkey 以 "xiaomi" 开头的消息，都被路由到 xiaomi 这个 Queue 上
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xiaomi.#");
    }
    @Bean
    Binding huaweiBinding(){
        // 凡是 routingkey 以 "huawei" 开头的消息，都被路由到 huiwei 这个 Queue 上
        return BindingBuilder.bind(huawei()).to(topicExchange()).with("huawei.#");
    }
    @Bean
    Binding iphoneBinding(){
        // 凡是 routingkey 中包含 "iphone" 的消息，都被路由到 iphone 这个 Queue 上
        return BindingBuilder.bind(iphone()).to(topicExchange()).with("#.iphone.#");
    }
}
