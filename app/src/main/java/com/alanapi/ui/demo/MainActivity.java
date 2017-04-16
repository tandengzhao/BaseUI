package com.alanapi.ui.demo;

import android.view.View;
import android.widget.TextView;

import com.alanapi.ui.AppCompatActivity;
import com.alanapi.ui.UIHelper;
import com.alanapi.ui.demo.activity.UIActivity;
import com.alanapi.ui.demo.activity.UIAppCompatActivity;
import com.alanapi.ui.demo.activity.UIFragmentActivity;
import com.alanapi.ui.demo.activity.UIHeadbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.activity1:
        UIHelper.showActivity(this, UIActivity.class);
        break;
      case R.id.activity2:
        UIHelper.showActivity(this, UIAppCompatActivity.class);
        break;
      case R.id.activity3:
        UIHelper.showActivity(this, UIFragmentActivity.class);
        break;
      case R.id.activityHeader:
        UIHelper.showActivity(this, UIHeadbarActivity.class);
        break;



      case R.id.activityList:
        UIHelper.showActivity(this, MainHeadbarListActivity.class);
        break;
      case R.id.activity:
        UIHelper.showActivity(this, ActivityDemo.class);
        break;
      case R.id.activityFull:
        UIHelper.showActivity(this, ActivityDemoFull.class);
        break;
      case R.id.activityFull2:
        UIHelper.showActivity(this, ActivityDemoFull2.class);
        break;
      case R.id.fragmentActivity:
        UIHelper.showActivity(this, FragmentActivityDemo.class);
        break;
      case R.id.appActivity:
        UIHelper.showActivity(this, AppCompatActivityDemo.class);
        break;
      case R.id.drawerActivity:
        UIHelper.showActivity(this, ActivityDrawerLayoutDemo.class);
        break;
      case R.id.slidingPaneActivity:
        UIHelper.showActivity(this, ActivitySlidingPaneLayoutDemo.class);
        break;
    }
  }

  @Override
  protected void initActivityData() {

  }

  @Override
  protected void initActivityView() {
    getViewById(R.id.activity1).setOnClickListener(this);
    getViewById(R.id.activity2).setOnClickListener(this);
    getViewById(R.id.activity3).setOnClickListener(this);
    getViewById(R.id.activityHeader).setOnClickListener(this);

















    getViewById(R.id.activityList).setOnClickListener(this);
    getViewById(R.id.activity).setOnClickListener(this);
    getViewById(R.id.activityFull).setOnClickListener(this);
    getViewById(R.id.activityFull2).setOnClickListener(this);
    getViewById(R.id.fragmentActivity).setOnClickListener(this);
    getViewById(R.id.appActivity).setOnClickListener(this);
    getViewById(R.id.drawerActivity).setOnClickListener(this);
    getViewById(R.id.slidingPaneActivity).setOnClickListener(this);

    getViewById(R.id.imageDrawableChange).setOnClickListener(this);


    //Drawable drawable = DrawableUtil.tintDrawable(this, DrawableUtil.getVectorDrawable(this, R.drawable.ic_keyboard_arrow_left_black_24dp), R.color.tint_colors);
    //getViewById(R.id.imageDrawableChange).setBackgroundDrawable(drawable);

    TextView tv = getViewById(R.id.tvDrawableBack);
    tv.setOnClickListener(this);
    //tv.setText("");
    //Drawable drawable1 = DrawableUtil.tintDrawable(this, DrawableUtil.getVectorDrawable(this, R.drawable.ic_chevron_left_black_24dp), R.color.tint_colors);
    //Drawable drawable1 = DrawableUtil.tintDrawable(this, DrawableUtil.getVectorDrawable(this, R.drawable.ic_left_arrow), R.color.tint_colors);
    //Drawable drawable1 = DrawableUtil.tintDrawable(this, DrawableUtil.getVectorDrawable(this, R.drawable.ui_back), R.color.tint_colors);
    //Drawable drawable1 = DrawableUtil.tintDrawable(this, DrawableUtil.getDrawable(this, R.mipmap.ui_back), R.color.tint_colors);
    //Drawable drawable1 = DrawableUtil.tintDrawable(this, DrawableUtil.getDrawable(this, R.drawable.ic_back1), R.color.tint_colors);
    //ViewUtil.setTextViewCompoundDrawableLeft(tv, drawable1);


    setStatusBarColorResource(R.color.purple);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_main;
  }

  public void onMainToolbar(View v) {
    UIHelper.showActivity(this, MainToolbarActivity.class);
  }
  public void onMainHeadbar(View v) {
    UIHelper.showActivity(this, MainHeadbarActivity.class);
  }
  public void onMainHeadbarAppCompat(View v) {
    UIHelper.showActivity(this, MainHeadbarAppCompatActivity.class);
  }
  public void onLogin(View v) {
    UIHelper.showActivity(this, LoginActivity.class);
  }
}
