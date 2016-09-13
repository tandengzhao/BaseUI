package com.alanapi.ui.demo;

import android.view.View;

import com.alanapi.ui.HeadbarActivity;

public class MainHeadbarActivity extends HeadbarActivity {

  @Override
  protected void initData() {
  }

  @Override
  protected void initView() {
    setToolbarTitle("Headbar");
    setToolbarLeftBack("返回");
    setToolbarLeftOption("关闭");
    showToolbarLeftOption();

    setToolbarRightOption("右侧0");
    showToolbarRightOption();
    setToolbarRightOption1("右侧1");
    showToolbarRightOption1();
    setToolbarRightOption2("右侧2");
    showToolbarRightOption2();
  }

  @Override
  protected int getContentViewLayoutResID() {
    return R.layout.activity_main_content;
  }

  @Override
  protected void onClickToolbarLeftBack(View view) {
    showToastMessage("返回");
    super.onClickToolbarLeftBack(view);
  }

  @Override
  protected void onClickToolbarLeftOption(View view) {
    showToastMessage("关闭");
  }

  @Override
  protected void onClickToolbarRightOption(View view) {
    super.onClickToolbarRightOption(view);
    showToastMessage("右侧0");
  }
  @Override
  protected void onClickToolbarRightOption1(View view) {
    super.onClickToolbarRightOption(view);
    showToastMessage("右侧1");
  }
  @Override
  protected void onClickToolbarRightOption2(View view) {
    super.onClickToolbarRightOption(view);
    showToastMessage("右侧2");
  }

  public void top(View v) {
  }
  public void bottom(View v) {
  }
  public void topBottom(View v) {
  }
}
