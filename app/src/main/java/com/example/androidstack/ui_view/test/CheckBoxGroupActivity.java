package com.example.androidstack.ui_view.test;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidstack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-07
 * Time: 16:11
 * Desc:
 * Version:
 */
public class CheckBoxGroupActivity extends AppCompatActivity implements MyListAdapter.CheckedAllListener {

    MyListAdapter adapter;
    ListView listView;
    List<CheckBoxBean> list;
    CheckBox cb_button_all;

    Button btn_select;
    Button btn_select_cancel;

    SparseBooleanArray isCheckeds;
    //判断是否全选按钮按下
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView)findViewById(R.id.list_view);
        cb_button_all = (CheckBox)findViewById(R.id.cb_all_button);
        btn_select = (Button)findViewById(R.id.btn_fanxuan);
        btn_select_cancel = (Button)findViewById(R.id.btn_cancel);

        isCheckeds = new SparseBooleanArray();
        list = new ArrayList<>();
        for (int i = 0; i <= 20; i++)
        {
            CheckBoxBean checkBoxBean = new CheckBoxBean();
            checkBoxBean.setName("sister" + i);
            list.add(checkBoxBean);
        }
        adapter = new MyListAdapter(list,this);
        adapter.setCheckedAllListener(this);
        listView.setAdapter(adapter);

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 遍历list的长度，将已选的设为未选，未选的设为已选
                for (int i = 0; i < list.size(); i++) {
                    if (MyListAdapter.getIsSelected().get(i)) {
                        MyListAdapter.getIsSelected().put(i, false);
                    } else {
                        MyListAdapter.getIsSelected().put(i, true);
                    }
                }
                // 刷新listview和TextView的显示
                adapter.notifyDataSetChanged();
            }
        });

        btn_select_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 遍历list的长度，将已选的按钮设为未选
                for (int i = 0; i < list.size(); i++) {
                    if (MyListAdapter.getIsSelected().get(i)) {
                        MyListAdapter.getIsSelected().put(i, false);
                    }
                }
                // 刷新listview和TextView的显示
                adapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 该点击事件放在了xml文件的android:onclick中
     * @param v
     */
    public void allSelect(View v)
    {
        System.out.println("========>>>>>>" + cb_button_all.isChecked());
//        if (cb_button_all.isChecked()) {
//            flag = true;
//        }
//        else {
//            flag = false;
//        }
//        if (flag) {
//            for (int i = 0; i < list.size(); i++) {
//
//                isCheckeds.put(i, true);
//                MyListAdapter.setIsSelected(isCheckeds);
//            }
//        }else {
//            for (int i = 0; i < list.size(); i++) {
//
//                isCheckeds.put(i, false);
//                MyListAdapter.setIsSelected(isCheckeds);
//            }
//        }

        if (cb_button_all.isChecked()) {
            for (int i = 0; i < list.size(); i++) {

                isCheckeds.put(i, true);
                MyListAdapter.setIsSelected(isCheckeds);
            }
        }else {
            for (int i = 0; i < list.size(); i++) {

                isCheckeds.put(i, false);
                MyListAdapter.setIsSelected(isCheckeds);
            }
        }


        //更新适配器
        adapter.notifyDataSetChanged();
    }

    /**
     * 全选按钮的回调事件，手否进行全选
     * @param checkall
     */
    @Override
    public void CheckAll(SparseBooleanArray checkall) {
        int a = checkall.indexOfValue(false);
        int b = checkall.indexOfValue(true);
        System.out.println(a + "----" + b);
        //判断SparseBooleanArray是否含有true
        if (checkall.indexOfValue(true) < 0) {

            if (cb_button_all.isChecked()) {
                this.flag = false;
                cb_button_all.setChecked(false);
            }

        }else if(checkall.indexOfValue(false) < 0){
            if (!cb_button_all.isChecked()) {
                this.flag = false;
                cb_button_all.setChecked(true);
            }

        }
        else if(checkall.indexOfValue(false) >= 0 && checkall.indexOfValue(true) >= 0){
            if (cb_button_all.isChecked()) {
                this.flag = true;
                cb_button_all.setChecked(false);
            }
        }
    }
}