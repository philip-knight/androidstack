package com.example.androidstack.ui_view.recyclerview_origin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.androidstack.R;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> mHeight;

    public void setmData(ArrayList<String> mData) {
        this.mData = mData;
        mHeight = new ArrayList<Integer> ();
        for (int i = 0; i < mData.size (); i++) {
            mHeight.add ((int) (500 + Math.random ()*600));
        }
    }

    private ArrayList<String> mData;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mData) {
        this.mContext = mContext.getApplicationContext();
        this.mData = mData;

        // 瀑布流随机高度

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
//        viewHolder.mImageView.setImageResource(mData.get(position));
//        if (!mData.get(position).isEmpty()) {
        Glide
                .with(mContext)
                .load(mData.get(position))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.d("HttpURL", (e != null ? e.getMessage() : "null"));
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Log.d("HttpURL", resource.getClass().getCanonicalName());
                        return false;
                    }
                })
                .into(viewHolder.mImageView);

        ViewGroup.LayoutParams lp = viewHolder.itemView.getLayoutParams();
        lp.height = mHeight.get (position);
        viewHolder.itemView.setLayoutParams(lp);
        Log.d("HttpURL", mData.get(position) + " position : " + position);
//        } else {
//            Glide
//                .with(mContext)
//                .load("http://photocdn.sohu.com/20110707/Img312724643.jpg")
//                .into(viewHolder.mImageView);
//        }
    }

    @Override
    public int getItemCount() {
//        return 10;
        return mData.size();
    }


}
