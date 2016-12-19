package com.alanapi.ui.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alanapi.ui.BaseAdapter;
import com.alanapi.ui.BaseViewHolder;

/**
 * @version V1.0  16/8/10下午2:07
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ListAdapter extends BaseAdapter<Person> {
  @Override
  public ViewHolder onCreateViewHolder(int viewType, ViewGroup parent) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_person, parent, false));
  }

  @Override
  public void onBindViewHolder(int viewType, int position, BaseViewHolder h) {
    ViewHolder viewHolder = (ViewHolder) h;
    viewHolder.tvName.setText("名称     \t " + position);
  }

  @Override
  public int getCount() {
    return 20;
  }

  public class ViewHolder extends BaseViewHolder {
    TextView tvName;

    public ViewHolder(View itemView) {
      super(itemView);

      tvName = getViewById(R.id.ListViewPerson_tvName);
    }
  }
}
