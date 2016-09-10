package com.alanapi.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @version V1.0  16/7/1上午11:37
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIHelper {
  private static final String TAG = "UIHelper";
  public static final String _KEY_OBJECT_DATA = "_key_intent_put_value_object_data";
  public static final String _KEY_ACTIVITY_TITLE = "_key_intent_put_value_activity_title";

  public static void showActivity(Context context, Class<?> clazz) {
    showActivity(context, clazz, null);
  }

  public static void showActivity(Context context, Class<?> clazz, String activityTitle) {
    Intent intent = getIntent(context, clazz);
    if (activityTitle != null) {
      intent.putExtra(_KEY_ACTIVITY_TITLE, activityTitle);
    }
    startActivity(context, intent);
  }

  public static void showActivity(Context context, String className) {
    try {
      Intent intent = getIntent(context, className);
      intent.setClassName(context, className);
      startActivity(context, intent);
    } catch (Exception e) {
      Log.e(TAG, "showActivity " + e.getMessage());
    }
  }

  public static Intent getIntent(Context context, Class<?> clazz) {
    Intent intent = new Intent(context, clazz);
    if(!Activity.class.isAssignableFrom(clazz)) {
      throw new RuntimeException(clazz + " is not extends Activity");
    }
    return intent;
  }

  public static Intent getIntent(Context context, String className) throws Exception {
    Class<?> clazz = Class.forName(className);
    return getIntent(context, clazz);
  }

  public static void startActivity(Context context, Intent intent) {
    context.startActivity(intent);
  }

  public static void startActivityForResult(Activity activity, Intent intent, int requestCode){
    activity.startActivityForResult(intent, requestCode);
  }

  public static void finishActivity(final Class<?> clazz) {
    ActivityManager.getInstance().finishActivity(clazz);
  }

  public static void finishActivity(final Activity activity) {
    ActivityManager.getInstance().finishActivity(activity);
  }

  public static void finishOtherAllActivity(final Activity activity) {
    ActivityManager.getInstance().finishOtherAllActivity(activity);
  }

  public static void finishOtherAllActivity(final Class<?> clazz) {
    ActivityManager.getInstance().finishOtherAllActivity(clazz);
  }

  public static void finishOtherAllActivity(final String clazzName) {
    ActivityManager.getInstance().finishOtherAllActivity(clazzName);
  }

  public static boolean isExistActivity(Class<?> cls) {
    return ActivityManager.getInstance().isExistActivity(cls);
  }

  public static Activity getActivity(Class<?> cls) {
    return ActivityManager.getInstance().getActivity(cls);
  }

  public static Activity getLastActivity() {
    return ActivityManager.getInstance().getLastActivity();
  }

  public static Activity currentActivity() {
    return ActivityManager.getInstance().currentActivity();
  }

  public static void killApp(Context context) {
    ActivityManager.getInstance().killApp(context);
  }
}
