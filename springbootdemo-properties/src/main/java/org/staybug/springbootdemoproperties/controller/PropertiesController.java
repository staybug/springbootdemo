/**
 * Created by IntelliJ IDEA.
 * User: zxs
 * Date: 2020/6/15
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
package org.staybug.springbootdemoproperties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.staybug.springbootdemoproperties.pojo.People;

@RestController
public class PropertiesController {
    @Autowired
    People people;
    @GetMapping(value = "/name")
    public String getName(){
        String name = people.getName();
        System.out.println(name);
        return name;
    }
}
