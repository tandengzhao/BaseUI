package com.alanapi.ui;

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

  public <T extends View> T getViewById(int resId) {
    return (T) itemView.findViewById(resId);
  }
}
