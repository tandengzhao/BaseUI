package com.alanapi.ui.demo.activity;

import android.util.Log;
import android.view.View;

import com.alanapi.ui.HeadbarActivity;
import com.alanapi.ui.UIHelper;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16上午11:14
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIActivity extends HeadbarActivity implements View.OnClickListener {

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.activity111:
        UIHelper.showActivity(this, UIActivity111.class);
        break;
      case R.id.activity112:
        UIHelper.showActivity(this, UIActivity112.class);
        break;
      case R.id.activity113:
        UIHelper.showActivity(this, UIActivity113.class);
        break;
      case R.id.activity114:
        UIHelper.showActivity(this, UIActivity114.class);
        break;
      case R.id.activityHeader111:
        UIHelper.showActivity(getContext(), UIHeadbarActivity111.class);
        break;
      case R.id.activityHeader112:
        UIHelper.showActivity(getContext(), UIHeadbarActivity112.class);
        break;
      case R.id.activityHeader113:
        UIHelper.showActivity(getContext(), UIHeadbarActivity113.class);
        break;
    }
  }

  @Override
  protected void initData() {
    Log.e("Debug", "initData()");
  }

  @Override
  protected void initView() {
    Log.e("Debug", "initView()");

    setTitle("HeadbarActivity");

    getViewById(R.id.activity111).setOnClickListener(this);
    getViewById(R.id.activity112).setOnClickListener(this);
    getViewById(R.id.activity113).setOnClickListener(this);
    getViewById(R.id.activity114).setOnClickListener(this);
    getViewById(R.id.activityHeader111).setOnClickListener(this);
    getViewById(R.id.activityHeader112).setOnClickListener(this);
    getViewById(R.id.activityHeader113).setOnClickListener(this);

  }

  @Override
  protected int getActivityLayoutResID() {
    return R.layout.activity_ui1;
  }
}
