package com.alanapi.ui.demo;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

import com.alanapi.ui.HeadbarActivity;

import java.lang.reflect.Field;

public class MainHeadbarActivity extends HeadbarActivity {

  @Override
  protected void initData() {
  }

  @Override
  protected void initView() {
//    rootActivityLayout.setBackgroundResource(R.color.toolbar_background);
//    rootActivityLayout.setBackgroundResource(R.drawable.bg_xn);
//    rootActivityLayout.setFitsSystemWindows(true);
//    rootHeadBarLayout.setFitsSystemWindows(false);
//    setStatusBar(rootHeadBarLayout);
//    setHeadBarBackgroundResource(R.drawable.head_title);
    setStatusBarColorResource(R.color.blue, 0.1f);

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

  protected void setStatusBar(final ViewGroup layoutTitle) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      final int statusHeight = getStatusBarHeight();
      layoutTitle.post(new Runnable() {
        @Override
        public void run() {
          int titleHeight = layoutTitle.getHeight();
          android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) layoutTitle.getLayoutParams();
          //params.topMargin = statusHeight;
          params.height = statusHeight + titleHeight;
          layoutTitle.setLayoutParams(params);
        }
      });
    }
  }

  protected int getStatusBarHeight(){
    try {
      Class<?> c=Class.forName("com.android.internal.R$dimen");
      Object obj=c.newInstance();
      Field field=c.getField("status_bar_height");
      int x=Integer.parseInt(field.get(obj).toString());
      return  getResources().getDimensionPixelSize(x);
    } catch (Exception e){
      e.printStackTrace();
    }
    return 0;
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
