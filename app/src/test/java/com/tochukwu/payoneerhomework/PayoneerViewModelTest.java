package com.tochukwu.payoneerhomework;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.tochukwu.payoneerhomework.data.Remote.APIWrapper;
import com.tochukwu.payoneerhomework.data.repository.FakeRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PayoneerViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();


    PayoneerViewModel payoneerViewModel;

    @Before
    public void setup(){
        /*FakeRepository fakeRepository =  new FakeRepository();
        fakeRepository.errorNetwork = true;
        payoneerViewModel = new PayoneerViewModel(fakeRepository);*/
    }

    @Test
    public void getDataAndPutInLiveData(){
        //Assert.assertEquals(payoneerViewModel.getRemoteData().getValue().getStatus(), APIWrapper.Status.FAILURE);
    }

    @Test
    public void getDataShouldFail() {
        FakeRepository fakeRepository =  new FakeRepository();
        fakeRepository.errorNetwork = true;
        payoneerViewModel = new PayoneerViewModel(fakeRepository);
        Assert.assertEquals(payoneerViewModel.getRemoteData().getValue().getStatus(), APIWrapper.Status.FAILURE);
    }

    @Test
    public void getDataShouldSucceed() {
        FakeRepository fakeRepository =  new FakeRepository();
        fakeRepository.errorNetwork = false;
        payoneerViewModel = new PayoneerViewModel(fakeRepository);
        Assert.assertEquals(payoneerViewModel.getRemoteData().getValue().getStatus(), APIWrapper.Status.SUCCESS);

    }

    @Test
    public void verifySuccessNotNull() {
        FakeRepository fakeRepository =  new FakeRepository();
        fakeRepository.errorNetwork = false;
        payoneerViewModel = new PayoneerViewModel(fakeRepository);
        Assert.assertNotNull(payoneerViewModel.getRemoteData().getValue().getData());

    }



}






