package com.alanapi.ui;

import android.support.annotation.IdRes;
import android.view.View;

/**
 * @version V1.0  16/8/10下午12:02
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class BaseViewHolder {
  public View itemView;
  public BaseViewHolder(View itemView) {
    this.itemView = itemView;
  }

  public <T extends View> T getViewById(@IdRes int resId) {
    return (T) itemView.findViewById(resId);
  }
}
