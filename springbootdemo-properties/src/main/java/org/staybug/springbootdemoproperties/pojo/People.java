/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/15
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemoproperties.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dev")
//加载application-dev.properties配置文件,并设置加载编码方式为utf-8
@PropertySource(value = "classpath:application-dev.properties",encoding = "utf-8")
public class People {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
