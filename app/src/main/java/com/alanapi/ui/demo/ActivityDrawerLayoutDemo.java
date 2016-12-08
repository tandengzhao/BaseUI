package com.alanapi.ui.demo;

import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.alanapi.ui.AppCompatActivity;
import com.alanapi.ui.util.StatusBarUtil;

/**
 * @version V1.0  2016/12/8上午11:51
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ActivityDrawerLayoutDemo extends AppCompatActivity {
  private DrawerLayout drawerLayout;
  private View leftView;
  private View contentView;


  @Override
  protected void initActivityData() {
  }

  @Override
  protected void initActivityView() {
    drawerLayout = getViewById(R.id.drawer_layout);
    contentView = getViewById(R.id.content_frame);
    leftView = getViewById(R.id.left_drawer);

    StatusBarUtil.setDrawerLayoutColor(this, drawerLayout, getResources().getColor(R.color.gray));
    //StatusBarUtil.setDrawerLayoutColor(this, drawerLayout, getResources().getColor(R.color.gray), 0.5f);
    StatusBarUtil.setDrawerLayoutTranslucent(this, drawerLayout);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_drawer_layout_demo;
  }
}
