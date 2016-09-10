package com.alanapi.ui.util;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.alanapi.ui.Activity;

/**
 * @version V1.0  16/9/9下午5:20
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ViewUtil {
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
}
