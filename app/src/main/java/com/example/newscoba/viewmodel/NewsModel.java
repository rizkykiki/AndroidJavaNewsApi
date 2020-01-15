package com.example.newscoba.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.newscoba.model.beritakonten;
import com.example.newscoba.repo.reponews;



import java.util.List;

public class NewsModel extends ViewModel {

    private reponews repo;
    LiveData<List<beritakonten>> list_news;

    public void init(reponews repo){
        this.repo  = repo;
    }

    public LiveData<List<beritakonten>> getNewsByCategory(String categ){
        list_news = this.repo.getNews(categ);
        return this.list_news;
    }

}
