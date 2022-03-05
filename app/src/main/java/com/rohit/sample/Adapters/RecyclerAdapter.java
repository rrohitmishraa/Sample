package com.rohit.sample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rohit.sample.R;
import com.rohit.sample.databinding.ItemLayoutBinding;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<DataModel> data;

    public RecyclerAdapter(Context context, ArrayList<DataModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(data.get(holder.getAdapterPosition()).getImageUrl()).placeholder(R.drawable.loading).into(holder.b.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemLayoutBinding b;

        public ViewHolder(View itemView) {
            super(itemView);
            b = ItemLayoutBinding.bind(itemView);
        }
    }
}
