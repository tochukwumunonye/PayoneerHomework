package com.tochukwu.payoneerhomework.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

public class PaymentFragmentFactory extends FragmentFactory {

    @Inject
    public PaymentFragmentFactory() {
    }

    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        if (className.equals(PaymentFragment.class.getName())) {
            return new PaymentFragment();
        }
        return super.instantiate(classLoader, className);
    }
}
