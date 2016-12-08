package com.alanapi.ui.demo;

import com.alanapi.ui.Activity;

/**
 * @version V1.0  2016/12/8上午9:36
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ActivityDemo extends Activity {
  @Override
  protected void initActivityData() {
  }

  @Override
  protected void initActivityView() {
    setStatusBarColorResource(R.color.blue, 0.2f);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_demo;
  }
}
