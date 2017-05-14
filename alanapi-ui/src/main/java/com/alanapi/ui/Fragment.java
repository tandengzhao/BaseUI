package com.alanapi.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @version V1.0  16/7/1上午11:35
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class Fragment extends android.support.v4.app.Fragment {
  protected View mFragmentRootView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if (mFragmentRootView == null) {
      mFragmentRootView = getFragmentView(inflater, container, savedInstanceState);
      if(mFragmentRootView == null) {
        throw new IllegalStateException(this.getClass().getSimpleName() + "必须getFragmentLayoutResId() 或者 getFragmentLayoutView() ，且获取View不能为空");
      }
      onInitFragment(savedInstanceState);
    } else {
      ViewGroup parent = (ViewGroup) mFragmentRootView.getParent();
      if (null != parent) {
        parent.removeView(mFragmentRootView);
      }
    }
    return mFragmentRootView;
  }

  protected void onInitFragment(Bundle savedInstanceState) {
  }
  protected View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if(getFragmentLayoutResId() > 0) {
      return inflaterView(inflater, container, getFragmentLayoutResId());
    }
    return getFragmentLayoutView();
  }
  protected View inflaterView(LayoutInflater inflater, int layoutResId) {
    return this.inflaterView(inflater, null, layoutResId);
  }
  protected View inflaterView(LayoutInflater inflater, ViewGroup container, int layoutResId) {
    return inflater.inflate(layoutResId, container, false);
  }
  protected <T extends View> T getViewById(@IdRes int id) {
    return (T) mFragmentRootView.findViewById(id);
  }

  public int getFragmentLayoutResId() {
    return -1;
  }
  public View getFragmentLayoutView() {
    return null;
  }
}
