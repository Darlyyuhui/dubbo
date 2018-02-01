package com.darly.dubbo.searchengine;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.common.comm.ExecutionContext;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.lucene.bean.SystemLucene;
import com.darly.dubbo.lucene.service.SystemLuceneService;
import com.darly.dubbo.searchengine.analyzer.lucene.IKAnalyzer;
import com.darly.dubbo.security.system.service.SystemLogService;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.lucene.document.StringField.TYPE_STORED;

/** 加载引擎
 * Author : ZhangYuHui
 * Date : 2018/1/29
 * TODO :
 */
@Component
public class SearchEngineSchedule {
    public Logger logger = new Logger(getClass());

    private boolean first = false;
    @Autowired
    SystemLogService logService;

    @Autowired
    SystemLuceneService luceneService;

    @Autowired
    SqlSessionFactory sqlSessionFactory;
    List<Document> data = new ArrayList<Document>();
    // 每15秒执行一次
    @Scheduled(cron = "0/3000 * * * * ?")
    public void reportCurrentByCron()  throws IOException {
        data.clear();
        ResultHandler result = new DefaultResultHandler();
        SqlSession session = sqlSessionFactory.openSession();
        session.select("com.darly.dubbo.lucene.dao.SystemLuceneMapper.selectByExample",
                null, new DefaultResultHandler() {
                    @Override
                    public void handleResult(ResultContext resultContext) {
                        SystemLucene log = (SystemLucene) resultContext.getResultObject();
                        //定义文档
                        Document document = new Document();
                        //读取每一行
                        document.add(new Field("id", log.getId(), TYPE_STORED));
                        document.add(new Field("key", log.getLucenekey(), TYPE_STORED));
                        document.add(new Field("value", log.getLucenevalue(), TYPE_STORED));
                        document.add(new Field("url", log.getLuceneurl(), TYPE_STORED));
                        data.add(document);
                        if (resultContext.isStopped()){
                            SearchEngineer.getInstance().getListener().findDocument(data);
                            SearchEngineer.getInstance().getListener().closeer();
                        }else if (data.size()>=100000){
                            SearchEngineer.getInstance().getListener().findDocument(data);
                            data.clear();
                        }
                    }
                });


        if (first){
            logger.info("开始进行读取文件------------->");
            first = false;
            String paths = "C:\\Users\\Darly\\Desktop\\Dubbo\\汉语词库\\data";
            File file = new File(paths);
            File[] lis =  file.listFiles();
            for (File arg:lis) {
                logger.infoLine();
                logger.info(arg.getPath()+"--------->开始检索");
                FileInputStream i = new FileInputStream(arg.getPath());
                BufferedReader br = new BufferedReader(new InputStreamReader(i, "UTF-8"));
                String content;
                while ((content = br.readLine()) != null) {
                    SystemLucene lucene = new SystemLucene();
                    lucene.setId(UuidGenerateUtil.getUUIDLong());
                    lucene.setLucenekey(content);
                    lucene.setLucenevalue(content);
                    lucene.setLuceneurl(content);
                    luceneService.save(lucene);
                }
                i.close();
                br.close();
                arg.delete();
                logger.infoLine();
                logger.info(arg.getPath()+"--------->检索完成");
            }
            logger.info("整个文件缓存完成------------->");
        }
    }
}
