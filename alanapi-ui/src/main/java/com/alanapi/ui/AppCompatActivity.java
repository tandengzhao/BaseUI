package com.alanapi.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.alanapi.ui.util.StatusBarUtil;

import static com.alanapi.ui.ActivityManager.isWindowTranslucentStatus;
import static com.alanapi.ui.ActivityManager.miniSdkInt;

/**
 * @version V1.0  16/7/1上午11:32
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class AppCompatActivity extends android.support.v7.app.AppCompatActivity {
  private ActivityPresenter activityPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    activityPresenter = new ActivityPresenter(this);
    activityPresenter.onCreate(savedInstanceState);

    if (getWindowTranslucentStatus() && Build.VERSION.SDK_INT >= miniSdkInt && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    super.onCreate(savedInstanceState);

    int layoutId = getActivityContentViewLayoutResID();
    if(layoutId > 1) {
      super.setContentView(layoutId);
      initActivityView();
      initActivityData();
    }
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
    initActivityView();
    initActivityData();
  }

  @Override
  public void setContentView(View view) {
    super.setContentView(view);
    initActivityView();
    initActivityData();
  }

  @Override
  public void setContentView(View view, ViewGroup.LayoutParams params) {
    super.setContentView(view, params);
    initActivityView();
    initActivityData();
  }

  protected boolean getWindowTranslucentStatus() {
    return isWindowTranslucentStatus;
  }

  @Override
  public void finish() {
    super.finish();
    if(activityPresenter != null) {
      activityPresenter.finish();
    }
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
      if(!onKeyDownBack()) {
        if(activityPresenter != null && activityPresenter.onKeyDown(keyCode, event)) {
          return true;
        }
      } else {
        //自定义劫持 back 事件
        return true;
      }
    } else if (keyCode == KeyEvent.KEYCODE_MENU) {
      if(onKeyDownMenu()) {
        return true;
      }
    } else if (keyCode == KeyEvent.KEYCODE_HOME) {
      if(onKeyDownHome()) {
        return true;
      }
    }
    return super.onKeyDown(keyCode, event);
  }

  public boolean onKeyDownBack() {
    return false;
  }

  public boolean onKeyDownMenu() {
    return false;
  }

  public boolean onKeyDownHome() {
    return false;
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    if(activityPresenter != null) {
      activityPresenter.onBackPressed();
    }
  }

  @Override
  protected void onDestroy() {
    if(activityPresenter != null) {
      activityPresenter.onDestroy();
    }
    activityPresenter = null;
    super.onDestroy();
  }

  /**
   * 获取当前Activity Context
   * @return
   */
  protected Context getContext() {
    return this;
  }

  /**
   * 设置状态栏颜色
   * @param color
   * @param alpha 0~1的值，0完全透明，1完全不透明
   */
  protected void setStatusBarColor(@ColorInt int color, @FloatRange(from = 0, to = 1)float alpha) {
    StatusBarUtil.setColor(this, color, alpha);
  }

  protected void setStatusBarColor(@ColorInt int color) {
    setStatusBarColor(color, 1);
  }

  protected void setStatusBarColorResource(@ColorRes int resColor) {
    setStatusBarColorResource(resColor, 1);
  }

  /**
   * 设置状态栏颜色
   * @param resColor
   * @param alpha 0~1的值，0完全透明，1完全不透明
   */
  protected void setStatusBarColorResource(@ColorRes int resColor, @FloatRange(from = 0, to = 1)float alpha) {
    setStatusBarColor(getResources().getColor(resColor), alpha);
  }

  protected void showToastMessage(String msg) {
    if(activityPresenter != null) {
      activityPresenter.showToastMessage(msg);
    }
  }

  protected void showToastMessage(View view) {
    if(activityPresenter != null) {
      activityPresenter.showToastMessage(view);
    }
  }

  public void finishActivity() {
    if(activityPresenter != null) {
      activityPresenter.finishActivity();
    }
  }

  protected <T extends View> T getViewById(@IdRes int id) {
    return (T) this.findViewById(id);
  }

  /**
   * 初始化数据
   */
  protected void initActivityData() {
    this.initData();
  }

  /**
   * 初始化View控件
   */
  protected void initActivityView() {
    this.initView();
  }

  /**
   * 获取ContentViewLayoutResID
   * @return
   */
  protected int getActivityContentViewLayoutResID() {
    return getActivityLayoutResID();
  }


  /**
   * 获取ContentViewLayoutResID
   * @return
   */
  protected int getActivityLayoutResID() {
    return -1;
  }

  /**
   * 初始化数据
   */
  protected void initData() {
  }

  /**
   * 初始化View控件
   */
  protected void initView() {
  }
}
