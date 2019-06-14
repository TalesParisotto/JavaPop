package com.talesparisotto.javapop.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl( GitConfig.URL_BASE )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofitPull(){
        return new Retrofit.Builder()
                .baseUrl( GitConfig.URL_BASE_PULL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
