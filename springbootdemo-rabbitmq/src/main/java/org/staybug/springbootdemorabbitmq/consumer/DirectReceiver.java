/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/11
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemorabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {
    //消费hello-queue1队列中的消息
    @RabbitListener(queues = "hello-queue1")
    public void handle(String msg){
        System.out.println("DirectReceiver:"+msg);
    }
}
