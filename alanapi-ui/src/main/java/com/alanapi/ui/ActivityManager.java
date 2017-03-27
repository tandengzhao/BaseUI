package com.alanapi.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.util.Stack;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * @version V1.0  16/7/1上午10:42
 * @author:OliverTan(www.tandunzhao.cn)
 */
public final class ActivityManager {
  public static boolean debug = true;
  private volatile static Stack<Activity> activityStack = new Stack<Activity>();
  private volatile static ActivityManager instance;
  private final String TAG = "ActivityManager";
  public static int miniSdkInt = Build.VERSION_CODES.LOLLIPOP;
  public static boolean isWindowTranslucentStatus = true;

  private ActivityManager() {
  }

  /**
   * 单一实例
   * @return ActivityManager
   */
  protected synchronized static ActivityManager getInstance() {
    if (instance == null) {
      synchronized (ActivityManager.class) {
        if(null == instance) {
          instance = new ActivityManager();
        }
      }
    }
    return instance;
  }

  /**
   * 添加Activity到堆栈
   * @param activity Activity实例
   */
  protected synchronized void addActivity(Activity activity) {
    if(activity == null || activity.isFinishing()) {
      return;
    }
    if (activityStack == null) {
      activityStack = new Stack<Activity>();
    }
    finishActivity(getActivity(activity.getClass()));

    activityStack.add(activity);
    if (debug) {
      Log.d(TAG, "onCreate Activity : " + activity.getClass().getName());
    }
  }

  /**
   * 移除堆栈中的Activity
   * @param activity Activity实例
   */
  protected synchronized void removeActivity(Activity activity) {
    if(activity == null) {
      return;
    }
    if(activityStack.contains(activity)) {
      if (debug) {
        Log.d(TAG, "remove Activity : " + activity.getClass().getName());
      }
      activityStack.remove(activity);
    }
  }

  /**
   * 获取当前Activity（堆栈中最后一个压入的, 不一定是最后一个显示的界面）
   * @return Activity
   */
  protected synchronized Activity currentActivity() {
    if (activityStack != null && activityStack.size() > 0) {
      return activityStack.lastElement();
    }
    return null;
  }

  /**
   * 获取最后添加的 Activity
   * @return Activity
   */
  protected Activity getLastActivity() {
    return currentActivity();
  }

  /**
   * 获取指定Activity
   * @param cls Activity Class
   * @return Activity
   */
  protected Activity getActivity(Class<?> cls) {
    for (Activity activity : activityStack) {
      if (activity.getClass().equals(cls)) {
        return activity;
      }
    }
    return null;
  }

  /**
   * 判断当前Activity 是否存在栈中
   * @param cls Activity Class
   * @return Activity
   */
  protected boolean isExistActivity(Class<?> cls) {
    for (Activity activity : activityStack) {
      if (activity.getClass().equals(cls)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 结束当前Activity（堆栈中最后一个压入的）
   */
  protected void finishActivity() {
    Stack<Activity> tmpStack = activityStack;
    if (tmpStack != null && tmpStack.size() > 0) {
      Activity activity = tmpStack.lastElement();
      finishActivity(activity);
    }
  }

  /**
   * 结束指定类名的Activity
   * @param cls Activity Class
   */
  protected void finishActivity(Class<?> cls) {
    Stack<Activity> tmpStack = activityStack;
    Activity activityTmp = null;
    for (Activity activity : tmpStack) {
      if (activity.getClass().equals(cls)) {
        activityTmp = activity;
      }
    }
    if(activityTmp != null) {
      finishActivity(activityTmp);
    }
  }

  /**
   * 结束指定类名的Activity
   * @param activityClassName Activity Class Name
   */
  protected void finishActivity(String activityClassName) {
    Activity activityTmp = null;
    for (Activity activity : activityStack) {
      if(activity.getClass().getName().equalsIgnoreCase(activityClassName)) {
        activityTmp = activity;
      }
    }
    if(activityTmp != null) {
      finishActivity(activityTmp);
    }
  }

  /**
   * 结束指定的Activity
   * @param activity Activity实例
   */
  protected void finishActivity(Activity activity) {
    try {
      if (activity != null) {
        if (activityStack != null && activityStack.size() > 0 && activityStack.contains(activity)) {
          activityStack.remove(activity);
        }
        if(!activity.isFinishing()) {
          if (debug) {
            Log.d(TAG, "finish Activity : " + activity.getClass().getName());
          }
          activity.finish();
        }
        activity = null;
      }
    } catch (Exception e) {
      Log.d(TAG, "finishActivity : " + e.getMessage());
    }
  }

  /**
   * 结束所有Activity
   */
  protected void finishAllActivity() {
    Stack<Activity> activityStackTemp = new Stack<Activity>();
    activityStackTemp.addAll(activityStack);
    for (int i = 0, size = activityStackTemp.size(); i < size; i++) {
      if (null != activityStackTemp.get(i)) {
        Activity activity = activityStackTemp.get(i);
        if(!activity.isFinishing()) {
          activity.finish();
        }
      }
    }
    activityStack.clear();
  }

  /**
   * 结束除指定视图之外的所有视图
   * @param activity Activity实例
   */
  protected void finishOtherAllActivity(Activity activity) {
    Stack<Activity> activityStackTemp = new Stack<Activity>();
    activityStackTemp.addAll(activityStack);
    for (int i = 0, size = activityStackTemp.size(); i < size; i++) {
      Activity activityOther = activityStackTemp.get(i);
      if (null != activityOther && activity != activityOther && !activityOther.isFinishing()) {
        activityOther.finish();
      }
    }
    activityStack.clear();
    addActivity(activity);
  }

  /**
   * 销毁除指定视图之外的所有视图
   * @param cls Activity Class
   */
  protected void finishOtherAllActivity(Class<?> cls) {
    Stack<Activity> activityStackTemp = new Stack<Activity>();
    activityStackTemp.addAll(activityStack);
    Activity activityTmp = null;
    for (Activity activity : activityStackTemp) {
      if (!activity.getClass().equals(cls)) {
        activity.finish();
      } else {
        activityTmp = activity;
      }
    }
    activityStack.clear();
    addActivity(activityTmp);
  }

  /**
   * 销毁除指定视图之外的所有视图
   * @param activityClassName Activity Class Name
   */
  protected void finishOtherAllActivity(String activityClassName) {
    Stack<Activity> activityStackTemp = new Stack<Activity>();
    activityStackTemp.addAll(activityStack);
    Activity activityTmp = null;
    for (Activity activity : activityStackTemp) {
      if(!activity.getClass().getName().equalsIgnoreCase(activityClassName)) {
        activity.finish();
      } else {
        activityTmp = activity;
      }
    }
    activityStack.clear();
    addActivity(activityTmp);
  }

  /**
   * 退出杀死应用程序
   * @param context Context实例
   */
  protected void killApp(Context context) {
    try {
      finishAllActivity();
      android.app.ActivityManager activityMgr = (android.app.ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
      activityMgr.restartPackage(context.getPackageName());
      activityMgr.killBackgroundProcesses(context.getPackageName());
    } catch (Exception e) {
      Log.e(TAG, "Exit app : Exception " + e.getMessage());
    } finally {
      android.os.Process.killProcess(android.os.Process.myPid());
      System.exit(0);
    }
  }
}
