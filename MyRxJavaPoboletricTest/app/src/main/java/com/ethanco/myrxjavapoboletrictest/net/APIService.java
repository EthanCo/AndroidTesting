package com.ethanco.myrxjavapoboletrictest.net;


import com.ethanco.myrxjavapoboletrictest.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by EthanCo on 2015/6/13.
 */
public interface APIService {
    @GET("/users/{user}/repos")
    public Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("/users/{user}/repos")
    public Observable<List<Repo>> listRepos2Observable(@Path("user") String user);
}
