package org.example;


import org.springframework.stereotype.Component;


/**
 * TODO: Inversion of Control и Dependency Injection ,
 */
@Component
public class BeanTwo {
    public void sayBeanTwo() {
        System.out.println("Я - бин с номером два");
    }
}
