package com.example.androidstack.ui_view.listview_base_adapter;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidstack.R;

import java.util.ArrayList;

public class ListViewBaseAdapterActivity extends AppCompatActivity implements ListViewBaseAdapter.CheckedAllListener {

    private ListView listView;
    private Button mBtnSelectAllMirror, mBtnCancel;
    private CheckBox mCheckBoxAll;
    private SparseBooleanArray isCheckeds = new SparseBooleanArray();
    private ArrayList<ListViewContentBean> mListViewContentBean;
    private ListViewBaseAdapter mListViewBaseAdapter;
    private boolean mCheckBoxFlag = false;

    private String[] simple_title = {
            "listview2", "listview2", "listview3", "listview4", "listview5", "listview6",
            "listview1", "listview2", "listview3", "listview4", "listview5", "listview6",
            "listview1", "listview2", "listview3", "listview4", "listview5", "listview6",
            "listview1", "listview2", "listview3", "listview4", "listview5", "listview6",
            "listview1", "listview2", "listview3", "listview4", "listview5", "listview6"
    };

    private String[] simple_subTitle = {
            "sublistview1", "sublistview2", "sublistview3", "sublistview4", "sublistview5", "sublistview6",
            "sublistview1", "sublistview2", "sublistview3", "sublistview4", "sublistview5", "sublistview6",
            "sublistview1", "sublistview2", "sublistview3", "sublistview4", "sublistview5", "sublistview6",
            "sublistview1", "sublistview2", "sublistview3", "sublistview4", "sublistview5", "sublistview6",
            "sublistview1", "sublistview2", "sublistview3", "sublistview4", "sublistview5", "sublistview6"
    };

    private int[] simple_imageIds = new int[]{
            R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai,
            R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai,
            R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai,
            R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai,
            R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai, R.drawable.libai
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_base_adapter);
        init();
    }

    private void init() {
        initView();
//        initListener();
        initSimpleAdapterData();
    }

    private void initView() {
        listView = findViewById(R.id.list_view_adapter);
        mBtnSelectAllMirror = findViewById(R.id.btn_select_all_mirror);
        mBtnCancel = findViewById(R.id.btn_cancel);
        mCheckBoxAll = findViewById(R.id.checkbox_all_button);
    }

//    private void initListener() {
//        mBtnSelectAllMirror.setOnClickListener(this);
//        mBtnCancel.setOnClickListener(this);
//    }

    private void initSimpleAdapterData() {

        mListViewContentBean = new ArrayList<>();

        for (int i = 0; i < simple_title.length; i++) {
            mListViewContentBean.add(new ListViewContentBean(simple_title[i], simple_subTitle[i], simple_imageIds[i]));
        }

        mListViewBaseAdapter = new ListViewBaseAdapter(mListViewContentBean, ListViewBaseAdapterActivity.this);

        try {
            listView.setAdapter(mListViewBaseAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mListViewBaseAdapter.setCheckedAllListener(this);

        mBtnSelectAllMirror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mListViewContentBean.size(); i++) {
                    if (ListViewBaseAdapter.getIsSelected().get(i)) {
                        ListViewBaseAdapter.getIsSelected().put(i, false);
                    } else {
                        ListViewBaseAdapter.getIsSelected().put(i, true);
                    }
                }
                mListViewBaseAdapter.notifyDataSetChanged();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mListViewContentBean.size(); i++) {
                    if (ListViewBaseAdapter.getIsSelected().get(i)) {
                        ListViewBaseAdapter.getIsSelected().put(i, false);
                    }
                }
                mListViewBaseAdapter.notifyDataSetChanged();
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_select_all_mirror:
//                mBtnSelectAllMirror.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        for (int i = 0; i < simple_title.length; i++) {
//                            if (ListViewBaseAdapter.getIsSelected().get(i)) {
//                                ListViewBaseAdapter.getIsSelected().put(i, false);
//                            } else {
//                                ListViewBaseAdapter.getIsSelected().put(i, true);
//                            }
//                        }
//                        mListViewBaseAdapter.notifyDataSetChanged();
//                    }
//                });
//                break;
//            case R.id.btn_cancel:
//                mBtnCancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        for (int i = 0; i < simple_title.length; i++) {
//                            if (ListViewBaseAdapter.getIsSelected().get(i)) {
//                                ListViewBaseAdapter.getIsSelected().put(i, false);
//                            }
//                        }
//                        mListViewBaseAdapter.notifyDataSetChanged();
//                    }
//                });
//                break;
//            default:
//                break;
//        }
//    }

    public void allSelect(View v) {
        if (mCheckBoxAll.isChecked()) {
            mCheckBoxFlag = true;
        } else {
            mCheckBoxFlag = false;
        }

        if (mCheckBoxFlag) {
            for (int i = 0; i < mListViewContentBean.size(); i++) {
                isCheckeds.put(i, true);
                ListViewBaseAdapter.setIsSelected(isCheckeds);
            }
        } else {
            for (int i = 0; i < mListViewContentBean.size(); i++) {
                isCheckeds.put(i, false);
                ListViewBaseAdapter.setIsSelected(isCheckeds);
            }
        }
        mListViewBaseAdapter.notifyDataSetChanged();
    }

    @Override
    public void checkAll(SparseBooleanArray checkall) {
        if (checkall.indexOfValue(true) < 0) {
            if (mCheckBoxAll.isChecked()) {
                this.mCheckBoxFlag = false;
                mCheckBoxAll.setChecked(false);
            } else if (checkall.indexOfValue(false) < 0) {
                if (!mCheckBoxAll.isChecked()) {
                    this.mCheckBoxFlag = false;
                    mCheckBoxAll.setChecked(true);
                }
            } else if (checkall.indexOfValue(false) >= 0 && checkall.indexOfValue(true) >= 0) {
                if (mCheckBoxAll.isChecked()) {
                    this.mCheckBoxFlag = true;
                    mCheckBoxAll.setChecked(false);
                }
            }
        }
    }
}
