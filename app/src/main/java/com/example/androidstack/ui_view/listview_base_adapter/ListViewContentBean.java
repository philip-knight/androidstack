package com.example.androidstack.ui_view.listview_base_adapter;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-06
 * Time: 21:56
 * Desc:
 * Version:
 */
public class ListViewContentBean {
    private String mTitle;
    private String mSubTitle;
    private int mImages;
    private boolean isCheck;

    public ListViewContentBean() {
    }

    public ListViewContentBean(String mTitle, String mSubTitle, int mImages) {
        this.mTitle = mTitle;
        this.mSubTitle = mSubTitle;
        this.mImages = mImages;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSubTitle() {
        return mSubTitle;
    }

    public void setmSubTitle(String mSubTitle) {
        this.mSubTitle = mSubTitle;
    }

    public int getmImages() {
        return mImages;
    }

    public void setmImages(int mImages) {
        this.mImages = mImages;
    }

    public boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean check) {
        isCheck = check;
    }
}
