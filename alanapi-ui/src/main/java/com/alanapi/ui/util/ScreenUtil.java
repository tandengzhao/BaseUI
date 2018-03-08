package com.alanapi.ui.util;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alanapi.ui.UIHelper;

/**
 * @version V1.0  2017/10/10下午5:35
 * @author:OliverTan(www.tandunzhao.cn)
 */
public final class ScreenUtil {
  public static final String TAG = "ScreenUtil";


  /**
   * 获得当前系统屏幕亮度值
   * @return 0~100
   */
  public static float getSystemScreenBrightness(Context context) {
    int screenBrightness = 255;
    try {
      screenBrightness = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
    } catch (Exception e) {
      Log.e(TAG, "getScreenBrightness: ", e);
    }
    return screenBrightness / 255.0F * 100;
  }

  /**
   * 设置当前系统屏幕亮度值
   * @param paramInt 0~100
   */
  public static void setSystemScreenBrightness(Context context, int paramInt) {
    if (paramInt <= 5) {
      paramInt = 5;
    }
    try {
      float f = paramInt / 100.0F * 255;
      Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, (int) f);
    } catch (Exception e) {
      Log.e(TAG, "setScreenBrightness: ", e);
    }
  }

  /**
   * 设置Activity的亮度
   * @param mActivity
   * @param paramInt
   */
  public static void setActivityBrightness(Activity mActivity, int paramInt) {
    if (paramInt <= 5) {
      paramInt = 5;
    }
    Window localWindow = mActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    float f = paramInt / 100.0F;
    localLayoutParams.screenBrightness = f;
    localWindow.setAttributes(localLayoutParams);
  }



  /**
   * 获取屏幕宽度
   * @param context
   * @return
   */
  public static int getScreenWidth(Context context) {
    DisplayMetrics outMetrics = new DisplayMetrics();
    getWindowManager(context).getDefaultDisplay().getMetrics(outMetrics);
    return outMetrics.widthPixels;
  }

  /**
   * 获取屏幕高度
   * @param context
   * @return
   */
  public static int getScreenHeight(Context context) {
    DisplayMetrics outMetrics = new DisplayMetrics();
    getWindowManager(context).getDefaultDisplay().getMetrics(outMetrics);
    int screenHeight = outMetrics.heightPixels;

    if(getSystemBarHeight(context) == 0 && getNavigationBarHeight(context) == 0) {
      //没有虚拟按键
      return screenHeight;
    }

    try {
      //OPPO 带虚拟按键的手机，需要这样才能获取到真正的屏幕高度
      if(UIHelper.getLastActivity() != null) {
        View view = UIHelper.getLastActivity().findViewById(android.R.id.content);
        if(view.getMeasuredHeight() > screenHeight) {
          screenHeight = view.getMeasuredHeight();
        }
      }
    } catch (Exception e) {
    }
    return screenHeight;
  }

  /**
   * 获取StatusBar高度
   * @param context
   * @return
   */
  public static int getStatusBarHeight(Context context) {
    int result = 0;
    try {
      int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (resourceId > 0) {
        result = context.getResources().getDimensionPixelSize(resourceId);
      }
    } catch (Exception e) {
    }
    return result;
  }

  public static int getNavigationBarHeight(Context context) {
    int result = 0;
    try {
      int resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
      if (resourceId > 0) {
        result = context.getResources().getDimensionPixelSize(resourceId);
      }
    } catch (Exception e) {
    }
    return result;
  }

  public static int getSystemBarHeight(Context context) {
    int result = 0;
    try {
      int resourceId = context.getResources().getIdentifier("system_bar_height", "dimen", "android");
      if (resourceId > 0) {
        result = context.getResources().getDimensionPixelSize(resourceId);
      }
    } catch (Exception e) {
    }
    return result;
  }

  public static WindowManager getWindowManager(Context context) {
    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    return wm;
  }

  public static EScreenDensity getScreenDensity(Context context) {
    EScreenDensity eScreenDensity;
    //初始化屏幕密度
    DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
    int densityDpi = dm.densityDpi;
    if (densityDpi <= 160) {
      eScreenDensity = EScreenDensity.MDPI;
    } else if (densityDpi <= 240) {
      eScreenDensity = EScreenDensity.HDPI;
    } else if (densityDpi < 400) {
      eScreenDensity = EScreenDensity.XHDPI;
    } else {
      eScreenDensity = EScreenDensity.XXHDPI;
    }
    return eScreenDensity;
  }

  public enum EScreenDensity {
    XXHDPI,    //超高分辨率    1080×1920
    XHDPI,    //超高分辨率    720×1280
    HDPI,    //高分辨率         480×800
    MDPI,    //中分辨率         320×480
  }
}
