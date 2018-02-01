package com.darly.dubbo.lucene.bean;

import java.io.Serializable;

public class SystemLucene implements Serializable {
    private String id;

    private String lucenekey;

    private String lucenevalue;

    private String luceneurl;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLucenekey() {
        return lucenekey;
    }

    public void setLucenekey(String lucenekey) {
        this.lucenekey = lucenekey == null ? null : lucenekey.trim();
    }

    public String getLucenevalue() {
        return lucenevalue;
    }

    public void setLucenevalue(String lucenevalue) {
        this.lucenevalue = lucenevalue == null ? null : lucenevalue.trim();
    }

    public String getLuceneurl() {
        return luceneurl;
    }

    public void setLuceneurl(String luceneurl) {
        this.luceneurl = luceneurl == null ? null : luceneurl.trim();
    }
}