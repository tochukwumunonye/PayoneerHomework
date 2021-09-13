package com.tochukwu.payoneerhomework.Repository;

import com.tochukwu.payoneerhomework.data.Model;
import com.tochukwu.payoneerhomework.data.Repository.PayoneerRepository;

import retrofit2.Callback;

public class FakeRepository implements PayoneerRepository {

    public static boolean error = false;
    public boolean errorNetwork = error;

    @Override
    public void getData(Callback<Model> callback) {

        if (errorNetwork) {
            new FakeErrorCall().enqueue(callback);
        } else {
            new FakeCall().enqueue(callback);
        }
    }
}









