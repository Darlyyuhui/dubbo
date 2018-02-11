package com.darly.dubbo.searchengine;

import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.lucene.bean.SystemLucene;
import com.darly.dubbo.lucene.service.SystemLuceneService;
import com.darly.dubbo.security.system.service.SystemLogService;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.lucene.document.StringField.TYPE_STORED;

/**
 * 加载引擎
 * Author : ZhangYuHui
 * Date : 2018/1/29
 * TODO :
 */
@Component
public class SearchEngineSchedule {
    public Logger logger = new Logger(getClass());

    private boolean first = false;
    private boolean isHasdata = false;
    @Autowired
    SystemLogService logService;

    @Autowired
    SystemLuceneService luceneService;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    SqlSession session;
    List<Document> data = new ArrayList<Document>();
    long cout = 0;

    // 每15秒执行一次
    @Scheduled(cron = "0/300 * * * * ?")
    public void reportCurrentByCron() throws IOException {
        if (isHasdata) {
            if (cout == 0) {
                cout = luceneService.count(null);
            }
            data.clear();
            if (session == null) {
                session = sqlSessionFactory.openSession();
            }
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
                            data.add(document);
                            if (resultContext.getResultCount() == cout) {
                                SearchEngineer.getInstance().getListener().findDocument(data);
                                SearchEngineer.getInstance().getListener().closeer();
                                data.clear();
                            } else if (data.size() >= 100000) {
                                SearchEngineer.getInstance().getListener().findDocument(data);
                                data.clear();
                            }
                        }
                    });
        }
        if (first) {
            logger.info("开始进行读取文件------------->");
            first = false;
            String paths = "C:\\Users\\Darly\\Desktop\\Dubbo\\汉语词库\\data";
            File file = new File(paths);
            File[] lis = file.listFiles();
            for (File arg : lis) {
                logger.infoLine();
                logger.info(arg.getPath() + "--------->开始检索");
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
                logger.info(arg.getPath() + "--------->检索完成");
            }
            logger.info("整个文件缓存完成------------->");
        }
    }


}
