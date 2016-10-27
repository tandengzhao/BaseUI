package com.alanapi.ui;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0  16/7/1下午12:35
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
  protected List<T> listData = new ArrayList<>();

  private Map<Integer, BaseViewHolder> cacheMap = new HashMap<>();

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
  public View getView(int position, View convertView, ViewGroup parent) {
    BaseViewHolder viewHolder;
    int viewType = getItemViewType(position);

    if(convertView == null || convertView.getTag() == null || cacheMap.get(viewType) == null) {
      viewHolder = onCreateViewHolder(viewType, parent);
      convertView.setTag(viewHolder);
      cacheMap.put(viewType, viewHolder);
    } else {
      viewHolder = (BaseViewHolder) convertView.getTag();
    }
    onBindViewHolder(viewType, position, viewHolder);
    return viewHolder.itemView;
  }

  public abstract BaseViewHolder onCreateViewHolder(int viewType, ViewGroup parent);
  public abstract void onBindViewHolder(int viewType, int position, BaseViewHolder viewHolder);

  public int getItemViewType(int position) {
    return 0;
  }

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

  public void addData(T t) {
    listData.add(t);
    notifyDataSetChanged();
  }

  public void addData(int index, T t) {
    listData.add(index, t);
    notifyDataSetChanged();
  }

  public void removeData(T t) {
    listData.remove(t);
    notifyDataSetChanged();
  }

  public void removeData(int index) {
    listData.remove(index);
    notifyDataSetChanged();
  }

  public boolean containsData(T t) {
    return listData.contains(t);
  }
}
