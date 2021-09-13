package com.tochukwu.payoneerhomework.Repository;

import com.google.gson.Gson;
import com.tochukwu.payoneerhomework.data.Model;
import com.tochukwu.payoneerhomework.other.Constant;

import java.io.IOException;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FakeCall implements Call<Model> {


    @Override
    public Response<Model> execute() throws IOException {
        return null;
    }

    @Override
    public void enqueue(Callback<Model> callback) {
        String json = Constant.constantsJson;
        callback.onResponse(this, Response.success(new Gson().fromJson(json, Model.class)));

    }

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Call<Model> clone() {
        return null;
    }

    @Override
    public Request request() {
        return null;
    }

    @Override
    public Timeout timeout() {
        return null;
    }
}
