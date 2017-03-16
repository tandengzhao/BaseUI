package com.alanapi.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.Serializable;

/**
 * @version V1.0  16/7/1上午11:37
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIHelper {
  private static final String TAG = "UIHelper";
  public static final String _KEY_OBJECT_DATA = "_key_intent_put_value_object_data";
  public static final String _KEY_ACTIVITY_TITLE = "_key_intent_put_value_activity_title";

  /**
   * 获取默认数据 intent put activity title
   * @param activity
   * @return
   */
  public static String getActivityTitle(Activity activity) {
    return activity.getIntent().getStringExtra(_KEY_ACTIVITY_TITLE);
  }

  /**
   * 获取默认数据 intent put object data
   * @param activity
   * @return
   */
  public static Serializable getActivityData(Activity activity) {
    return activity.getIntent().getSerializableExtra(_KEY_OBJECT_DATA);
  }

  /**
   * 显示Activity
   * @param context android.content.Context
   * @param clazz show activity class
   */
  public static void showActivity(Context context, Class<?> clazz) {
    showActivity(context, clazz, null);
  }

  /**
   * 显示Activity
   * @param context android.content.Context
   * @param clazz show activity class
   * @param activityTitle show activity title name
   */
  public static void showActivity(Context context, Class<?> clazz, String activityTitle) {
    showActivity(context, clazz, activityTitle, null);
  }

  /**
   * 显示Activity
   * @param context android.content.Context
   * @param clazz show activity class
   * @param objectData show activity to data
   */
  public static void showActivity(Context context, Class<?> clazz, Serializable objectData) {
    showActivity(context, clazz, null, objectData);
  }

  /**
   * 显示Activity
   * @param context android.content.Context
   * @param clazz show activity class
   * @param activityTitle show activity title name
   * @param data show activity to data
   */
  public static void showActivity(Context context, Class<?> clazz, String activityTitle, Serializable data) {
    Intent intent = getIntent(context, clazz);
    if (activityTitle != null) {
      intent.putExtra(_KEY_ACTIVITY_TITLE, activityTitle);
    }
    if(data != null) {
      intent.putExtra(_KEY_OBJECT_DATA, data);
    }
    startActivity(context, intent);
  }

  /**
   * 显示Activity
   * @param context android.content.Context
   * @param className show activity class
   */
  public static void showActivity(Context context, String className) {
    try {
      Intent intent = getIntent(context, className);
      intent.setClassName(context, className);
      startActivity(context, intent);
    } catch (Exception e) {
      Log.e(TAG, "showActivity " + e.getMessage());
    }
  }

  /**
   *
   * @param context android.content.Context
   * @param clazz show activity class
   * @return
   */
  public static Intent getIntent(Context context, Class<?> clazz) {
    Intent intent = new Intent(context, clazz);
    if(!Activity.class.isAssignableFrom(clazz)) {
      throw new RuntimeException(clazz + " is not extends Activity");
    }
    return intent;
  }

  /**
   *
   * @param context android.content.Context
   * @param className show activity class
   * @return
   * @throws Exception
   */
  public static Intent getIntent(Context context, String className) throws Exception {
    Class<?> clazz = Class.forName(className);
    return getIntent(context, clazz);
  }

  /**
   * 显示Activity
   * @param context android.content.Context
   * @param intent
   */
  public static void startActivity(Context context, Intent intent) {
    context.startActivity(intent);
  }

  /**
   * 显示Activity
   * @param context android.content.Context
   * @param intent
   */
  public static void showActivity(Context context, Intent intent) {
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
