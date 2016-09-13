package com.alanapi.ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alanapi.ui.util.ViewUtil;

/**
 * @version V1.0  16/9/13上午9:20
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class ToolbarAppCompatActivity extends AppCompatActivity {
  protected LinearLayout rootLayout;
  protected Toolbar toolbar;
  protected TextView tvToolbarTitle;
  protected TextView tvToolbarLeftBack;
  protected TextView tvToolbarLeftOption;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_toolbar_app_compat);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    rootLayout = getViewById(R.id.ActivityToolbarAppCompat_llRootLayout);
    toolbar = getViewById(R.id.ViewToolbar_toolBar);
    tvToolbarTitle = getViewById(R.id.ViewToolbar_tvToolbarTitle);
    tvToolbarLeftBack = getViewById(R.id.ViewToolbar_tvToolbarLeftBack);
    tvToolbarLeftOption = getViewById(R.id.ViewToolbar_tvToolbarLeftOption);

    tvToolbarTitle.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onClickToolbarTitle(view);
      }
    });

    tvToolbarLeftBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onClickToolbarLeftBack(view);
      }
    });

    tvToolbarLeftOption.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onClickToolbarLeftOption(view);
      }
    });

    if(toolbar != null) {
      toolbar.setTitle("");
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayShowTitleEnabled(false);
      getSupportActionBar().setDisplayHomeAsUpEnabled(false);
      getSupportActionBar().setDisplayShowHomeEnabled(false);
      showToolbarLeftBack();
    }

    setContentView(getContentViewLayoutResID());

    initView();
    initData();
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    View.inflate(this, layoutResID, rootLayout);
  }

  @Override
  public void setContentView(View view) {
    this.setContentView(view, view.getLayoutParams());
  }

  @Override
  public void setContentView(View view, ViewGroup.LayoutParams params) {
    rootLayout.addView(view, params);
  }

  public void setToolbarTitle(@NonNull CharSequence title) {
    tvToolbarTitle.setText(title);
  }

  public void setToolbarTitle(@StringRes int titleRes) {
    tvToolbarTitle.setText(titleRes);
  }

  public void setToolbarTitleDrawableLeft(Drawable drawable) {
    ViewUtil.setTextViewCompoundDrawableLeft(tvToolbarTitle, drawable);
  }

  public void setToolbarTitleDrawableRight(Drawable drawable) {
    ViewUtil.setTextViewCompoundDrawableRight(tvToolbarTitle, drawable);
  }

  public void setToolbarLeftBack(@NonNull CharSequence title) {
    tvToolbarLeftBack.setText(title);
  }

  public void setToolbarLeftBack(@StringRes int titleRes) {
    tvToolbarLeftBack.setText(titleRes);
  }

  public void setToolbarLeftBackDrawableLeft(Drawable drawable) {
    ViewUtil.setTextViewCompoundDrawableLeft(tvToolbarLeftBack, drawable);
  }

  public void setToolbarLeftOption(@NonNull CharSequence title) {
    tvToolbarLeftOption.setText(title);
  }

  public void setToolbarLeftOption(@StringRes int titleRes) {
    tvToolbarLeftOption.setText(titleRes);
  }

  /**
   * 显示左侧返回按钮
   */
  public void showToolbarLeftBack() {
    tvToolbarLeftBack.setVisibility(View.VISIBLE);
  }

  /**
   * 显示左侧返回按钮
   */
  public void hideToolbarLeftBack() {
    tvToolbarLeftBack.setVisibility(View.GONE);
  }

  /**
   * 显示左侧更多按钮
   */
  public void showToolbarLeftOption() {
    tvToolbarLeftOption.setVisibility(View.VISIBLE);
  }

  /**
   * 显示左侧更多按钮
   */
  public void hideToolbarLeftOption() {
    tvToolbarLeftOption.setVisibility(View.GONE);
  }

  /**
   * 点击左按钮
   * @param view
   */
  protected void onClickToolbarLeftBack(View view) {
    finishActivity();
  }

  /**
   * 点击左按钮(第二个)
   * @param view
   */
  protected void onClickToolbarLeftOption(View view) {
  }

  /**
   * 点击标题
   * @param view
   */
  protected void onClickToolbarTitle(View view) {
  }

  /**
   * 初始化数据
   */
  protected abstract void initData();

  /**
   * 初始化View控件
   */
  protected abstract void initView();

  /**
   * 获取ContentViewLayoutResID
   * @return
   */
  protected abstract int getContentViewLayoutResID();
}
