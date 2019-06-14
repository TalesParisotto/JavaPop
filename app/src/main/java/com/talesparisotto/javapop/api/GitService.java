package com.talesparisotto.javapop.api;


import com.talesparisotto.javapop.model.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jamiltondamasceno
 */

public interface GitService {

    /*
    https://api.github.com/search/
    repositories
    ?q=language:Java
    &sort=stars
    &page=1
    */

    @GET("repositories")
    Call<Resultado> recuperarRepo(
            @Query("q") String q,
            @Query("sort") String sort,
            @Query("page") String page
    );

}
