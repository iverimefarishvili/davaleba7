package com.example.davaleba7.adapters;


import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.davaleba7.model.Building;
import com.example.davaleba7.R;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    RequestOptions options ;
    private Context mContext ;
    private List<Building> mData ;


    public RvAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.descriptionEN.setText(mData.get(position).getDescription());
        holder.titleEN.setText(mData.get(position).getTitle());

        Glide.with(mContext).load(mData.get(position).getCover()).apply(options).into(holder.cover);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleEN, descritpionEN;
        ImageView cover;


        public MyViewHolder(View itemView) {
            super(itemView);
            titleEN = itemView.findViewById(R.id.title);
            descritpionEN = itemView.findViewById(R.id.descritpion);
            cover = itemView.findViewById(R.id.cover);
        }
    }


}