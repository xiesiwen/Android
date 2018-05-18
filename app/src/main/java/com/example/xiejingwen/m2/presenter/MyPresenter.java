package com.example.xiejingwen.m2.presenter;

import com.example.xiejingwen.m2.ui.ISetTxt;

/**
 * Created by xiejingwen on 2017/11/13.
 */

public class MyPresenter implements IPresenter{
    private ISetTxt iSetTxt;

    public MyPresenter(ISetTxt iSetTxt) {
        this.iSetTxt = iSetTxt;
        iSetTxt.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
