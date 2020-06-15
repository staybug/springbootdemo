/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/11
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemorabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
    @RabbitListener(queues = "xiaomi")
    public void handle1(String msg){
        System.out.println("xiaomiReceiver:"+msg);
    }
    @RabbitListener(queues = "huawei")
    public void handle2(String msg){
        System.out.println("huaweiReceiver:"+msg);
    }
    @RabbitListener(queues = "iphone")
    public void handle3(String msg){
        System.out.println("iphoneReceiver:"+msg);
    }
}
