package com.darly.dubbo.root;

import org.mybatis.generator.api.ShellRunner;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/14
 * TODO :
 */
public class GeneratorAppliaction {

    public static void main(String[] args){
        args = new String[] { "-configfile", "D:\\Dubbo\\Dubbo-System\\Dubbo-Web\\src\\main\\resources\\generator\\mybatis-generator-config.xml", "-overwrite" };
        ShellRunner.main(args);
    }

}
