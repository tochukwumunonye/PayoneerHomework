package com.tochukwu.payoneerhomework.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tochukwu.payoneerhomework.data.Model;
import com.tochukwu.payoneerhomework.data.Remote.APIWrapper;
import com.tochukwu.payoneerhomework.data.Repository.PayoneerRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class PayoneerViewModel extends ViewModel {

    private PayoneerRepository payoneerRepository;

    @Inject
    public PayoneerViewModel(PayoneerRepository payoneerRepository) {
        this.payoneerRepository = payoneerRepository;

    }

    private final MutableLiveData<APIWrapper<Model>> remoteData = new MutableLiveData<>(null);

    public LiveData<APIWrapper<Model>> getRemoteData() {
        payoneerRepository.getData(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                APIWrapper.Status status;
                if (response.isSuccessful()) {
                    status = APIWrapper.Status.SUCCESS;
                } else {
                    status = APIWrapper.Status.FAILURE;
                }
                remoteData.setValue(new APIWrapper<Model>(response.body(), null, response.code(), status));
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                remoteData.setValue(new APIWrapper<Model>(null, t, 0, APIWrapper.Status.FAILURE));
            }
        });
        return remoteData;
    }
}
