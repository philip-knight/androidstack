package com.example.androidstack.ui_view.listview_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.androidstack.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.*;

public class ListViewAdapterActivity extends AppCompatActivity {

    ListView listView1, listView2;

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
        setContentView(R.layout.activity_list_view_adapter);
        init();
        Toast.makeText(this,"", Toast.LENGTH_LONG).show();
    }

    private void init() {
        initView();
        initArrayAdapterData();
        initSimpleAdapterData();
    }

    private void initView() {
        listView1 = findViewById(R.id.list1);
        listView2 = findViewById(R.id.list2);
    }

    private void initArrayAdapterData() {
        String[] arr1 = {
                "listview1", "listview2", "listview3", "listview4", "listview5", "listview6",
                "listview1", "listview2", "listview3", "listview4", "listview5", "listview6",
                "listview1", "listview2", "listview3", "listview4", "listview5", "listview6",
                "listview1", "listview2", "listview3", "listview4", "listview5", "listview6",
                "listview1", "listview2", "listview3", "listview4", "listview5", "listview6"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.array_item, arr1);
        listView1.setAdapter(adapter);
        setListViewClickListener(listView1);
    }

    private void initSimpleAdapterData() {

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < simple_title.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("title", simple_title[i]);
            listItem.put("sublTitle", simple_subTitle[i]);
            listItem.put("imagesIds", simple_imageIds[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems, R.layout.simple_item,
                new String[] {"title","sublTitle","imagesIds"},
                new int[] {R.id.simple_title,R.id.simple_subtitle,R.id.simple_image});

        listView2.setAdapter(simpleAdapter);
        setListViewClickListener(listView2);
    }

    private void setListViewClickListener(ListView listview){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewAdapterActivity.this,simple_title[position].toString() , Toast.LENGTH_LONG).show();
            }
        });

        listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewAdapterActivity.this,simple_title[position].toString() + "选中了", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
