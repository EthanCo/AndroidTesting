package com.ethanco.myrxjavapoboletrictest.net;


import com.ethanco.myrxjavapoboletrictest.model.my.CmdRequest;
import com.ethanco.myrxjavapoboletrictest.model.my.TimeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by EthanCo on 2015/6/13.
 */
public interface APIServiceMy {

    @POST("api")
    Call<TimeResponse> getServerTime(@Body CmdRequest cmd);
}
