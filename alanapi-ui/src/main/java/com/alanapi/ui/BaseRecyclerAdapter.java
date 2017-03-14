package com.alanapi.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0  2016/12/19下午6:16
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
  protected List<T> listData = new ArrayList<>();
  private List<String> listSelectItemPosition = new ArrayList<>();
  private boolean isSingleSelectItem = false;//单选
  private OnItemClickListener onItemClickListener;
  private OnItemLongClickListener onItemLongClickListener;
  private OnSelectItemChangeListener onSelectItemChangeListener;

  protected Context context;

  public BaseRecyclerAdapter() {
  }

  public BaseRecyclerAdapter(Context context) {
    this.context = context;
  }

  @Override
  public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    if(this.context == null) {
      this.context = parent.getContext();
    }
    return onCreateViewHolder(viewType, parent);
  }

  @Override
  public void onBindViewHolder(BaseViewHolder holder, final int position) {
    onBindViewHolder(getItemViewType(position), position, holder);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(onItemClickListener != null) {
          onItemClickListener.onItemClick(v, position);
        }
      }
    });
    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View v) {
        if(onItemLongClickListener != null) {
          return onItemLongClickListener.onItemLongClick(v, position);
        }
        return false;
      }
    });
  }

  public T getItem(int position) {
    return listData.get(position);
  }

  @Override
  public int getItemCount() {
    return listData.size();
  }

  @Override
  public int getItemViewType(int position) {
    return 0;
  }

  public abstract BaseViewHolder onCreateViewHolder(int viewType, ViewGroup parent);
  public abstract void onBindViewHolder(int viewType, int position, BaseViewHolder viewHolder);

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
   * 是否全部选中
   * @return
   */
  public boolean isSelectAllItem() {
    return getItemCount() == listSelectItemPosition.size();
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
    if(isSingleSelectItem) {
      listSelectItemPosition.clear();
    }
    if(!listSelectItemPosition.contains(str)) {
      listSelectItemPosition.add(str);
    }
    if(onSelectItemChangeListener != null) {
      onSelectItemChangeListener.onSelectItem(position, true);
    }
  }

  /**
   * 选中所有
   */
  public void addSelectAllItem() {
    for(int i = 0; i < getItemCount(); i++) {
      addSelectItem(i);
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
    }
    if(onSelectItemChangeListener != null) {
      onSelectItemChangeListener.onSelectItem(position, false);
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
    if(position > -1 && position < getItemCount()) {
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


  public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  public OnItemClickListener getOnItemClickListener() {
    return onItemClickListener;
  }

  public interface OnItemClickListener {
    void onItemClick(View view, int position);
  }

  public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
    this.onItemLongClickListener = onItemLongClickListener;
  }

  public OnItemLongClickListener getOnItemLongClickListener() {
    return onItemLongClickListener;
  }

  public interface OnItemLongClickListener {
    boolean onItemLongClick(View view, int position);
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
