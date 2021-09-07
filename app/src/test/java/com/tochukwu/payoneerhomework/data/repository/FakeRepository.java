package com.tochukwu.payoneerhomework.data.repository;

import com.tochukwu.payoneerhomework.data.Model;
import com.tochukwu.payoneerhomework.data.Remote.APIService;
import com.tochukwu.payoneerhomework.data.Repository.PayoneerRepository;
import com.tochukwu.payoneerhomework.other.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FakeRepository implements PayoneerRepository {

    public boolean errorNetwork = false;

    @Override
    public void getData(Callback<Model> callback) {

        if (errorNetwork) {
            new FakeErrorCall().enqueue(callback);
        } else {
            new FakeCall().enqueue(callback);
        }
    }
}









