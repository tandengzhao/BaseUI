package com.alanapi.ui.demo;

import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

import com.alanapi.ui.AppCompatActivity;
import com.alanapi.ui.util.StatusBarUtil;

/**
 * @version V1.0  2016/12/8下午2:02
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class ActivitySlidingPaneLayoutDemo extends AppCompatActivity {
  private SlidingPaneLayout slidingPaneLayout;
  private View leftView;
  private View contentView;

  @Override
  protected void initActivityData() {
  }

  @Override
  protected void initActivityView() {
    slidingPaneLayout = getViewById(R.id.slidingPaneLayout);
    leftView = getViewById(R.id.leftPane);
    contentView = getViewById(R.id.contentFrame);

    //StatusBarUtil.setSlidingPaneLayoutColor(this, slidingPaneLayout, getResources().getColor(R.color.gray));
    StatusBarUtil.setSlidingPaneLayoutColor(this, slidingPaneLayout, getResources().getColor(R.color.gray), 0.5f);
    //StatusBarUtil.setSlidingPaneLayoutTranslucent(this, slidingPaneLayout);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_sliding_pane_layout_demo;
  }
}
