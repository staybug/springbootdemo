/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/11
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemorabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitDirectConfig {
    //DirectExchange的名字
    public static final String DIRECTNAME="hello-direct";
    //提供消息队列1
    @Bean
    Queue queue1(){
        return new Queue("hello-queue1");
    }
    //提供消息队列2
    @Bean
    Queue queue2(){
        return new Queue("hello-queue2");
    }
    //提供一个DirectExchange
    @Bean
    DirectExchange directExchange(){
        //三个参数分别是：名字、重启是否依然有效、长期未使用是否删除
        return new DirectExchange(DIRECTNAME,true,false);
    }
    //创建Binding1，将Exchange和Queue1绑定在一起
    @Bean
    Binding binding1(){
        return BindingBuilder.bind(queue1()).to(directExchange()).with("direct1");
    }
    //创建Binding2，将Exchange和Queue2绑定在一起
    @Bean
    Binding binding2(){
        return BindingBuilder.bind(queue2()).to(directExchange()).with("direct2");
    }
}
