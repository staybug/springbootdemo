/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/11
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemorabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig {
    public static final String FANOUTNAME="hello-fanout";
    //提供一个FanoutExchange
    @Bean
    FanoutExchange fanoutExchange(){
        //三个参数含义：FanoutExchange的名字、重启是否依然有效、长时间未使用是否删除
        return new FanoutExchange(FANOUTNAME,true,false);
    }
    //提供两个队列
    @Bean
    Queue queueOne(){
        return new Queue("queue-one");
    }
    @Bean
    Queue queueTwo(){
        return new Queue("queue-two");
    }
    //将这两个队列绑定到FanoutExchange上
    @Bean
    Binding bindingOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }
    @Bean
    Binding bindingTwo(){
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}
