package com.alanapi.ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
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
public abstract class HeadbarAppCompatActivity extends AppCompatActivity {
  protected LinearLayout rootActivityLayout;
  protected LinearLayout rootHeadBarLayout;
  protected TextView tvToolbarTitle;
  protected TextView tvToolbarLeftBack;
  protected TextView tvToolbarLeftOption;
  protected TextView tvToolbarRightOption;
  protected TextView tvToolbarRightOption1;
  protected TextView tvToolbarRightOption2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_headbar);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    rootActivityLayout = getViewById(R.id.ActivityHeadbar_llRootLayout);
    rootHeadBarLayout = getViewById(R.id.ViewHeadbar_rootLayout);
    tvToolbarTitle = getViewById(R.id.ViewHeadbar_tvHeadbarTitle);
    tvToolbarLeftBack = getViewById(R.id.ViewHeadbar_tvHeadbarLeftBack);
    tvToolbarLeftOption = getViewById(R.id.ViewHeadbar_tvHeadbarLeftOption);
    tvToolbarRightOption = getViewById(R.id.ViewHeadbar_tvHeadbarRightOption);
    tvToolbarRightOption1 = getViewById(R.id.ViewHeadbar_tvHeadbarRightOption1);
    tvToolbarRightOption2 = getViewById(R.id.ViewHeadbar_tvHeadbarRightOption2);
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
    tvToolbarRightOption.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onClickToolbarRightOption(view);
      }
    });
    tvToolbarRightOption1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onClickToolbarRightOption1(view);
      }
    });
    tvToolbarRightOption2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onClickToolbarRightOption2(view);
      }
    });
    showToolbarLeftBack();
    setContentView(getContentViewLayoutResID());
    initView();
    initData();
  }

  public void setHeadBarBackgroundResource(int resId) {
    rootHeadBarLayout.setBackgroundResource(resId);
  }

  public void setHeadBarBackgroundColor(int color) {
    rootHeadBarLayout.setBackgroundColor(color);
  }

  public void setHeadBarBackgroundDrawable(Drawable drawable) {
    rootHeadBarLayout.setBackgroundDrawable(drawable);
  }

  public void setActivityBackgroundResource(int resId) {
    rootActivityLayout.setBackgroundResource(resId);
  }

  public void setActivityBackgroundColor(int color) {
    rootActivityLayout.setBackgroundColor(color);
  }

  public void setActivityBackgroundDrawable(Drawable drawable) {
    rootActivityLayout.setBackgroundDrawable(drawable);
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    View.inflate(this, layoutResID, rootActivityLayout);
  }

  @Override
  public void setContentView(View view) {
    this.setContentView(view, view.getLayoutParams());
  }

  @Override
  public void setContentView(View view, ViewGroup.LayoutParams params) {
    rootActivityLayout.addView(view, params);
  }

  @Override
  public void setTitle(CharSequence title) {
    setToolbarTitle(title);
  }

  @Override
  public void setTitle(int titleId) {
    setToolbarTitle(titleId);
  }

  @Override
  public void setTitleColor(int textColor) {
    tvToolbarTitle.setTextColor(textColor);
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

  public void setToolbarRightOption(@NonNull CharSequence title) {
    tvToolbarRightOption.setText(title);
  }

  public void setToolbarRightOption(@StringRes int titleRes) {
    tvToolbarRightOption.setText(titleRes);
  }

  public void setToolbarRightOption1(@NonNull CharSequence title) {
    tvToolbarRightOption1.setText(title);
  }

  public void setToolbarRightOption1(@StringRes int titleRes) {
    tvToolbarRightOption1.setText(titleRes);
  }

  public void setToolbarRightOption2(@NonNull CharSequence title) {
    tvToolbarRightOption2.setText(title);
  }

  public void setToolbarRightOption2(@StringRes int titleRes) {
    tvToolbarRightOption2.setText(titleRes);
  }

  /**
   * 显示左侧返回按钮
   */
  public void showToolbarLeftBack() {
    tvToolbarLeftBack.setVisibility(View.VISIBLE);
  }

  /**
   * 显示左侧返回按钮
   * @param res
   */
  public void showToolbarLeftBack(String res) {
    setToolbarLeftBack(res);
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
  public void showToolbarLeftOption(String res) {
    setToolbarLeftOption(res);
    tvToolbarLeftOption.setVisibility(View.VISIBLE);
  }

  /**
   * 显示左侧更多按钮
   */
  public void hideToolbarLeftOption() {
    tvToolbarLeftOption.setVisibility(View.GONE);
  }

  /**
   * 显示右侧按钮
   */
  public void showToolbarRightOption() {
    tvToolbarRightOption.setVisibility(View.VISIBLE);
  }

  /**
   * 显示右侧按钮
   */
  public void showToolbarRightOption(String res) {
    setToolbarRightOption(res);
    tvToolbarRightOption.setVisibility(View.VISIBLE);
  }

  /**
   * 显示右侧按钮
   */
  public void hideToolbarRightOption() {
    tvToolbarRightOption.setVisibility(View.GONE);
  }

  /**
   * 显示右侧按钮1
   */
  public void showToolbarRightOption1() {
    tvToolbarRightOption1.setVisibility(View.VISIBLE);
  }

  /**
   * 显示右侧按钮1
   */
  public void showToolbarRightOption1(String res) {
    setToolbarRightOption1(res);
    tvToolbarRightOption1.setVisibility(View.VISIBLE);
  }

  /**
   * 显示右侧按钮1
   */
  public void hideToolbarRightOption1() {
    tvToolbarRightOption1.setVisibility(View.GONE);
  }

  /**
   * 显示右侧按钮2
   */
  public void showToolbarRightOption2() {
    tvToolbarRightOption2.setVisibility(View.VISIBLE);
  }

  /**
   * 显示右侧按钮2
   */
  public void showToolbarRightOption2(String res) {
    setToolbarRightOption2(res);
    tvToolbarRightOption2.setVisibility(View.VISIBLE);
  }

  /**
   * 显示右侧按钮2
   */
  public void hideToolbarRightOption2() {
    tvToolbarRightOption2.setVisibility(View.GONE);
  }

  /**
   * 点击左按钮
   *
   * @param view
   */
  protected void onClickToolbarLeftBack(View view) {
    finishActivity();
  }

  /**
   * 点击左按钮(第二个)
   *
   * @param view
   */
  protected void onClickToolbarLeftOption(View view) {
  }

  /**
   * 点击右按钮(第一个)
   *
   * @param view
   */
  protected void onClickToolbarRightOption(View view) {
  }

  /**
   * 点击右按钮(第二个)
   *
   * @param view
   */
  protected void onClickToolbarRightOption1(View view) {
  }

  /**
   * 点击右按钮(第三个)
   *
   * @param view
   */
  protected void onClickToolbarRightOption2(View view) {
  }

  /**
   * 点击标题
   *
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
   *
   * @return
   */
  protected abstract int getContentViewLayoutResID();
}
