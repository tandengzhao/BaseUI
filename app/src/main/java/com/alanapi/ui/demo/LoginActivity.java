package com.alanapi.ui.demo;

import com.alanapi.ui.HeadbarAppCompatActivity;

/**
 * @version V1.0  16/10/12下午2:48
 * @author:OliverTan(www.tandunzhao.cn)
 */

public class LoginActivity extends HeadbarAppCompatActivity {

  @Override
  protected void initData() {
  }

  @Override
  protected void initView() {
    setActivityBackgroundResource(R.drawable.bg_xn);
    setToolBarBackgroundTransparent();
  }

  @Override
  protected int getContentViewLayoutResID() {
    return R.layout.activity_login;
  }
}
