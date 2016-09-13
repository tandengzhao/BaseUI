package com.alanapi.ui.demo;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alanapi.ui.ToolbarAppCompatActivity;

public class MainToolbarActivity extends ToolbarAppCompatActivity {

  @Override
  protected void initData() {
  }

  @Override
  protected void initView() {
    setToolbarTitle("测试公用Toolbar");
    setToolbarLeftBack("返回");
    setToolbarLeftOption("关闭");
    showToolbarLeftOption();
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
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    super.onOptionsItemSelected(item);
    switch (item.getItemId()) {
      case R.id.main_toolbar_shuffle:
        showToastMessage("随机看看");
        break;
      case R.id.main_toolbar_shuffle1:
        showToastMessage("礼物");
        break;
      case R.id.main_toolbar_search:
        showToastMessage("搜索");
        break;
      case R.id.main_toolbar_notify:
        showToastMessage("通知");
        break;
      case R.id.action_settings:
        showToastMessage("设置");
        break;
    }
    return true;
  }

  @Override
  protected void onClickToolbarLeftOption(View view) {
    showToastMessage("关闭");
  }

  public void top(View v) {
  }
  public void bottom(View v) {
  }
  public void topBottom(View v) {
  }
}
