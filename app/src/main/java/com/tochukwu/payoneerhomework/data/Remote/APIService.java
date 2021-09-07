package com.tochukwu.payoneerhomework.data.Remote;

import com.tochukwu.payoneerhomework.data.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    Call<Model> getData();

}

