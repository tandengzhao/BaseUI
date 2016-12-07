package com.alanapi.ui.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.alanapi.ui.Activity;

/**
 * @version V1.0  16/9/9下午5:20
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ViewUtil {

  /**
   * GONE View
   * @param views
   */
  public static void goneView(View... views) {
    if (views != null && views.length > 0) {
      for (View view : views) {
        if (view != null) {
          view.setVisibility(View.GONE);
        }
      }
    }
  }

  /**
   * VISIBLE View
   * @param views
   */
  public static void showView(View... views) {
    if (views != null && views.length > 0) {
      for (View view : views) {
        if (view != null) {
          view.setVisibility(View.VISIBLE);
        }
      }
    }
  }

  /**
   * VISIBLE true
   * @param view
   * @return
   */
  public static boolean isVisibleView(View view) {
    return view.getVisibility() == View.VISIBLE;
  }

  /**
   * 根据id查找View
   * @param view
   * @param resId
   * @param <V>
   * @return View
   */
  public static <V extends View> V findViewById(View view, @IdRes int resId) {
    return (V) view.findViewById(resId);
  }

  /**
   * 根据id查找View
   * @param activity
   * @param resId
   * @param <V>
   * @return View
   */
  public static <V extends View> V findViewById(Activity activity, @IdRes int resId) {
    return (V) activity.findViewById(resId);
  }

  /**
   * 强制显示软键盘
   * @param view
   */
  public static void showKeyboard(View view) {
    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
  }

  /**
   * 强制隐藏软键盘
   * @param view
   */
  public static void hideKeyboard(View view) {
    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
  }

  /**
   * 获取(InputMethodManager)
   * @param view
   * @return
   */
  public static InputMethodManager getInputMethodManager(View view) {
    return (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
  }

  /**
   * 设置TextView Left Drawable
   * @param textView
   * @param drawable
   */
  public static void setTextViewCompoundDrawableLeft(@NonNull TextView textView, Drawable drawable) {
    textView.setCompoundDrawables(getCompoundDrawable(drawable), null, null, null);
  }

  /**
   * 设置TextView Left Drawable
   * @param textView
   * @param drawableRes
   */
  public static void setTextViewCompoundDrawableLeft(@NonNull TextView textView, @DrawableRes int drawableRes) {
    setTextViewCompoundDrawableLeft(textView, textView.getResources().getDrawable(drawableRes));
  }

  /**
   * 设置TextView Right Drawable
   * @param textView
   * @param drawable
   */
  public static void setTextViewCompoundDrawableRight(@NonNull TextView textView, Drawable drawable) {
    textView.setCompoundDrawables(null, null, getCompoundDrawable(drawable), null);
  }

  /**
   * 设置TextView Right Drawable
   * @param textView
   * @param drawableRes
   */
  public static void setTextViewCompoundDrawableRight(@NonNull TextView textView, @DrawableRes int drawableRes) {
    setTextViewCompoundDrawableRight(textView, textView.getResources().getDrawable(drawableRes));
  }

  /**
   * 设置TextView Top Drawable
   * @param textView
   * @param drawable
   */
  public static void setTextViewCompoundDrawableTop(@NonNull TextView textView, Drawable drawable) {
    textView.setCompoundDrawables(null, getCompoundDrawable(drawable), null, null);
  }

  /**
   * 设置TextView Top Drawable
   * @param textView
   * @param drawableRes
   */
  public static void setTextViewCompoundDrawableTop(@NonNull TextView textView, @DrawableRes int drawableRes) {
    setTextViewCompoundDrawableTop(textView, textView.getResources().getDrawable(drawableRes));
  }

  /**
   * 设置TextView Bottom Drawable
   * @param textView
   * @param drawable
   */
  public static void setTextViewCompoundDrawableBottom(@NonNull TextView textView, Drawable drawable) {
    textView.setCompoundDrawables(null, null, null, getCompoundDrawable(drawable));
  }

  /**
   * 设置TextView Bottom Drawable
   * @param textView
   * @param drawableRes
   */
  public static void setTextViewCompoundDrawableBottom(@NonNull TextView textView, @DrawableRes int drawableRes) {
    setTextViewCompoundDrawableBottom(textView, textView.getResources().getDrawable(drawableRes));
  }

  /**
   * 获取Drawable
   * @param drawable
   * @return Drawable
   */
  public static Drawable getCompoundDrawable(Drawable drawable) {
    if(drawable != null) {
      drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }
    return drawable;
  }

  /**
   * 获取Drawable
   * @param context
   * @param drawableRes
   * @return
   */
  public static Drawable getDrawable(Context context, @DrawableRes int drawableRes) {
    return getDrawable(context.getResources(), drawableRes);
  }

  /**
   * 获取Drawable
   * @param resources
   * @param drawableRes
   * @return
   */
  public static Drawable getDrawable(Resources resources, @DrawableRes int drawableRes) {
    return resources.getDrawable(drawableRes);
  }
}
