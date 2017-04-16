package com.alanapi.ui.demo.activity;

import android.view.View;

import com.alanapi.ui.HeadbarAppCompatActivity;
import com.alanapi.ui.UIHelper;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16上午11:19
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIAppCompatActivity extends HeadbarAppCompatActivity implements View.OnClickListener {

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.activity211:
        UIHelper.showActivity(this, UIAppCompatActivity211.class);
        break;
      case R.id.activity212:
        UIHelper.showActivity(this, UIAppCompatActivity212.class);
        break;
      case R.id.activity213:
        UIHelper.showActivity(this, UIAppCompatActivity213.class);
        break;
    }
  }

  @Override
  protected void initData() {
    super.initData();
  }

  @Override
  protected void initView() {
    super.initView();
    getViewById(R.id.activity211).setOnClickListener(this);
    getViewById(R.id.activity212).setOnClickListener(this);
    getViewById(R.id.activity213).setOnClickListener(this);

    setTitle("HeadbarAppCompatActivity");
  }

  @Override
  protected int getContentViewLayoutResID() {
    return R.layout.activity_ui2;
  }
}
