package com.alanapi.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.alanapi.ui.util.StatusBarUtil;

import static com.alanapi.ui.ActivityManager.isWindowTranslucentStatus;
import static com.alanapi.ui.ActivityManager.miniSdkInt;

/**
 * @version V1.0  16/7/1上午10:42
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class Activity extends android.app.Activity {
  private ActivityPresenter activityPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityPresenter = new ActivityPresenter(this);
    activityPresenter.onCreate(savedInstanceState);

    super.setContentView(getActivityContentViewLayoutResID());

    if (getWindowTranslucentStatus() && Build.VERSION.SDK_INT >= miniSdkInt && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    initActivityView();
    initActivityData();
  }

  protected boolean getWindowTranslucentStatus() {
    return isWindowTranslucentStatus;
  }

  @Override
  public void finish() {
    super.finish();
    activityPresenter.finish();
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
      if(onKeyDownBack()) {
        if(activityPresenter.onKeyDown(keyCode, event)) {
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
    return true;
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
    activityPresenter.onBackPressed();
  }

  @Override
  protected void onDestroy() {
    activityPresenter.onDestroy();
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
  protected void setStatusBarColor(int color, float alpha) {
    StatusBarUtil.setColor(this, color, alpha);
  }

  protected void setStatusBarColor(int color) {
    setStatusBarColor(color, -1);
  }

  protected void setStatusBarColorResource(@ColorRes int resColor) {
    setStatusBarColorResource(resColor, -1);
  }

  /**
   * 设置状态栏颜色
   * @param resColor
   * @param alpha 0~1的值，0完全透明，1完全不透明
   */
  protected void setStatusBarColorResource(@ColorRes int resColor, float alpha) {
    setStatusBarColor(getResources().getColor(resColor), alpha);
  }

  protected void showToastMessage(String msg) {
    activityPresenter.showToastMessage(msg);
  }

  protected void showToastMessage(View view) {
    activityPresenter.showToastMessage(view);
  }

  public void finishActivity() {
    activityPresenter.finishActivity();
  }

  protected <T extends View> T getViewById(@IdRes int id) {
    return (T) this.findViewById(id);
  }

  /**
   * 初始化数据
   */
  protected abstract void initActivityData();

  /**
   * 初始化View控件
   */
  protected abstract void initActivityView();

  /**
   * 获取ContentViewLayoutResID
   * @return
   */
  protected abstract int getActivityContentViewLayoutResID();
}
