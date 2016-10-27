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
public final class ActivityPresenter {
  private Activity activity;
  private Toast toast;

  protected ActivityPresenter(Activity activity) {
    this.activity = activity;
  }

  protected void onCreate(Bundle savedInstanceState) {
    ActivityManager.getInstance().addActivity(activity);
  }

  protected boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
      return onKeyDownBack();
    }
    return false;
  }

  protected boolean onKeyDownBack() {
    if (toast != null) {
      toast.cancel();
      toast = null;
    }
    ActivityManager.getInstance().finishActivity(activity);
    return true;
  }

  protected void finish() {
    if (toast != null) {
      toast.cancel();
      toast = null;
    }
    ActivityManager.getInstance().removeActivity(activity);
  }

  protected void onBackPressed() {
    finishActivity();
  }

  protected void finishActivity() {
    ActivityManager.getInstance().finishActivity(activity);
  }

  protected void onDestroy() {
    finishActivity();
    activity = null;
  }

  protected void showToastMessage(String msg) {
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
