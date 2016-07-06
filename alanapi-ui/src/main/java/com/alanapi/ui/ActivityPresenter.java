package com.alanapi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

/**
 * @version V1.0  16/7/1上午11:11
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ActivityPresenter {
  private Activity activity;
  private Toast toast;

  public ActivityPresenter(Activity activity) {
    this.activity = activity;
  }

  public void onCreate(Bundle savedInstanceState) {
    ActivityManager.getInstance().addActivity(activity);
  }

  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
      if (toast != null) {
        toast.cancel();
        toast = null;
      }
      ActivityManager.getInstance().finishActivity(activity);
      //不需要继续执行父类继续处理事件
      return true;
    }
    return false;
  }

  public void finish() {
    if (toast != null) {
      toast.cancel();
      toast = null;
    }
    ActivityManager.getInstance().removeActivity(activity);
  }

  public void onBackPressed() {
    finishActivity();
  }

  public void finishActivity() {
    ActivityManager.getInstance().finishActivity(activity);
  }

  public void onDestroy() {
    finishActivity();
    activity = null;
  }

  public void showToastMessage(String msg) {
    if(msg != null && msg.trim().length() > 0) {
      if (toast != null) {
        toast.setText(msg);
      } else {
        toast = Toast.makeText(activity, msg, Toast.LENGTH_LONG);
      }
      toast.setDuration(Toast.LENGTH_LONG);
      toast.show();
    }
  }

  protected void showToastMessage(View view) {
    if (toast != null) {
    } else {
      toast = new Toast(activity);
    }
    toast.setView(view);
    toast.setDuration(Toast.LENGTH_LONG);
    toast.show();
  }
}
