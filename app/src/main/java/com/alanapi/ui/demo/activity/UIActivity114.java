package com.alanapi.ui.demo.activity;

import android.os.Bundle;
import android.util.Log;

import com.alanapi.ui.Activity;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16上午11:14
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIActivity114 extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ui_114);
  }

  @Override
  protected void initView() {
    Log.e("Debug", "initView()");
  }

  @Override
  protected void initData() {
    Log.e("Debug", "initData()");
  }
}
