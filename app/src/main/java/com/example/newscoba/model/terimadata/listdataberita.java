package com.example.newscoba.model.terimadata;

import com.example.newscoba.model.beritakonten;


import java.util.List;

public class listdataberita {
    private String status;
    private int totalResults;
    private List<beritakonten> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<beritakonten> getArticles() {
        return articles;
    }

    public void setArticles(List<beritakonten> articles) {
        this.articles = articles;
    }

    public listdataberita() {

    }
}
