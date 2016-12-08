package com.alanapi.ui.demo;

import com.alanapi.ui.FragmentActivity;

/**
 * @version V1.0  2016/12/8上午9:44
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class FragmentActivityDemo extends FragmentActivity {
  @Override
  protected void initActivityData() {
  }

  @Override
  protected void initActivityView() {
    setStatusBarColorResource(R.color.gray);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_fragment_demo;
  }
}
