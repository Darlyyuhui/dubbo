package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.searchengine.analyzer.lucene.IKAnalyzer;
import com.darly.dubbo.searchengine.api.SearchEngineApi;
import com.darly.dubbo.security.system.bean.SystemLog;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.apache.lucene.document.StringField.TYPE_STORED;

/**
 * Author : ZhangYuHui
 * Date : 2018/1/29
 * TODO :
 */
@Service
public class SearchEngineBiz extends BaseController implements SearchEngineApi {
    @Override
    public ModelMap searchEngine(String key) {
        ModelMap map = new ModelMap();
        List<SystemLog> values = new ArrayList<SystemLog>();
        long start = System.currentTimeMillis();
        logger.info("开始搜索时间：" + start);
        //定义索引目录
        Path path = FileSystems.getDefault().getPath("index");
        Directory directory = null;
        try {
            directory = FSDirectory.open(path);
            //定义索引查看器
            IndexReader indexReader = DirectoryReader.open(directory);
            //定义搜索器
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            //定义Term集合
            List<Term> termList = new ArrayList<Term>();
            //获取分词结果
            List<String> analyseResult = getAnalyseResult(key, new IKAnalyzer());
            for (String result : analyseResult){
                termList.add(new Term("content",result));
            }
            //定义TermQuery集合
            List<TermQuery> termQueries = new ArrayList<TermQuery>();
            //取出集合结果
            for(Term term : termList){
                termQueries.add(new TermQuery(term));
            }
            List<BooleanClause> booleanClauses = new ArrayList<BooleanClause>();
            //遍历
            for (TermQuery termQuery : termQueries){
                booleanClauses.add(new BooleanClause(termQuery, BooleanClause.Occur.SHOULD));
            }
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            for (BooleanClause booleanClause : booleanClauses){
                builder.add(booleanClause);
            }
            //检索
            BooleanQuery query = builder.build();

            //命中前10条文档
            TopDocs topDocs = indexSearcher.search(query,20);
            //打印命中数
            logger.info("命中数："+topDocs.totalHits);
            //取出文档
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            //遍历取出数据

            for (ScoreDoc scoreDoc : scoreDocs){
                float score = scoreDoc.score; //相似度
                logger.info("相似度:"+ score);
                //通过indexSearcher的doc方法取出文档
                Document doc = indexSearcher.doc(scoreDoc.doc);
                SystemLog log = new SystemLog();
                log.setId(doc.get("id"));
                log.setOperatorId(doc.get("operatorId"));
                log.setIpAddress(doc.get("ipAddress"));
                log.setOperatorName(doc.get("operatorName"));
                log.setType(Long.valueOf(doc.get("type")));
                log.setContent(doc.get("content"));
                values.add(log);
            }
            //关闭索引查看器
            indexReader.close();
            long end = System.currentTimeMillis();
            long time =  end-start;
            logger.info("开始搜索时间：" + end+"耗时：" + time + "毫秒" );
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        map.addAttribute("values",values);
        return map;
    }


    /**
     * 获取指定分词器的分词结果
     * @param analyzeStr
     *            要分词的字符串
     * @param analyzer
     *            分词器
     * @return 分词结果
     */
    public static List<String> getAnalyseResult(String analyzeStr, Analyzer analyzer) {
        List<String> response = new ArrayList<String>();
        TokenStream tokenStream = null;
        try {
            //返回适用于fieldName的TokenStream，标记读者的内容。
            tokenStream = analyzer.tokenStream("address", new StringReader(analyzeStr));
            // 语汇单元对应的文本
            CharTermAttribute attr = tokenStream.addAttribute(CharTermAttribute.class);
            //消费者在使用incrementToken（）开始消费之前调用此方法。
            //将此流重置为干净状态。 有状态的实现必须实现这种方法，以便它们可以被重用，就像它们被创建的一样。
            tokenStream.reset();
            //Consumers（即IndexWriter）使用此方法将流推送到下一个令牌。
            while (tokenStream.incrementToken()) {
                response.add(attr.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (tokenStream != null) {
                try {
                    tokenStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }
}
