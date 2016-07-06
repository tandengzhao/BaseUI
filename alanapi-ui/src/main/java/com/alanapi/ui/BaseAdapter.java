package com.alanapi.ui;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0  16/7/1下午12:35
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
  protected List<T> listData = new ArrayList<>();

  @Override
  public int getCount() {
    return listData.size();
  }

  @Override
  public T getItem(int position) {
    return listData.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public abstract View getView(int position, View convertView, ViewGroup parent);

  public void setListData(List<T> listData) {
    this.listData.clear();
    if(listData != null && !listData.isEmpty()) {
      this.listData.addAll(listData);
    }
    notifyDataSetChanged();
  }

  public List<T> getListData() {
    return listData;
  }

  public class BaseViewHolder {
    public View itemView;
    public BaseViewHolder(View itemView) {
      this.itemView = itemView;
    }

    public <T extends View> T getViewById(int resId) {
      return (T) itemView.findViewById(resId);
    }
  }
}
