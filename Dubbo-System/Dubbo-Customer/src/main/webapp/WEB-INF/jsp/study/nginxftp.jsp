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
    <h3>Nginx静态服务器
        <small>建立Nginx静态服务端的步骤和遇到的情况</small>
    </h3>
    <p class="text-left">工具：Ubuntu Server、Nginx、Vsftpd、Windows FileZilla Client</p>
    <p class="text-left">主要安装Nginx做静态资源服务器，并使用Ftp进行及时更新资源完成简单的ApiDoc文档展示效果</p>
    <p class="text-left">第一步：安装Ubuntu Server（下载镜像直接安装）</p>
    <p class="text-left">第二步：在Windows环境下下载Windows FileZilla Client 并进行安装（ftp客户端，上传文件到服务端）</p>
    <p class="text-left">第三步：在Ubuntu Server端安装Vsftpd工具</p>
    <p class="text-left">在命令窗口中进行账户登录，可以是普通用户，也可以是Root用户，命令差别为普通用户权限命令前加sudo</p>
    <div id="article_content" class="article_content tracking-ad" data-mod="popu_307" data-dsm="post">
        <div class="markdown_views"><p>
            首先说明一下，我是在虚拟机中装的Ubuntu14.04，物理机是Win10，最初只是为了在两个系统间传输文件才在Ubuntu中安装了ftp服务器，从Windows端登陆其即可。最初也是按照网上的各种教程来配置，结果就是喜闻乐见的各种报错不能用，或者说无法登陆等等。这里，分享一下我自己的配置过程，按照步骤来就没有问题。</p>

            <p><em>我对ftp服务器的需求是：</em></p>

            <ol>
                <li>不允许匿名访问，因为我不想其他机器随便都能登陆上来；</li>
                <li>锁定一个共享目录，在这个目录下我可以上传和下载文件，进行文件共享；</li>
                <li>不单独建立ftp用户，本机就可以访问；</li>
            </ol>

            <p>好了，开始安装。</p>

            <pre class="prettyprint" name="code"><code class="hljs bash has-numbering"><span
                    class="hljs-built_in">sudo</span> apt-get install vsftpd </code></pre>

            <p>很快就可以安装完成。 <br>
                <img src="http://img.blog.csdn.net/20170613144502164?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""> <br>
                接下来配置vsftpd.conf文件，位于etc目录下。</p>

            <pre class="prettyprint" name="code"><code class="hljs bash has-numbering"><span
                    class="hljs-built_in">sudo</span> gedit /etc/vsftpd.conf</code></pre>

            <p>更改相应的配置：</p>

            <p>1、我不希望别人匿名登陆： <br>
                <img src="http://img.blog.csdn.net/20170613144829422?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>2、锁定一个共享目录：（自己指定一个文件夹就可以，我用的是/home/xhb/ftp） <br>
                <img src="http://img.blog.csdn.net/20170613145045291?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>3、本机可以访问： <br>
                <img src="http://img.blog.csdn.net/20170613145412871?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>4、允许写操作： <br>
                <img src="http://img.blog.csdn.net/20170613145330714?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>5、不单独建立ftp用户，直接使用Ubuntu桌面用户就可以登陆： <br>
                <img src="http://img.blog.csdn.net/20170613145820107?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""> <br>
                这里有用到/etc/vsftpd.chroot_list这个文件，没有就新建立一个：</p>

            <pre class="prettyprint" name="code"><code class="hljs bash has-numbering"><span
                    class="hljs-built_in">sudo</span> gedit /etc/vsftpd.chroot_list</code></pre>

            <p>在文件中填入允许登陆的账号名。（我的桌面用户名是xhb，也可以添加其他用户名） <br>
                <img src="http://img.blog.csdn.net/20170613150242112?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>然后配置接OK了。</p>

            <p>完整配置文件（/etc/vsftpd.conf）：</p>

            <pre class="prettyprint" name="code"><code class="hljs vala has-numbering"><span class="hljs-preprocessor"># Example config file /etc/vsftpd.conf</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># The default compiled in settings are fairly paranoid. This sample file</span>
    <span class="hljs-preprocessor"># loosens things up a bit, to make the ftp daemon more usable.</span>
    <span class="hljs-preprocessor"># Please see vsftpd.conf.5 for all compiled in defaults.</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># READ THIS: This example file is NOT an exhaustive list of vsftpd options.</span>
    <span class="hljs-preprocessor"># Please read the vsftpd.conf.5 manual page to get a full idea of vsftpd's</span>
    <span class="hljs-preprocessor"># capabilities.</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Run standalone?  vsftpd can run either from an inetd or as a standalone</span>
    <span class="hljs-preprocessor"># daemon started from an initscript.</span>
    listen=YES
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Run standalone with IPv6?</span>
    <span class="hljs-preprocessor"># Like the listen parameter, except vsftpd will listen on an IPv6 socket</span>
    <span class="hljs-preprocessor"># instead of an IPv4 one. This parameter and the listen parameter are mutually</span>
    <span class="hljs-preprocessor"># exclusive.</span>
    <span class="hljs-preprocessor">#listen_ipv6=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Allow anonymous FTP? (Disabled by default)</span>
    anonymous_enable=NO
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Uncomment this to allow local users to log in.</span>
    local_enable=YES
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Uncomment this to enable any form of FTP write command.</span>
    write_enable=YES
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Default umask for local users is 077. You may wish to change this to 022,</span>
    <span class="hljs-preprocessor"># if your users expect that (022 is used by most other ftpd's)</span>
    <span class="hljs-preprocessor">#local_umask=022</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Uncomment this to allow the anonymous FTP user to upload files. This only</span>
    <span class="hljs-preprocessor"># has an effect if the above global write enable is activated. Also, you will</span>
    <span class="hljs-preprocessor"># obviously need to create a directory writable by the FTP user.</span>
    <span class="hljs-preprocessor">#anon_upload_enable=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Uncomment this if you want the anonymous FTP user to be able to create</span>
    <span class="hljs-preprocessor"># new directories.</span>
    <span class="hljs-preprocessor">#anon_mkdir_write_enable=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Activate directory messages - messages given to remote users when they</span>
    <span class="hljs-preprocessor"># go into a certain directory.</span>
    dirmessage_enable=YES
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># If enabled, vsftpd will display directory listings with the time</span>
    <span class="hljs-preprocessor"># in  your  local  time  zone.  The default is to display GMT. The</span>
    <span class="hljs-preprocessor"># times returned by the MDTM FTP command are also affected by this</span>
    <span class="hljs-preprocessor"># option.</span>
    use_localtime=YES
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Activate logging of uploads/downloads.</span>
    xferlog_enable=YES
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Make sure PORT transfer connections originate from port 20 (ftp-data).</span>
    connect_from_port_20=YES
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># If you want, you can arrange for uploaded anonymous files to be owned by</span>
    <span class="hljs-preprocessor"># a different user. Note! Using "root" for uploaded files is not</span>
    <span class="hljs-preprocessor"># recommended!</span>
    <span class="hljs-preprocessor">#chown_uploads=YES</span>
    <span class="hljs-preprocessor">#chown_username=whoever</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may override where the log file goes if you like. The default is shown</span>
    <span class="hljs-preprocessor"># below.</span>
    <span class="hljs-preprocessor">#xferlog_file=/var/log/vsftpd.log</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># If you want, you can have your log file in standard ftpd xferlog format.</span>
    <span class="hljs-preprocessor"># Note that the default log file location is /var/log/xferlog in this case.</span>
    <span class="hljs-preprocessor">#xferlog_std_format=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may change the default value for timing out an idle session.</span>
    <span class="hljs-preprocessor">#idle_session_timeout=600</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may change the default value for timing out a data connection.</span>
    <span class="hljs-preprocessor">#data_connection_timeout=120</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># It is recommended that you define on your system a unique user which the</span>
    <span class="hljs-preprocessor"># ftp server can use as a totally isolated and unprivileged user.</span>
    <span class="hljs-preprocessor">#nopriv_user=ftpsecure</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Enable this and the server will recognise asynchronous ABOR requests. Not</span>
    <span class="hljs-preprocessor"># recommended for security (the code is non-trivial). Not enabling it,</span>
    <span class="hljs-preprocessor"># however, may confuse older FTP clients.</span>
    <span class="hljs-preprocessor">#async_abor_enable=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># By default the server will pretend to allow ASCII mode but in fact ignore</span>
    <span class="hljs-preprocessor"># the request. Turn on the below options to have the server actually do ASCII</span>
    <span class="hljs-preprocessor"># mangling on files when in ASCII mode.</span>
    <span class="hljs-preprocessor"># Beware that on some FTP servers, ASCII support allows a denial of service</span>
    <span class="hljs-preprocessor"># attack (DoS) via the command "SIZE /big/file" in ASCII mode. vsftpd</span>
    <span class="hljs-preprocessor"># predicted this attack and has always been safe, reporting the size of the</span>
    <span class="hljs-preprocessor"># raw file.</span>
    <span class="hljs-preprocessor"># ASCII mangling is a horrible feature of the protocol.</span>
    <span class="hljs-preprocessor">#ascii_upload_enable=YES</span>
    <span class="hljs-preprocessor">#ascii_download_enable=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may fully customise the login banner string:</span>
    <span class="hljs-preprocessor">#ftpd_banner=Welcome to blah FTP service.</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may specify a file of disallowed anonymous e-mail addresses. Apparently</span>
    <span class="hljs-preprocessor"># useful for combatting certain DoS attacks.</span>
    <span class="hljs-preprocessor">#deny_email_enable=YES</span>
    <span class="hljs-preprocessor"># (default follows)</span>
    <span class="hljs-preprocessor">#banned_email_file=/etc/vsftpd.banned_emails</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may restrict local users to their home directories.  See the FAQ for</span>
    <span class="hljs-preprocessor"># the possible risks in this before using chroot_local_user or</span>
    <span class="hljs-preprocessor"># chroot_list_enable below.</span>
    <span class="hljs-preprocessor">#chroot_local_user=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may specify an explicit list of local users to chroot() to their home</span>
    <span class="hljs-preprocessor"># directory. If chroot_local_user is YES, then this list becomes a list of</span>
    <span class="hljs-preprocessor"># users to NOT chroot().</span>
    <span class="hljs-preprocessor"># (Warning! chroot'ing can be very dangerous. If using chroot, make sure that</span>
    <span class="hljs-preprocessor"># the user does not have write access to the top level directory within the</span>
    <span class="hljs-preprocessor"># chroot)</span>
    <span class="hljs-preprocessor">#chroot_local_user=YES</span>
    chroot_list_enable=YES
    <span class="hljs-preprocessor"># (default follows)</span>
    chroot_list_file=/etc/vsftpd.chroot_list
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># You may activate the "-R" option to the builtin ls. This is disabled by</span>
    <span class="hljs-preprocessor"># default to avoid remote users being able to cause excessive I/O on large</span>
    <span class="hljs-preprocessor"># sites. However, some broken FTP clients such as "ncftp" and "mirror" assume</span>
    <span class="hljs-preprocessor"># the presence of the "-R" option, so there is a strong case for enabling it.</span>
    <span class="hljs-preprocessor">#ls_recurse_enable=YES</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Customization</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># Some of vsftpd's settings don't fit the filesystem layout by</span>
    <span class="hljs-preprocessor"># default.</span>
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># This option should be the name of a directory which is empty.  Also, the</span>
    <span class="hljs-preprocessor"># directory should not be writable by the ftp user. This directory is used</span>
    <span class="hljs-preprocessor"># as a secure chroot() jail at times vsftpd does not require filesystem</span>
    <span class="hljs-preprocessor"># access.</span>
    secure_chroot_dir=/<span class="hljs-keyword">var</span>/run/vsftpd/empty
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># This string is the name of the PAM service vsftpd will use.</span>
    pam_service_name=vsftpd
    <span class="hljs-preprocessor">#</span>
    <span class="hljs-preprocessor"># This option specifies the location of the RSA certificate to use for SSL</span>
    <span class="hljs-preprocessor"># encrypted connections.</span>
    rsa_cert_file=/etc/ssl/certs/ssl-cert-snakeoil.pem
    <span class="hljs-preprocessor"># This option specifies the location of the RSA key to use for SSL</span>
    <span class="hljs-preprocessor"># encrypted connections.</span>
    rsa_private_key_file=/etc/ssl/<span class="hljs-keyword">private</span>/ssl-cert-snakeoil.key

    <span class="hljs-preprocessor"># xhb added</span>
    local_root=/home/xhb/ftp</code>
                </pre>

            <p>现在重启FTP，让之前的配置生效。</p>


            <pre class="prettyprint" name="code"><code class="hljs bash has-numbering"><span
                    class="hljs-built_in">sudo</span> service vsftpd restart
    </code></pre>

            <p>
                <img src="http://img.blog.csdn.net/20170613150706588?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>到这里就OK了。登上去看看。 <br>
                首先，查看IP地址。 <br>
                <img src="http://img.blog.csdn.net/20170613150930615?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""> <br>
                我的本地IP地址是192.168.139.135。 <br>
                在Windows资源管理器中输入：ftp://（你的IP地址） <br>
                <img src="http://img.blog.csdn.net/20170613151200585?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title="" style="width: 80%">> <br>
                输入账户名和密码后即可登录了。 <br>
                <img src="http://img.blog.csdn.net/20170613151310304?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title="" style="width: 80%"> <br>
                登录的路径就是设为共享文件夹的那个路径。</p>

            <p>备注： <br>
                如果出现无法登录的情况，原因可能是这样： <br>
                之前在配置时，我们做了如下配置来指定允许登陆的用户： <br>
                <img src="http://img.blog.csdn.net/20170613151625634?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>提出来看看：</p>

            <pre class="prettyprint" name="code"><code class="hljs ini has-numbering"><span class="hljs-setting">chroot_list_enable=<span
                    class="hljs-value"><span class="hljs-keyword">YES</span> </span></span>
    <span class="hljs-setting">chroot_list_file=<span
            class="hljs-value">/etc/vsftpd.chroot_list</span></span></code></pre>

            <p>配合使用，使得只有在vsftpd.chroot_list中配置的用户才能登录FTP。 <br>
                然而vsftpd.chroot_list中配置的用户，对于local_list指定的目录不允许有些的权限。 <br>
                所以对于共享目录不能有写的权限，如果有我们必须把它去掉。</p>

            <p>查看ftp目录的权限。</p>

            <pre class="prettyprint" name="code"><code class="hljs bash has-numbering">ls <span
                    class="hljs-operator">-l</span></code></pre>

            <p>
                <img src="http://img.blog.csdn.net/20170613152116887?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""></p>

            <p>去掉写权限。</p>


            <pre class="prettyprint" name="code"><code class="hljs lasso has-numbering">chmod u<span
                    class="hljs-attribute">-w</span>,g<span class="hljs-attribute">-w</span> ftp
    ls <span class="hljs-attribute">-l</span></code></pre>

            <p>
                <img src="http://img.blog.csdn.net/20170613152246936?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG9uZ2Jpbl94dQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast"
                     alt="这里写图片描述" title=""> <br>
                从显示信息的最前面可以看到，ftp的写权限已经去掉了。接下来就可以正常登陆了。</p>
        </div>
    </div>
    <p class="text-left">注意：无法登陆或者无法上传文件出现550权限异常时，添加allow_writeable_chroot=YES，并且将用户目录权限进行修改即可</p>
    <p class="text-left">第四步：在Ubuntu Server端安装Nginx</p>
    <div id="cnblogs_post_body"><p>Nginx ("engine x") 是一个高性能的 HTTP 和 反向代理 服务器，也是一个 IMAP/POP3/SMTP 代理服务器。 Nginx 是由 Igor
        Sysoev 为俄罗斯访问量第二的 Rambler.ru
        站点开发的，第一个公开版本0.1.0发布于2004年10月4日。其将源代码以类BSD许可证的形式发布，因它的稳定性、丰富的功能集、示例配置文件和低系统资源的消耗而闻名。</p>
        <h1>安装Nginx依赖库</h1>
        <h2>安装gcc g++的依赖库</h2>
        <p>ubuntu平台可以使用如下命令。</p>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_774225" class="syntaxhighlighter  html">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="html plain">apt-get install
                                        build-essential</code></div>
                                    <div class="line number2 index1 alt1"><code class="html plain">apt-get install
                                        libtool</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <p>centeros平台可以使用如下命令。</p>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_220960" class="syntaxhighlighter  html">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code
                                            class="html plain">centos平台编译环境使用如下指令</code></div>
                                    <div class="line number2 index1 alt1"><code class="html plain">安装make：</code></div>
                                    <div class="line number3 index2 alt2"><code class="html plain">yum -y install gcc
                                        automake autoconf libtool make</code></div>
                                    <div class="line number4 index3 alt1">&nbsp;</div>
                                    <div class="line number5 index4 alt2"><code class="html plain">安装g++:</code></div>
                                    <div class="line number6 index5 alt1"><code class="html plain">yum install gcc
                                        gcc-c++　　</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h2>安装 pcre依赖库（<a title="http://www.pcre.org/" href="http://www.pcre.org/"
                          target="_blank">http://www.pcre.org/</a>）</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_118138" class="syntaxhighlighter  html">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="html plain">sudo apt-get
                                        update </code></div>
                                    <div class="line number2 index1 alt1"><code class="html plain">sudo apt-get install
                                        libpcre3 libpcre3-dev </code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h2>安装 zlib依赖库（<a title="http://www.zlib.net" href="http://www.zlib.net" target="_blank">http://www.zlib.net</a>）
        </h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_985527" class="syntaxhighlighter  html">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="html plain">apt-get install
                                        zlib1g-dev</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h2>安装 ssl依赖库</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_796160" class="syntaxhighlighter  html">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="html plain">apt-get install
                                        openssl</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h1>安装Nginx（<a title="http://nginx.org" href="http://nginx.org" target="_blank">http://nginx.org</a>）</h1>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_72907" class="syntaxhighlighter  html">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="html plain">#下载最新版本：</code></div>
                                    <div class="line number2 index1 alt1"><code class="html plain">wget
                                        http://nginx.org/download/nginx-1.11.3.tar.gz</code></div>
                                    <div class="line number3 index2 alt2"><code class="html plain">#解压：</code></div>
                                    <div class="line number4 index3 alt1"><code class="html plain">tar -zxvf
                                        nginx-1.11.3.tar.gz</code></div>
                                    <div class="line number5 index4 alt2"><code class="html plain">#进入解压目录：</code></div>
                                    <div class="line number6 index5 alt1"><code class="html plain">cd
                                        nginx-1.11.3</code></div>
                                    <div class="line number7 index6 alt2"><code class="html plain">#配置：</code></div>
                                    <div class="line number8 index7 alt1"><code class="html plain">./configure
                                        --prefix=/usr/local/nginx&nbsp; </code></div>
                                    <div class="line number9 index8 alt2"><code class="html plain">#编辑nginx：</code>
                                    </div>
                                    <div class="line number10 index9 alt1"><code class="html plain">make</code></div>
                                    <div class="line number11 index10 alt2"><code class="html plain">注意：这里可能会报错，提示“pcre.h
                                        No such file or
                                        directory”,具体详见：http://stackoverflow.com/questions/22555561/error-building-fatal-error-pcre-h-no-such-file-or-directory </code>
                                    </div>
                                    <div class="line number12 index11 alt1"><code class="html plain">需要安装
                                        libpcre3-dev,命令为：sudo apt-get install libpcre3-dev</code></div>
                                    <div class="line number13 index12 alt2"><code class="html plain">#安装nginx：</code>
                                    </div>
                                    <div class="line number14 index13 alt1"><code class="html plain">sudo make
                                        install</code></div>
                                    <div class="line number15 index14 alt2"><code class="html plain">#启动nginx：</code>
                                    </div>
                                    <div class="line number16 index15 alt1"><code class="html plain">sudo
                                        /usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf </code></div>
                                    <div class="line number17 index16 alt2"><code class="html plain">注意：-c
                                        指定配置文件的路径，不加的话，nginx会自动加载默认路径的配置文件，可以通过 -h查看帮助命令。</code></div>
                                    <div class="line number18 index17 alt1"><code class="html plain">#查看nginx进程：</code>
                                    </div>
                                    <div class="line number19 index18 alt2"><code class="html plain">ps -ef|grep
                                        nginx</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h1>Nginx常用命令</h1>
        <h2>启动 Nginx</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_697906" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">/usr/local/nginx/sbin/nginx</code>
                                    </div>
                                    <div class="line number2 index1 alt1">&nbsp;</div>
                                    <div class="line number3 index2 alt2"><code
                                            class="csharp plain">./sbin/nginx　</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h2>停止 Nginx</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_247478" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">./sbin/nginx -s
                                        stop</code></div>
                                    <div class="line number2 index1 alt1">&nbsp;</div>
                                    <div class="line number3 index2 alt2"><code class="csharp plain">./sbin/nginx -s
                                        quit</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h3>-s都是采用向 Nginx 发送信号的方式。</h3>
        <h2>Nginx重新加载配置</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_524730" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">./sbin/nginx -s
                                        reload</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h2>指定配置文件</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_662434" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">./sbin/nginx -c
                                        /usr/local/nginx/conf/nginx.conf</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h3>-c表示configuration，指定配置文件</h3>
        <h2>查看 Nginx 版本</h2>
        <h3>有两种可以查看 Nginx 的版本信息的参数。第一种如下：</h3>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_964918" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">./sbin/nginx
                                        -v</code></div>
                                    <div class="line number2 index1 alt1">&nbsp;</div>
                                    <div class="line number3 index2 alt2"><code class="csharp plain">nginx: nginx
                                        version: nginx/1.0.0</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h3>另一种显示的是详细的版本信息：</h3>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_727467" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">poechant@ubuntu:/usr/local/nginx$
                                        ./sbin/nginx -V</code></div>
                                    <div class="line number2 index1 alt1"><code class="csharp plain">nginx: nginx
                                        version: nginx/1.0.0</code></div>
                                    <div class="line number3 index2 alt2"><code class="csharp plain">nginx:
                                        built </code><code class="csharp keyword">by</code> <code class="csharp plain">gcc
                                        4.3.3 (Ubuntu 4.3.3-5ubuntu4)</code></div>
                                    <div class="line number4 index3 alt1"><code class="csharp plain">nginx: TLS SNI
                                        support enabled</code></div>
                                    <div class="line number5 index4 alt2"><code class="csharp plain">nginx: configure
                                        arguments: --with-http_ssl_module
                                        --with-openssl=/home/luming/openssl-1.0.0d/</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h2>检查配置文件是否正确</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_270956" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">poechant@ubuntu:/usr/local/nginx$
                                        ./sbin/nginx -t</code></div>
                                    <div class="line number2 index1 alt1"><code class="csharp plain">nginx: [alert]
                                        could not open error log file: open() </code><code class="csharp string">"/usr/local/nginx/logs/error.log"</code>
                                        <code class="csharp plain">failed (13: Permission denied)</code></div>
                                    <div class="line number3 index2 alt2"><code class="csharp plain">nginx: the
                                        configuration file /usr/local/nginx/conf/nginx.conf syntax </code><code
                                            class="csharp keyword">is</code> <code class="csharp plain">ok</code></div>
                                    <div class="line number4 index3 alt1"><code class="csharp plain">2012/01/09 16:45:09
                                        [emerg] 23898#0: open() </code><code class="csharp string">"/usr/local/nginx/logs/nginx.pid"</code>
                                        <code class="csharp plain">failed (13: Permission denied)</code></div>
                                    <div class="line number5 index4 alt2"><code class="csharp plain">nginx:
                                        configuration file /usr/local/nginx/conf/nginx.conf test failed</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h3>如果出现如上的提示信息，表示没有访问错误<a target="_self"><strong>日志</strong></a>文件和进程，可以sudo（super user do）一下：</h3>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_664037" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">poerchant@ubuntu:/usr/local/nginx$
                                        sudo ./sbin/nginx -t</code></div>
                                    <div class="line number2 index1 alt1"><code class="csharp plain">nginx: the
                                        configuration file /usr/local/nginx/conf/nginx.conf syntax </code><code
                                            class="csharp keyword">is</code> <code class="csharp plain">ok</code></div>
                                    <div class="line number3 index2 alt2"><code class="csharp plain">nginx:
                                        configuration file /usr/local/nginx/conf/nginx.conf test </code><code
                                            class="csharp keyword">is</code> <code
                                            class="csharp plain">successful</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <h3>如果显示如上，则表示配置文件正确。否则，会有相关提示。</h3>
        <h2>显示帮助信息</h2>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_87808" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">poechant@ubuntu:/user/local/nginx$
                                        ./sbin/nginx -h</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <p>或者：</p>
        <div class="cnblogs_Highlighter sh-gutter">
            <div>
                <div id="highlighter_287932" class="syntaxhighlighter  csharp">
                    <div class="toolbar"><span></span></div>
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                        <tr>
                            <td class="code">
                                <div class="container">
                                    <div class="line number1 index0 alt2"><code class="csharp plain">poechant@ubuntu:/user/local/nginx$
                                        ./sbin/nginx -?</code></div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <p class="text-left">根据两个工具的安装效果，将共享目录设置成一个文件夹即可，完成</p>
</div>
    <hr>
    <tags:footer/>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="${resourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="${resourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
</body>
</html>