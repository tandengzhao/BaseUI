package com.alanapi.ui.demo;

import android.view.View;
import android.view.ViewGroup;

import com.alanapi.ui.BaseAdapter;
import com.alanapi.ui.BaseViewHolder;

/**
 * @version V1.0  16/8/10下午2:07
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ListAdapter extends BaseAdapter<Person> {
  @Override
  public ViewHolder onCreateViewHolder(int viewType, ViewGroup parent) {
    return null;
  }

  @Override
  public void onBindViewHolder(int viewType, int position, BaseViewHolder h) {
  }

  public class ViewHolder extends BaseViewHolder {
    public ViewHolder(View itemView) {
      super(itemView);
    }
  }
}
