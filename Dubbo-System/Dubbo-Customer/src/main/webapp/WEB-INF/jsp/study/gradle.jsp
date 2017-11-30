<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/11/24
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${resourceUrl}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <!-- 引入 Bootstrap -->
    <link href="${resourceUrl}/basejs/bootstrap/ace/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourceUrl}/basejs/bootstrap/ace/css/site.min.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<tags:header/>
<div class="container tag-body">
    <h3>Android端使用Gradle打包Library并上传到私服
        <small>此功能实现自主打包，方便其他用户调用</small>
    </h3>
    <p class="text-left">工具：Android Studio、Nexus私服</p>
    <p class="text-left">主要实现aar包上传，和使用的效果</p>
    <div id="article_content" class="article_content tracking-ad" data-mod="popu_307" data-dsm="post">
        <p class="text-left">第一步：打开Android Studio并新建空白项目并上传</p>
        <div class="markdown_views">
            <p>打开项目外层空间的build.gradle输入需要上传的Nexus私服地址
<pre>
allprojects {
    repositories {
        jcenter()
        maven {
            url "http://193.169.100.100:8081/nexus/content/repositories/thirdparty/"
        }
    }
}
</pre>
            </p>
            <p>打开项目外层空间的gradle.properties输入需要上传的Nexus私服地址和登录信息
<pre>
#//正式包仓库地址
repositoryUrl=http://193.169.100.100:8081/nexus/content/repositories/thirdparty/
repositoryUserName=admin
repositoryPassword=admin123
</pre>
            </p>
            <p>建立Library项目，在Library项目的build.gradle中添加
<pre>
apply from:'maven-dview-aar.gradle'
</pre>
            </p>
            <p>在Library项目中建立maven-dview-aar.gradle
<pre>
apply plugin: 'maven'
// 2.maven-信息
ext {// ext is a gradle closure allowing the declaration of global properties
    ARTIFACT_ID = 'dview'
    GROUP_ID = 'com.darly.dview'
}
// 3.maven-输出路径
uploadArchives{
    repositories.mavenDeployer{
        println repositoryUrl
        repository(url:repositoryUrl){
            authentication(userName:repositoryUserName,password:repositoryPassword)
        }
            pom.project{
            groupId project.GROUP_ID
            artifactId project.ARTIFACT_ID
            version android.defaultConfig.versionName
        }
    }
}
//以下代码会生成jar包源文件，如果是不开源码，请不要输入这段
//aar包内包含注释
task sourcesJar(type: Jar) {
    from android.sourceSets.main.java.srcDirs
    classifier = 'sources'
}
task javadoc(type: Javadoc) {
    failOnError = false
    options.encoding ="utf-8"
    source = android.sourceSets.main.java.srcDirs
    ext.androidJar = "${android.sdkDirectory}/platforms/${android.compileSdkVersion}/android.jar"
    classpath += files(ext.androidJar)
}
task javadocJar(type: Jar, dependsOn: javadoc) {
    classifier = 'javadoc'
    from javadoc.destinationDir
}
artifacts {
    archives javadocJar
    archives sourcesJar
}
</pre>
            </p>
            <p>方法一：点击右侧Gradle命令列表，找到Library名称点击Tasks——>upload——>uploadArchives，编辑无错，则发布成功。
            </p>
            <p>方法二：打开Android Studio中的Terminal终端页面，直接输入gradlew uploadArchives，编辑无误，则整体Library全部发布成功
            </p>
        </div>
        <p class="text-left">第二步：打开Android Studio并新建项目使用aar包</p>
        <div class="markdown_views">
            <p>打开项目外层空间的build.gradle输入需要上传的Nexus私服地址
<pre>
allprojects {
    repositories {
        jcenter()
        maven {
            url "http://193.169.100.100:8081/nexus/content/repositories/thirdparty/"
        }
    }
}
</pre>
            </p>
            <p>打开项目APP的build.gradle 在dependencies中进行引用即可
<pre>
compile 'com.darly.dview:dview:1.0.0'
compile 'com.darly.common:common:1.0.0'
</pre>
            </p>
        </div>
    </div>
</div>
    <hr>
    <tags:footer/>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="${resourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="${resourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
</body>
</html>