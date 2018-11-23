package com.alanapi.ui.demo.activity;

import android.util.Log;
import android.view.View;

import com.alanapi.ui.HeadbarActivity;
import com.alanapi.ui.UIHelper;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16下午6:24
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIHeadbarActivity extends HeadbarActivity implements View.OnClickListener {
  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.activityHeader111:
        UIHelper.showActivity(getContext(), UIHeadbarActivity111.class);
        break;
    }
  }

  @Override
  protected void initData() {
    super.initData();
    Log.e("Debug", "initData()");
  }

  @Override
  protected void initView() {
    super.initView();
    Log.e("Debug", "initView()");
    setTitle("普通HeadbarActivity");

    getViewById(R.id.activityHeader111).setOnClickListener(this);
  }

  @Override
  protected int getActivityLayoutResID() {
    return R.layout.activity_ui_header;
  }
}
