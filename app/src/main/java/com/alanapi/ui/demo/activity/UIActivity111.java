package com.alanapi.ui.demo.activity;

import android.util.Log;

import com.alanapi.ui.Activity;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16上午11:14
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIActivity111 extends Activity {
  @Override
  protected void initView() {
    Log.e("Debug", "initView()");
  }

  @Override
  protected void initData() {
    Log.e("Debug", "initData()");
  }

  @Override
  protected int getActivityLayoutResID() {
    return R.layout.activity_ui_111;
  }
}
