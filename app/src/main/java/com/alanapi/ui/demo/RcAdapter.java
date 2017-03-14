package com.alanapi.ui.demo;

import android.view.View;
import android.view.ViewGroup;

import com.alanapi.ui.BaseRecyclerAdapter;
import com.alanapi.ui.BaseViewHolder;

/**
 * @version V1.0  2017/3/14下午2:49
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class RcAdapter extends BaseRecyclerAdapter<Object> {
  @Override
  public ViewHolder onCreateViewHolder(int viewType, ViewGroup parent) {
    return null;
  }

  @Override
  public void onBindViewHolder(int viewType, int position, BaseViewHolder viewHolder) {
  }

  private class ViewHolder extends BaseViewHolder {
    public ViewHolder(View itemView) {
      super(itemView);
    }
  }
}
