package com.darly.dubbo.searchengine;

import org.apache.lucene.document.Document;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2018/2/1
 * TODO :
 */
public interface SearchDocumentListener {

    void findDocument(List<Document> data);

    void closeer();
}
