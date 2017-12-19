package com.darly.dubbo.fileupload;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/19
 * TODO :
 */
public class FTPUtils {
    private String ftpaddress=FtpConfig.getValue("FTP_ADDRESS",null);
    private int ftpport=FtpConfig.getValue("FTP_PORT",0);
    private String ftpusername=FtpConfig.getValue("FTP_USERNAME",null);
    private String ftppassword=FtpConfig.getValue("FTP_PASSWORD",null);
    private String ftpbasepath=FtpConfig.getValue("FTP_BASEPATH",null);
    private String ftpsavepath=FtpConfig.getValue("FTP_SAVEPATH",null);


    private FTPClient ftp;


    public FTPUtils() throws Exception {
        ftp = new FTPClient();
        ftp.connect(ftpaddress,ftpport);
        ftp.login(ftpusername,ftppassword);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        int reply;
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
        }
        connect(ftpbasepath);
    }
    /**
     *
     * @param path 上传到ftp服务器哪个路径下
     * @return
     * @throws Exception
     */
    public void connect(String path) throws Exception {
        ftp.changeWorkingDirectory(path);
    }

    public boolean makeDirectory(String path) throws IOException {
        return ftp.makeDirectory(path);
    }
    /**
     *
     * @param file 上传的文件或文件夹
     * @throws Exception
     */
    public void upload(File file) throws Exception{
        if(file.isDirectory()){
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath()+"\\"+files[i] );
                if(file1.isDirectory()){
                    upload(file1);
                    ftp.changeToParentDirectory();
                }else{
                    File file2 = new File(file.getPath()+"\\"+files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file.getName(), input);
                    input.close();
                }
            }
        }else{
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            boolean result = ftp.storeFile(file.getName(), input);
            System.out.println(result);
            input.close();
        }
    }


    public void destroy() throws IOException {
        if(ftp != null){
            ftp.disconnect();
            ftp = null;
        }
    }

    public String getFtpsavepath() {
        return ftpsavepath;
    }
}
