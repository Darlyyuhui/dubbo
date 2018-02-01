package com.darly.dubbo.searchengine;

import com.darly.dubbo.searchengine.analyzer.lucene.IKAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2018/2/1
 * TODO :
 */
public class SearchEngineer implements SearchDocumentListener {

    private static SearchEngineer instance;

    private IndexWriter indexWriter;

    private int size = 0;

    private SearchEngineer() {
        setListener(this);
        try {
            Path path = FileSystems.getDefault().getPath("", "index");
            Directory directory = FSDirectory.open(path);
            //定义分词器
            //        Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new IKAnalyzer();
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer).setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SearchEngineer getInstance() {
        if (instance == null) {

            instance = new SearchEngineer();
        }
        return instance;
    }

    private SearchDocumentListener listener;

    public void setListener(SearchDocumentListener listener) {
        this.listener = listener;
    }

    public SearchDocumentListener getListener() {
        if (listener == null) {
            System.out.println("DocumentListener is not instance！ Please instance to use");
        }
        return listener;
    }

    @Override
    public void findDocument(List<Document> data) {
        System.out.println("调用了第"+size+"次，保存数据"+data.size());
        if (indexWriter!=null) {
            try {
                for (Document document : data) {
                    indexWriter.addDocument(document);
                }
                //提交
                indexWriter.commit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        size++;
    }

    @Override
    public void closeer() {
        if (indexWriter!=null){
            try {
                size =0;
                indexWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
