package com.alanapi.ui.demo;

import com.alanapi.ui.AppCompatActivity;

/**
 * @version V1.0  2016/12/8上午9:45
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class AppCompatActivityDemo extends AppCompatActivity {
  @Override
  protected void initActivityData() {
  }

  @Override
  protected void initActivityView() {
    setStatusBarColorResource(R.color.yellow);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_app_compat_demo;
  }
}
