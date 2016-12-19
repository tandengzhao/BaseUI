package com.alanapi.ui.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

import static com.alanapi.ui.ActivityManager.miniSdkInt;

/**
 * @version V1.0  16/9/9下午5:18
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class StatusBarUtil {
  private static final String TAG = "StatusBarUtil";

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param resColor 状态栏颜色值
   */
  public static void setColorResource(Activity activity, @ColorRes int resColor) {
    setColorResource(activity, resColor, -1);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param resColor 状态栏颜色值
   */
  public static void setColorResource(Activity activity, @ColorRes int resColor, float alpha) {
    setColor(activity, activity.getResources().getColor(resColor), alpha);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param color 状态栏颜色值
   */
  public static void setColor(Activity activity, int color) {
    if(Build.VERSION.SDK_INT < miniSdkInt || Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
      return;
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      activity.getWindow().setStatusBarColor(color);
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      View statusView = createStatusBarView(activity);
      statusView.setBackgroundColor(color);
      ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
      decorView.addView(statusView);
      setRootView(activity);
    }
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param color 状态栏颜色值
   * @param alpha 状态栏透明度
   */
  public static void setColor(Activity activity, int color, float alpha) {
    if(Build.VERSION.SDK_INT < miniSdkInt || Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
      return;
    }

    if(alpha == 0) {
      setTranslucent(activity);
    } else if(alpha > 0 && alpha < 1) {
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      View statusView = createStatusBarView(activity);
      statusView.setBackgroundColor(color);
      statusView.setAlpha(alpha);
      ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
      decorView.addView(statusView);
      setRootView(activity);
    } else if(alpha < 0 || alpha >= 1) {
      setColor(activity, color);
    }
  }

  /**
   * 设置状态栏透明
   * @param activity
   */
  public static void setTranslucent(Activity activity) {
    if(Build.VERSION.SDK_INT < miniSdkInt || Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
      return;
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      View statusView = createStatusBarView(activity);
      statusView.setBackgroundColor(Color.TRANSPARENT);
      statusView.setAlpha(0);
      ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
      decorView.addView(statusView);
      setRootView(activity);
    }
  }

  /**
   * 设置状态栏透明
   * @param activity
   * @param drawerLayout
   */
  public static void setDrawerLayoutTranslucent(Activity activity, DrawerLayout drawerLayout) {
    setDrawerLayoutColor(activity, drawerLayout, Color.WHITE, 0);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param resColor 状态栏颜色值
   */
  public static void setDrawerLayoutColorResource(Activity activity, DrawerLayout drawerLayout, @ColorRes int resColor) {
    setDrawerLayoutColorResource(activity, drawerLayout, resColor, -1);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param resColor 状态栏颜色值
   * @param alpha 状态栏透明度
   */
  public static void setDrawerLayoutColorResource(Activity activity, DrawerLayout drawerLayout, @ColorRes int resColor, float alpha) {
    setDrawerLayoutColor(activity, drawerLayout, activity.getResources().getColor(resColor), alpha);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param color 状态栏颜色值
   */
  public static void setDrawerLayoutColor(Activity activity, DrawerLayout drawerLayout, int color) {
    setDrawerLayoutColor(activity, drawerLayout, color, -1);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param color 状态栏颜色值
   * @param alpha 状态栏透明度
   */
  public static void setDrawerLayoutColor(Activity activity, DrawerLayout drawerLayout, int color, float alpha) {
    if(Build.VERSION.SDK_INT < miniSdkInt || Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
      return;
    }

    if(alpha < 0 || alpha >= 1) {
      setColor(activity, color);
      return;
    }
    ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
    ViewGroup drawer = (ViewGroup) drawerLayout.getChildAt(1);

    if(alpha >= 0 && alpha < 1) {
      if (!(contentLayout instanceof LinearLayout) && contentLayout.getChildAt(1) != null) {
        contentLayout.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
      }
      contentLayout.setClipToPadding(true);
      drawerLayout.setFitsSystemWindows(false);
      contentLayout.setFitsSystemWindows(true);
      drawer.setFitsSystemWindows(true);
      if(alpha == 0) {
        setTranslucent(activity);
      } else {
        View statusView = createStatusBarView(activity);
        statusView.setBackgroundColor(color);
        if(alpha >= 0 && alpha <= 1) {
          statusView.setAlpha(alpha);
        }
        ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
        if (contentView.getChildCount() > 1) {
          contentView.removeViewAt(1);
        }
        contentView.addView(statusView);
      }
    } else {
      drawerLayout.setFitsSystemWindows(false);
      contentLayout.setFitsSystemWindows(false);
      drawer.setFitsSystemWindows(false);

      setColor(activity, color);
    }
  }

  /**
   * 设置状态栏透明
   * @param activity
   * @param slidingPaneLayout
   */
  public static void setSlidingPaneLayoutTranslucent(Activity activity, SlidingPaneLayout slidingPaneLayout) {
    setSlidingPaneLayoutColor(activity, slidingPaneLayout, Color.WHITE, 0);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param resColor 状态栏颜色值
   */
  public static void setSlidingPaneLayoutColorResource(Activity activity, SlidingPaneLayout slidingPaneLayout, @ColorRes int resColor) {
    setSlidingPaneLayoutColorResource(activity, slidingPaneLayout, resColor, -1);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param resColor 状态栏颜色值
   * @param alpha 状态栏透明度
   */
  public static void setSlidingPaneLayoutColorResource(Activity activity, SlidingPaneLayout slidingPaneLayout, @ColorRes int resColor, float alpha) {
    setSlidingPaneLayoutColor(activity, slidingPaneLayout, activity.getResources().getColor(resColor), alpha);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param color 状态栏颜色值
   */
  public static void setSlidingPaneLayoutColor(Activity activity, SlidingPaneLayout slidingPaneLayout, int color) {
    setSlidingPaneLayoutColor(activity, slidingPaneLayout, color, -1);
  }

  /**
   * 设置状态栏颜色
   * @param activity 需要设置的 activity
   * @param color 状态栏颜色值
   * @param alpha 状态栏透明度
   */
  public static void setSlidingPaneLayoutColor(Activity activity, SlidingPaneLayout slidingPaneLayout, int color, float alpha) {
    if(Build.VERSION.SDK_INT < miniSdkInt || Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
      return;
    }

    if(alpha < 0 || alpha >= 1) {
      setColor(activity, color);
      return;
    }
    ViewGroup drawer = (ViewGroup) slidingPaneLayout.getChildAt(0);
    ViewGroup contentLayout = (ViewGroup) slidingPaneLayout.getChildAt(1);

    if(alpha >= 0 && alpha < 1) {
      if (!(contentLayout instanceof LinearLayout) && contentLayout.getChildAt(1) != null) {
        contentLayout.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
      }
      contentLayout.setClipToPadding(true);
      slidingPaneLayout.setFitsSystemWindows(false);
      contentLayout.setFitsSystemWindows(true);
      drawer.setFitsSystemWindows(true);
      if(alpha == 0) {
        setTranslucent(activity);
      } else {
        View statusView = createStatusBarView(activity);
        statusView.setBackgroundColor(color);
        if(alpha >= 0 && alpha <= 1) {
          statusView.setAlpha(alpha);
        }
        ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
        if (contentView.getChildCount() > 1) {
          contentView.removeViewAt(1);
        }
        contentView.addView(statusView);
      }
    } else {
      slidingPaneLayout.setFitsSystemWindows(false);
      contentLayout.setFitsSystemWindows(false);
      drawer.setFitsSystemWindows(false);

      setColor(activity, color);
    }
  }

  /**
   * 生成一个和状态栏大小相同的彩色矩形条
   * @param activity 需要设置的 activity
   * @return 状态栏矩形条
   */
  private static View createStatusBarView(Activity activity) {
    // 绘制一个和状态栏一样高的矩形
    View statusBarView = new View(activity);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
    statusBarView.setLayoutParams(params);
    return statusBarView;
  }

  /**
   * 设置根布局参数
   */
  private static void setRootView(Activity activity) {
    if(Build.VERSION.SDK_INT < miniSdkInt || Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
      return;
    }

    ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
      rootView.setFitsSystemWindows(true);
    }
    rootView.setClipToPadding(true);
  }

  /**
   * 获取状态栏高度
   * @param context context
   * @return 状态栏高度
   */
  public static int getStatusBarHeight(Context context) {
    // 获得状态栏高度
    int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if(resourceId > 0) {
      return context.getResources().getDimensionPixelSize(resourceId);
    }
    try {
      Class<?> c = Class.forName("com.android.internal.R$dimen");
      Object obj = c.newInstance();
      Field field = c.getField("status_bar_height");
      int x = Integer.parseInt(field.get(obj).toString());
      return context.getResources().getDimensionPixelSize(x);
    } catch (Exception e){
      Log.e(TAG, "getStatusBarHeight: ", e);
    }
    return 0;
  }
}
