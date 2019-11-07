package com.example.androidstack.ui_view.test;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.androidstack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-07
 * Time: 16:08
 * Desc:
 * Version:
 */
public class MyListAdapter extends BaseAdapter {

    List<Test> list = new ArrayList<Test>();
    private static SparseBooleanArray isSelected;/**用SparseBooleanArray来代替map**/
    Context context;
    HolderView holderView = null;
    /**
     * 全选回调接口
     */
    CheckedAllListener mListener;

    public void setCheckedAllListener(CheckedAllListener listener) {
        mListener = listener;
    }


    public MyListAdapter(List<Test> list, Context context) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.list = list;
        isSelected = new SparseBooleanArray();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData()
    {
        for (int i = 0; i < list.size(); i++) {

            getIsSelected().put(i, false);

        }
    }


    public static SparseBooleanArray getIsSelected()
    {
        return isSelected;
    }

    public static void setIsSelected(SparseBooleanArray isSelected) {
        MyListAdapter.isSelected = isSelected;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Test getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View view = convertView;
        if (view == null) {
            holderView = new HolderView();
            //得到资源文件
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, parent, false);
            holderView.cb_button = (CheckBox)view.findViewById(R.id.cb_button);
            holderView.tv_name = (TextView)view.findViewById(R.id.tv_name);
            view.setTag(holderView);

        }
        else {
            holderView = (HolderView)view.getTag();
        }

        final Test item = getItem(position);
        if (item != null) {
            holderView.tv_name.setText(item.getName());
            holderView.cb_button.setChecked(isSelected.get(position));

        }
        /**
         * 增加checkbox的改变事件，每个item的点击事件
         */
        holderView.cb_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                //                      holderView.cb_button.toggle();
                if (buttonView.isPressed()) {

                    isSelected.put(position,isChecked);
                    //监听回调，是否改变全选按钮的状态
                    mListener.CheckAll(isSelected);

                }
                item.setCheck(isChecked);
            }
        });
        return view;
    }


    class HolderView
    {
        private CheckBox cb_button;
        private TextView tv_name;
    }

    /**
     * 当所有CheckBox全选时回调
     * @author Administrator
     *
     */
    public interface CheckedAllListener
    {

        void CheckAll(SparseBooleanArray checkall);

    }

}