package com.example.androidstack.ui_view.recyclerview_origin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstack.R;

import java.util.ArrayList;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-07
 * Time: 17:56
 * Desc:
 * Version:
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Integer> mData;


    public RecyclerViewAdapter(Context mContext, ArrayList<Integer> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.recycler_view_item);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position){
        viewHolder.mImageView.setImageResource(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
