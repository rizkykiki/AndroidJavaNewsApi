package com.example.newscoba.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newscoba.config.keyapi;
import com.example.newscoba.model.beritakonten;
import com.example.newscoba.model.terimadata.listdataberita;
import com.example.newscoba.servis.NewsAPI;
import com.example.newscoba.servis.apiservis;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class reponews {
    private NewsAPI web_service;

    public reponews(){
        web_service = apiservis.getClient().create(NewsAPI.class);
    }

    public LiveData<List<beritakonten>> getNews(final String category) {
        final MutableLiveData<List<beritakonten>> data = new MutableLiveData<>();
        Map<String, String> params = new HashMap<String, String>() {
            {
                put("country", keyapi.COUNTRY);
                put("category", category);
                put("apiKey", keyapi.API_KEY);

            }
        };
        web_service.getNewsByCategory(params).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {
                    try {
                        String _data = response.body().string();
                        Log.d("JSON",_data);
                        Gson mGson = new Gson();
                        listdataberita response_data = mGson.fromJson(_data, listdataberita.class);
                        if(response_data!=null){
                            data.setValue(response_data.getArticles());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.d("error","Error Parsing");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });
        return data;
    }
}
