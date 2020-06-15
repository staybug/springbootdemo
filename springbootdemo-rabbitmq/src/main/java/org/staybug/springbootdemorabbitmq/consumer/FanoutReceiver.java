/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/11
 * Time: 22:45
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemorabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    //消费queue-one队列中的消息
    @RabbitListener(queues = "queue-one")
    public void handle1(String msg){
        System.out.println("FanoutReceiver-handle1:"+msg);
    }
    //消费queue-two队列中的消息
    @RabbitListener(queues = "queue-two")
    public void handle2(String msg){
        System.out.println("FanoutReceiver-handle2:"+msg);
    }
}
