package com.example.androidstack.ui_view.listview_base_adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidstack.R;

import java.util.ArrayList;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-06
 * Time: 21:55
 * Desc:
 * Version:
 */
public class ListViewBaseAdapter extends BaseAdapter {
    private ArrayList<ListViewContentBean> mData;
    private Context mContext;
    private static SparseBooleanArray isSelected;
    private CheckedAllListener mListener;
    private ViewHolder holder = null;

    public ListViewBaseAdapter(ArrayList<ListViewContentBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        isSelected = new SparseBooleanArray();
        initSelectedStatus();
    }

    public void initSelectedStatus() {
        for (int i = 0; i < mData.size(); i++) {
            getIsSelected().put(i, false);
        }
    }

    public static SparseBooleanArray getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(SparseBooleanArray isSelected) {
        ListViewBaseAdapter.isSelected = isSelected;
    }

    public void setCheckedAllListener(CheckedAllListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ListViewContentBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View mConvertView = convertView;
        if (mConvertView == null) {
            mConvertView = LayoutInflater.from(mContext).inflate(R.layout.simple_item, parent, false);
            holder = new ViewHolder();
            holder.mSimpleTitle = mConvertView.findViewById(R.id.simple_title);
            holder.mSimpleSubTitle = mConvertView.findViewById(R.id.simple_subtitle);
            holder.mSimpleImage = mConvertView.findViewById(R.id.simple_image);
            holder.mSimpleCheckbox = mConvertView.findViewById(R.id.simple_checkbox);
            mConvertView.setTag(holder);
        } else {
            holder = (ViewHolder) mConvertView.getTag();
        }

        /**
         * 不使用 ViewHolder 优化的方法
         */
        /*
        convertView = LayoutInflater.from(mContext).inflate(R.layout.simple_item, parent,false);
        ((TextView) convertView.findViewById(R.id.simple_title)).setText(mData.get(position).getmTitle());
        ((TextView)convertView.findViewById(R.id.simple_subtitle)).setText(mData.get(position).getmSubTitle());
        convertView.findViewById(R.id.simple_image).setBackgroundResource(mData.get(position).getmImages());
         */


        final ListViewContentBean item = getItem(position);

        if (item != null) {
            holder.mSimpleTitle.setText(mData.get(position).getmTitle());
            holder.mSimpleSubTitle.setText(mData.get(position).getmSubTitle());
            holder.mSimpleImage.setBackgroundResource(mData.get(position).getmImages());
            holder.mSimpleCheckbox.setChecked(isSelected.get(position));
        }

        holder.mSimpleCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isPressed()) {
                    isSelected.put(position, isChecked);
                    mListener.checkAll(isSelected);
                }
                item.setIsCheck(isChecked);
            }
        });

        return mConvertView;
    }

    static class ViewHolder {
        TextView mSimpleTitle;
        TextView mSimpleSubTitle;
        ImageView mSimpleImage;
        CheckBox mSimpleCheckbox;
    }

    public interface CheckedAllListener {
        void checkAll(SparseBooleanArray checkall);
    }
}
