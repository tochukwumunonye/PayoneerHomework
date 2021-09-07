package com.tochukwu.payoneerhomework.data.Repository;

import androidx.lifecycle.LiveData;

import com.tochukwu.payoneerhomework.data.Model;

import retrofit2.Callback;

public interface PayoneerRepository {

   void getData(Callback<Model> callback);
}