package org.example;


import org.springframework.stereotype.Component;


/**
 * TODO: Inversion of Control и Dependency Injection ,
 */
@Component
public class BeanOne {
    private BeanTwo beanTwo;


    public BeanOne(BeanTwo beanTwo) {
        this.beanTwo = beanTwo;
    }

    public void sayBeanOne() {
        System.out.println("Я - бин номер один");
    }
}
