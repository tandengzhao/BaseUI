package com.alanapi.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

/**
 * @version V1.0  16/7/1上午10:42
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class Activity extends android.app.Activity {
  private ActivityPresenter activityPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityPresenter = new ActivityPresenter(this);
    activityPresenter.onCreate(savedInstanceState);
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
    return activityPresenter.onKeyDownBack();
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

  protected void showToastMessage(String msg) {
    activityPresenter.showToastMessage(msg);
  }

  protected void showToastMessage(View view) {
    activityPresenter.showToastMessage(view);
  }

  public void finishActivity() {
    activityPresenter.finishActivity();
  }

  protected <T extends View> T getViewById(int id) {
    return (T) this.findViewById(id);
  }
}
