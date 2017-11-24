package com.darly.common;


import com.darly.common.observer.AbstractDesigner;
import com.darly.common.observer.DesignListener;
import com.darly.common.observer.InitCfg;


/**
 * 工具集合类调用初始化方法。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class Common {
    /**
     * @version 指定版本信息
     * @since   指定最早出现在哪个版本
     * @author  指定作者
     * @see   生成参考其他的JavaDoc文档的连接
     * @link   生成参考其他的JavaDoc文档，它和@see标记的区别在于，@link标记能够嵌入到注释语句中，为注释语句中的特殊词汇生成连接。  eg.{@link Hello}
     * @deprecated 用来注明被注释的类、变量或方法已经不提倡使用，在将来的版本中有可能被废弃
     */
    //@param 描述方法的参数
    //@return 描述方法的返回值
    //@throws   描述方法抛出的异常，指明抛出异常的条件

    /**
     * 观察者模式中的响应者。
     */
    protected static DesignListener design;

    /**
     * 对工具类进行初始化方法，在主项目的Application中进行初始化调用。
     * @return DesignListener
     */
    public static DesignListener init(){
        //在這裡對DView中的組件進行初始化變量操作
        design = new AbstractDesigner();
        design.addObserver(InitCfg.getInstance());
        return design;
    }
}
