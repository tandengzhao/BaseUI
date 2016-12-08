package com.alanapi.ui.demo;

import android.view.View;

import com.alanapi.ui.AppCompatActivity;
import com.alanapi.ui.UIHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.activity:
        UIHelper.showActivity(this, ActivityDemo.class);
        break;
      case R.id.fragmentActivity:
        UIHelper.showActivity(this, FragmentActivityDemo.class);
        break;
      case R.id.appActivity:
        UIHelper.showActivity(this, AppCompatActivityDemo.class);
        break;
      case R.id.drawerActivity:
        UIHelper.showActivity(this, ActivityDrawerLayoutDemo.class);
        break;
      case R.id.slidingPaneActivity:
        UIHelper.showActivity(this, ActivitySlidingPaneLayoutDemo.class);
        break;
    }
  }

  @Override
  protected void initActivityData() {
  }

  @Override
  protected void initActivityView() {
    getViewById(R.id.activity).setOnClickListener(this);
    getViewById(R.id.fragmentActivity).setOnClickListener(this);
    getViewById(R.id.appActivity).setOnClickListener(this);
    getViewById(R.id.drawerActivity).setOnClickListener(this);
    getViewById(R.id.slidingPaneActivity).setOnClickListener(this);

    setStatusBarColorResource(R.color.purple);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_main;
  }

  public void onMainToolbar(View v) {
    UIHelper.showActivity(this, MainToolbarActivity.class);
  }
  public void onMainHeadbar(View v) {
    UIHelper.showActivity(this, MainHeadbarActivity.class);
  }
  public void onMainHeadbarAppCompat(View v) {
    UIHelper.showActivity(this, MainHeadbarAppCompatActivity.class);
  }
  public void onLogin(View v) {
    UIHelper.showActivity(this, LoginActivity.class);
  }
}
