package com.example.newscoba.servis;

import com.example.newscoba.config.keyapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiservis {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(keyapi.URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
