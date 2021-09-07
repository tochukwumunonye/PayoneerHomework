package com.tochukwu.payoneerhomework.adapter;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tochukwu.payoneerhomework.R;
import com.tochukwu.payoneerhomework.data.Applicable;
import com.tochukwu.payoneerhomework.data.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.MyHolder>{

    private Context mContext;
     List<Applicable> files;
    View view;

    public PaymentAdapter(Context mcontext, Model model){
        this.mContext = mcontext;
        this.files = model.getNetworks().getApplicable();
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         view = LayoutInflater.from(mContext).inflate(R.layout.items, parent, false);
         return new MyHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
          holder.paymentName.setText(files.get(position).getLabel());
          String logoUrl = files.get(position).getLinks().getLogo();
          if (logoUrl != null) {
              Glide.with(holder.itemView).load(logoUrl).into(holder.logo);
          } else{
              Glide.with(holder.itemView).load(R.drawable.koko).into(holder.logo);
          }
    }

    @Override
    public int getItemCount() {
        return files.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
          ImageView logo;
          TextView paymentName;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            paymentName = itemView.findViewById(R.id.paymentName);
        }
    }
}

