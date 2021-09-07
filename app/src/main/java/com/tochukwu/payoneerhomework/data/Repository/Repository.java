package com.tochukwu.payoneerhomework.data.Repository;

import com.tochukwu.payoneerhomework.data.Model;
import com.tochukwu.payoneerhomework.data.Remote.APIService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements PayoneerRepository{

    private APIService apiService;

    @Inject
    public Repository(APIService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getData(Callback<Model> callback) {
        apiService.getData().enqueue(callback);

    }
}
