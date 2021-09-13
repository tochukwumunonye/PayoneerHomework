package com.tochukwu.payoneerhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tochukwu.payoneerhomework.ui.PaymentFragmentFactory;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    public PaymentFragmentFactory paymentFragmentFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().setFragmentFactory(paymentFragmentFactory);
        setContentView(R.layout.activity_main);
    }
}