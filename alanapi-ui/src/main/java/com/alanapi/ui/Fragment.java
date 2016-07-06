package com.alanapi.ui;

import android.os.Bundle;
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
    } else {
      ViewGroup parent = (ViewGroup) mFragmentRootView.getParent();
      if (null != parent) {
        parent.removeView(mFragmentRootView);
      }
    }
    onInitFragment();
    return mFragmentRootView;
  }

  protected void onInitFragment() {
  }

  public abstract View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

  protected View inflaterView(LayoutInflater inflater, int layoutResId) {
    return this.inflaterView(inflater, null, layoutResId);
  }
  protected View inflaterView(LayoutInflater inflater, ViewGroup container, int layoutResId) {
    return inflater.inflate(layoutResId, container, false);
  }
  protected <T extends View> T getViewById(int id) {
    return (T) mFragmentRootView.findViewById(id);
  }
}
