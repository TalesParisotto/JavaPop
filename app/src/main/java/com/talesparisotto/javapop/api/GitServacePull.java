package com.talesparisotto.javapop.api;

import com.talesparisotto.javapop.model.Pull;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitServacePull {

    //Usei url estatica por causa que o @path não está funcionando
    @GET("https://api.github.com/repos/iluwatar/java-design-patterns/pulls")
    Call<List<Pull>> recuperarPull1();


}


