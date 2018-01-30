package com.darly.dubbo.searchengine;

import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.lucene.bean.SystemLucene;
import com.darly.dubbo.lucene.service.SystemLuceneService;
import com.darly.dubbo.searchengine.analyzer.lucene.IKAnalyzer;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.service.SystemLogService;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import static org.apache.lucene.document.StringField.TYPE_STORED;

/** 加载引擎
 * Author : ZhangYuHui
 * Date : 2018/1/29
 * TODO :
 */
@Component
public class SearchEngineSchedule {
    public Logger logger = new Logger(getClass());

    private boolean first = true;
    @Autowired
    SystemLogService logService;

    @Autowired
    SystemLuceneService luceneService;

    // 每15秒执行一次
    @Scheduled(cron = "0/100 * * * * ?")
    public void reportCurrentByCron()  throws IOException {
        Path path = FileSystems.getDefault().getPath("", "index");

        Directory directory = FSDirectory.open(path);
        //定义分词器
//        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer).setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        long start = System.currentTimeMillis();
        logger.info("开始加载引擎:" + start);
        List<SystemLog> list =logService.selectByExample(null);
        for (SystemLog log:list) {
            //定义文档
            Document document = new Document();
            //读取每一行
            document.add(new Field("content", log.getContent(), TYPE_STORED));
            document.add(new Field("id", log.getId(), TYPE_STORED));
            document.add(new Field("operatorId", log.getOperatorId(), TYPE_STORED));
            document.add(new Field("ipAddress", log.getIpAddress(), TYPE_STORED));
            document.add(new Field("operatorName", log.getOperatorName(), TYPE_STORED));
            document.add(new Field("type", String.valueOf(log.getType()), TYPE_STORED));
            indexWriter.addDocument(document);
        }
        long end = System.currentTimeMillis();
        float time = end - start;
        logger.info("引擎加载完成:" + end+"耗时:" + time);
        //提交
        indexWriter.commit();
        //关闭
        indexWriter.close();

        if (first){
            logger.info(getClass().getSimpleName(),"开始进行读取文件------------->");
            first = false;
            String paths = "C:\\Users\\Darly\\Desktop\\Dubbo\\汉语词库\\data";
            File file = new File(paths);
            File[] lis =  file.listFiles();
            for (File arg:lis) {
                    FileReader fr = new FileReader(arg.getPath());
                    BufferedReader br = new BufferedReader(fr);
                    String content;
                    while ((content = br.readLine()) != null) {
                        SystemLucene lucene = new SystemLucene();
                        lucene.setId(UuidGenerateUtil.getUUIDLong());
                        lucene.setKey(content);
                        lucene.setValue("");
                        lucene.setUrl("");
                        luceneService.save(lucene);
                    }
                    fr.close();
                    br.close();
            }
            logger.info(getClass().getSimpleName(),"整个文件缓存完成------------->");
        }

    }

}