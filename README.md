# DLL
数据库信息
# dubbo
dubbo项目源码
# Dubbo-Mobile
Android 手机控件工具集合
# Dubbo-Mobile-Trasing
Android测试应用
# Dubbo-System
使用Dubbo编辑的服务端程序
# nginx redis
分布式架构所需工具
# zookeeper-3.5.3-beta
Dubbo注册机制。

## Dubbo-Mobile 工具和控件集合体使用方法：
简介：集合包括两个方面，DView和Common
DView 主要是使用过或者好点的控件集合
Common 主要是网络请求，以及一些辅助工具。
1.如何使用？
由于两个集合是独立使用，互不干涉。所以可以选择使用一个或者全部使用。
这里只介绍Android Studio导入方案：
''
implementation 'com.darly.dview:DView:1.0.4'
implementation 'com.darly.common:Common:0.0.1'
''
导入下载成功后，在Android项目中建立Application启动类。
并且对DView或者Common进行初始化使用。

//3.初始化其他部件
DView.init().notifyInit(BuildConfig.DEBUG, this);//初始化自定义控件集合
Common.init().init(this, "student");//初始化工具类中的缓存集合
Common.init().initDlog(BuildConfig.DEBUG, "student");//初始化工具类中的日志
Common.init().initRetrofit(getVersionCode(), BaseConfig.getRequestUrl(), new RetrofitCfg());//初始化工具类中的网络请求模块

common中使用网络工具，重写请求头文件信息。
public class RetrofitCfg implements RxobsListener {
    @Override
    public Request.Builder initHeader(Request.Builder builder) {
          //在这里添加请求头信息。
        return builder;
    }
}

common中使用网络工具，需要定义接口地址信息
public interface HttpInterface  {
    //这里定义所有的接口地址信息。
    @GET("/")
    Observable<JsonObject> getNews(@Query("appid") String appid,@Query("date") String date);
}


2.包含什么？
DView使用观察者模式进行注册使用，将原始信息传递进DView中进行使用
1).注意：当初始化完成后SCfg类中已经获取到了设备宽高基本信息。
2).注意：InitBinder.InitAll(this);仿照ButterKnife注解框架编辑的超轻量级的注入库，注解；初始化完成后即可使用：

@ContentBinder(R.layout.activity_main)
public class MainActivity extends BaseActivity  {
    @ViewsBinder(R.id.id_base_title)
    public TitleView id_base_title;
    .....
}

3).重写Button控件DSubButton，可以在点击后出现loading图标，并在完成操作后，恢复初始状态。
   重写Camera控件CameraActivity，可以拍摄照片，选择照片，以及在照片上添加水印。
   重写EditText控件，ClearEditText ViewEditText ViewEditTextEx 可以完成清空操作。
   编辑控件CouponDisplayView，实现带凹凸边缘的布局控件。
   重写Dialog控件，ItemSelectView，可以完成列表弹出选取功能。
   编辑组合控件TitleView，实现顶部标题栏功能。
   重写ImageView控件SmoothImageView，完成2d平滑变化的显示图片的ImageView
   重写列表控件WholeGridView  WholeListView  WholeScrollView CustomExpandableListView
   编辑加载loading控件，ShowLoading  CircleProgress
   整合XlistView控件。

Common使用观察者模式进行注册使用，将原始信息传递进Conmmon中进行使用
1). 包含DLog控件，日志输出控件。
    包含Retrofit网络请求控件。
    包含Toast重写控件。
    包含加密解密控件。
    包含保存对象到Share类。