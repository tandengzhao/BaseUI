package com.alanapi.ui.demo;

import android.widget.ListView;

import com.alanapi.ui.Activity;

/**
 * @version V1.0  2016/12/8上午9:36
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ActivityDemo extends Activity {
  private ListView listView;
  private ListAdapter listAdapter;

  @Override
  protected void initActivityData() {
    listAdapter = new ListAdapter();
    listView.setAdapter(listAdapter);
  }

  @Override
  protected void initActivityView() {
    setStatusBarColorResource(R.color.blue, 0.2f);

    listView = getViewById(R.id.listView);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_demo;
  }
}
