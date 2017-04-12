package com.alanapi.ui;

import android.content.Context;
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

  private List<String> listSelectItemPosition = new ArrayList<>();
  private boolean isSingleSelectItem = false;//单选

  private OnSelectItemChangeListener onSelectItemChangeListener;

  protected Context context;

  public BaseAdapter() {
    super();
  }

  public BaseAdapter(Context context) {
    this();
    this.context = context;
  }

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
    if(this.context == null) {
      this.context = parent.getContext();
    }

    BaseViewHolder viewHolder = null;
    int viewType = getItemViewType(position);

    if(convertView == null) {
      viewHolder = onCreateViewHolder(viewType, parent);

    } else {
      Object objHolder = convertView.getTag();
      if(objHolder != null && objHolder instanceof BaseViewHolder && ((BaseViewHolder)objHolder).getViewHolderType() == viewType) {
        viewHolder = (BaseViewHolder) objHolder;
      } else {
        viewHolder = onCreateViewHolder(viewType, parent);
      }
    }
    if(null != viewHolder) {
      onBindViewHolder(viewType, position, viewHolder);
      convertView = viewHolder.itemView;
      viewHolder.setViewHolderType(viewType);
      convertView.setTag(viewHolder);
    }
    return convertView;
  }

  public abstract BaseViewHolder onCreateViewHolder(int viewType, ViewGroup parent);
  public abstract void onBindViewHolder(int viewType, int position, BaseViewHolder viewHolder);

  public int getItemViewType(int position) {
    return 0;
  }

  public void setListData(List<T> listData) {
    this.listSelectItemPosition.clear();
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

  public void addData(List<T> list) {
    if(list != null && !list.isEmpty()) {
      this.listData.addAll(list);
      notifyDataSetChanged();
    }
  }

  public void addData(int index, List<T> list) {
    if(list != null && !list.isEmpty()) {
      this.listData.addAll(index, list);
      notifyDataSetChanged();
    }
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
   * 是否全部选中
   * @return
   */
  public boolean isSelectAllItem() {
    return getCount() == listSelectItemPosition.size();
  }

  /**
   * 是否选中的为空
   * @return
   */
  public boolean isSelectEmptyItem() {
    return listSelectItemPosition.isEmpty();
  }

  /**
   * 添加选中的Item
   * @param position
   */
  public void addSelectItem(int position) {
    String str = String.valueOf(position);
    if(listSelectItemPosition.contains(str)) {
      //已经选中
    } else {
      if(isSingleSelectItem) {
        listSelectItemPosition.clear();
      }
      listSelectItemPosition.add(str);
      if(onSelectItemChangeListener != null) {
        notifyDataSetChanged();
        onSelectItemChangeListener.onSelectItem(position, true);
      }
    }
  }

  /**
   * 选中所有
   */
  public void addSelectAllItem() {
    listSelectItemPosition.clear();
    for(int i = 0; i < getCount(); i++) {
      String str = String.valueOf(i);
      listSelectItemPosition.add(str);
    }
  }

  /**
   * 删除所有选中项
   */
  public void removeSelectAllItem() {
    listSelectItemPosition.clear();
  }

  /**
   * 删除选中的Item
   * @param position
   */
  public void removeSelectItem(int position) {
    String str = String.valueOf(position);
    if(listSelectItemPosition.contains(str)) {
      listSelectItemPosition.remove(str);
      if(onSelectItemChangeListener != null) {
        notifyDataSetChanged();
        onSelectItemChangeListener.onSelectItem(position, false);
      }
    }
  }

  /**
   * 切换选中Item
   * @param position
   */
  public void toggleSelectItem(int position) {
    if(isSelectItem(position)) {
      removeSelectItem(position);
    } else {
      addSelectItem(position);
    }
  }

  /**
   * 获取选中的Item
   * @return
   */
  public List<T> getSelectItem() {
    List<T> listSelectData = new ArrayList<>();
    int[] positions = getSelectItemPosition();
    if(positions == null) {
      return listSelectData;
    }
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
      return pos;
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

  public void setOnSelectItemChangeListener(OnSelectItemChangeListener onSelectItemChangeListener) {
    this.onSelectItemChangeListener = onSelectItemChangeListener;
  }

  public OnSelectItemChangeListener getOnSelectItemChangeListener() {
    return onSelectItemChangeListener;
  }

  public interface OnSelectItemChangeListener {
    void onSelectItem(int position, boolean isSelect);
  }
}
