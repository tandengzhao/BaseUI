package com.alanapi.ui.demo.activity;

import android.view.View;

import com.alanapi.ui.ToolbarAppCompatActivity;
import com.alanapi.ui.UIHelper;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16上午11:33
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIFragmentActivity extends ToolbarAppCompatActivity implements View.OnClickListener {

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.activity311:
        UIHelper.showActivity(this, UIFragmentActivity311.class);
        break;
      case R.id.activity312:
        UIHelper.showActivity(this, UIFragmentActivity312.class);
        break;
      case R.id.activity313:
        UIHelper.showActivity(this, UIFragmentActivity313.class);
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

    getViewById(R.id.activity311).setOnClickListener(this);
    getViewById(R.id.activity312).setOnClickListener(this);
    getViewById(R.id.activity313).setOnClickListener(this);

    setTitle("ToolbarAppCompatActivity");
  }

  @Override
  protected int getContentViewLayoutResID() {
    return R.layout.activity_ui3;
  }
}
