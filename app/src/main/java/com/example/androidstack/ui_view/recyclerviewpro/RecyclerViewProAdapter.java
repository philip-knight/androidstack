package com.example.androidstack.ui_view.recyclerviewpro;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidstack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-12-07
 * Time: 14:39
 * Desc:
 * Version:
 */
public class RecyclerViewProAdapter extends RecyclerView.Adapter<RecyclerViewProAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<String> mData;
    private List<Integer> mHeight;

    public RecyclerViewProAdapter(Context mContext, ArrayList<String> mData) {
        this.mContext = mContext.getApplicationContext();
        this.mData = mData;

    }

    public void updateData(ArrayList<String> mData) {
        this.mData = mData;
        mHeight = new ArrayList<Integer>();
        for (int i = 0; i < mData.size(); i++) {
            mHeight.add((int) (500 + Math.random() * 600));
        }
        notifyDataSetChanged();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.recycler_view_item);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        Glide
                .with(mContext)
                .load(mData.get(position))
                .into(viewHolder.mImageView);

        ViewGroup.LayoutParams lp = viewHolder.itemView.getLayoutParams();
        lp.height = mHeight.get(position);
        viewHolder.itemView.setLayoutParams(lp);
        Log.d("HttpURL", mData.get(position) + " position : " + position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
