package com.ruoyi.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
@Component
public class Simple implements InitializingBean, SmartInitializingSingleton {

    public static void main(String[] args) {
        Simple simple = new Simple();

    }
    //依赖注入  下面两个注解只能用一个
    @Resource //JSR133标准里的注解    JDK自带
//    @Autowired  //spring框架里提供的注解
    private Simple simple2;
    //  1 构造方法
    public Simple(){
        System.out.println("1、Simple");
    }

    //  2
    @PostConstruct  //在对象构造方法调用后，第一时间调用
    public void postConstruct(){
        System.out.println("2、执行postConstruct方法");
    }

    /**
     * 我希望对象在创建后，就调用init初始化     4
     */
    public void init(){
        System.out.println("4、执行init方法");
    }

    //init调用完后，初始化我的一些资源
    public void perpareSource(){
        System.out.println("执行perpareSource方法");
    }

    //在调用完资方法之后，执行业务逻辑
    public void doService(){

    }

    //等容器关闭后, 打扫资源空间，清理掉无用的资源   6
//    @PreDestroy       destroyMethod设置可以替换为在clear方法上加上注解@PreDestroy,效果一样
    public void clear(){
        System.out.println("6、调用 clear 方法");
    }

    /**
     *      3
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3、调用 afterPropertiesSet 方法");
    }

    //  5
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("5、调用 afterSingletonsInstantiated 方法");
    }
}