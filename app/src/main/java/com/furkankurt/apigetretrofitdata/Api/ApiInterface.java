package com.furkankurt.apigetretrofitdata.Api;

import com.furkankurt.apigetretrofitdata.Model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/api/users?page=1")
    Call<DataModel> getUserInformation();
}
