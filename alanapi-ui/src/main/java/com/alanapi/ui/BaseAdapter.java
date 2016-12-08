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

  private List<String> listSelectItemPosition = new ArrayList<>();
  private boolean isSingleSelectItem = false;//单选

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
      convertView = viewHolder.itemView;
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

  /**
   * 当前Item是否选中
   * @param position
   * @return
   */
  public boolean isSelectItem(int position) {
    String str = String.valueOf(position);
    return listSelectItemPosition.contains(str);
  }

  /**
   * 添加选中的Item
   * @param position
   */
  public void addSelectItem(int position) {
    String str = String.valueOf(position);
    if(isSingleSelectItem) {
      listSelectItemPosition.clear();
    }
    if(!listSelectItemPosition.contains(str)) {
      listSelectItemPosition.add(str);
    }
  }

  /**
   * 删除选中的Item
   * @param position
   */
  public void removeSelectItem(int position) {
    String str = String.valueOf(position);
    if(listSelectItemPosition.contains(str)) {
      listSelectItemPosition.remove(str);
    }
  }

  /**
   * 获取选中的Item
   * @return
   */
  public List<T> getSelectItem() {
    List<T> listSelectData = new ArrayList<>();
    int[] positions = getSelectItemPosition();
    for (int p: positions) {
      if(p > -1) {
        listSelectData.add(getItem(p));
      }
    }
    return listSelectData;
  }

  /**
   * 获取单选选中Item
   * @return
   */
  public T getSingleSelectItem() {
    int position = getSingleSelectItemPosition();
    if(position > -1 && position < getCount()) {
      return getItem(position);
    }
    return null;
  }

  /**
   * 获取单选item position
   * @return
   */
  public int getSingleSelectItemPosition() {
    int[] pos = getSelectItemPosition();
    if(pos != null && pos.length > 0) {
      if(pos[0] > -1) {
        return pos[0];
      }
    }
    return -1;
  }

  /**
   * 获取选中的Position
   * @return
   */
  public int[] getSelectItemPosition() {
    if(listSelectItemPosition.size() > 0) {
      int[] pos = new int[listSelectItemPosition.size()];
      for (int i = 0; i < listSelectItemPosition.size(); i++) {
        String positionStr = listSelectItemPosition.get(i);
        if(positionStr.matches("\\d+")) {
          int position = Integer.parseInt(positionStr);
          pos[i] = position;
        } else {
          pos[i] = -1;
        }
      }
    }
    return null;
  }

  /**
   * 设置是否单选 true:单选
   * @param singleSelectItem
   */
  public void setSingleSelectItem(boolean singleSelectItem) {
    this.isSingleSelectItem = singleSelectItem;
  }
}
