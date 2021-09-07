package com.tochukwu.payoneerhomework.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.tochukwu.payoneerhomework.PayoneerViewModel;
import com.tochukwu.payoneerhomework.R;
import com.tochukwu.payoneerhomework.adapter.PaymentAdapter;
import com.tochukwu.payoneerhomework.data.Model;
import com.tochukwu.payoneerhomework.data.Remote.APIWrapper;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Response;

@AndroidEntryPoint
public class PaymentFragment extends Fragment {

    RecyclerView recyclerView;
    PaymentAdapter paymentAdapter;
    Button btnError;
    TextView tvError;
    ProgressBar pb;


    @Inject
    PayoneerViewModel payoneerViewModel;

    public PaymentFragment() {
       // super(R.layout.payment_fragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payment_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        btnError = view.findViewById(R.id.button_retry);
        tvError = view.findViewById(R.id.text_view_error);
        pb = view.findViewById(R.id.progressbar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subscribeToObservers();

        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retryAgain();
            }
        });


    }

    private void subscribeToObservers() {
        payoneerViewModel.getRemoteData().observe(getViewLifecycleOwner(), new Observer<APIWrapper<Model>>() {
            @Override
            public void onChanged(APIWrapper<Model> model) {
                if (model != null) {
                    // terminal state; data fetching either failed or succeeded
                    switch (model.getStatus()) {
                        case SUCCESS:

                            displayOnRecycler(model.getData());// handle success
                            break;
                        case FAILURE: // handle failure
                            retryfunction();
                            Snackbar.make(requireActivity().findViewById(R.id.rootLayout), model.getStatus().toString(), Snackbar.LENGTH_LONG ).show();
                            break;
                    }
                } else {
                    // data is still loading
                    pb.setVisibility(View.VISIBLE);
                    btnError.setVisibility(View.INVISIBLE);
                    tvError.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private void retryfunction() {
        pb.setVisibility(View.INVISIBLE);
        btnError.setVisibility(View.VISIBLE);
        tvError.setVisibility(View.VISIBLE);
    }

    private void displayOnRecycler(Model model) {
        btnError.setVisibility(View.INVISIBLE);
        pb.setVisibility(View.INVISIBLE);
        paymentAdapter = new PaymentAdapter(getContext(), model);
        recyclerView.setAdapter(paymentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

    }

    private void retryAgain() {

        payoneerViewModel.getRemoteData();
    }


}
