package com.alanapi.ui;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @version V1.0  16/8/10下午12:02
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
  private int viewHolderType;
  public BaseViewHolder(View itemView) {
    super(itemView);
  }

  public int getViewHolderType() {
    return viewHolderType;
  }

  public void setViewHolderType(int viewHolderType) {
    this.viewHolderType = viewHolderType;
  }

  public <T extends View> T getViewById(@IdRes int resId) {
    return (T) itemView.findViewById(resId);
  }
}
