package com.alanapi.ui;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alanapi.ui.util.DrawableUtil;
import com.alanapi.ui.util.ViewUtil;

/**
 * @version V1.0  16/9/13上午10:50
 * @author:OliverTan(www.tandunzhao.cn)
 */
public abstract class HeadbarActivity extends Activity {
  protected LinearLayout rootActivityLayout;
  protected LinearLayout toolbar;
  protected TextView tvToolbarTitle;
  protected TextView tvToolbarLeftBack;
  protected TextView tvToolbarLeftOption;
  protected TextView tvToolbarRightOption;
  protected TextView tvToolbarRightOption1;
  protected TextView tvToolbarRightOption2;
  protected FrameLayout containerLayout;

  protected LinearLayout llToolbarCenterLayout;

  @Override
  protected void initActivityData() {
  }

  @Override
  protected void initActivityView() {
    rootActivityLayout = getViewById(R.id.ActivityHeadbar_llRootLayout);
    toolbar = getViewById(R.id.ViewHeadbar_rootLayout);

    if(!getWindowTranslucentStatus()) {
      rootActivityLayout.setFitsSystemWindows(false);
      toolbar.setFitsSystemWindows(false);
    }

    llToolbarCenterLayout = getViewById(R.id.ViewHeadbar_llCenterLayout);
    tvToolbarTitle = getViewById(R.id.ViewHeadbar_tvHeadbarTitle);
    tvToolbarLeftBack = getViewById(R.id.ViewHeadbar_tvHeadbarLeftBack);
    tvToolbarLeftOption = getViewById(R.id.ViewHeadbar_tvHeadbarLeftOption);
    tvToolbarRightOption = getViewById(R.id.ViewHeadbar_tvHeadbarRightOption);
    tvToolbarRightOption1 = getViewById(R.id.ViewHeadbar_tvHeadbarRightOption1);
    tvToolbarRightOption2 = getViewById(R.id.ViewHeadbar_tvHeadbarRightOption2);
    containerLayout = getViewById(R.id.ActivityHeadbar_flContainerLayout);

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

    int layoutId = getContentViewLayoutResID();
    if(layoutId > 0) {
      setContentView(layoutId);
    }
  }

  /**
   * 替换toolbar
   * @param view
   */
  public void replaceToolbar(View view) {
    if(toolbar != null) {
      toolbar.removeAllViews();
      toolbar.addView(view);
    }
  }

  public void replaceToolbarCenterLayout(View view) {
    if(llToolbarCenterLayout != null) {
      llToolbarCenterLayout.removeAllViews();
      llToolbarCenterLayout.addView(view);
    }
  }

  protected void addViewContainerLayout(View view) {
    containerLayout.addView(view);
  }

  protected void addViewContainerLayout(View view, int gravity) {
    addViewContainerLayout(view);
    FrameLayout.LayoutParams fll = (FrameLayout.LayoutParams) view.getLayoutParams();
    fll.gravity = gravity;
    view.setLayoutParams(fll);
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.ui_activity_headbar;
  }

  public void setToolBarBackgroundTransparent() {
    toolbar.setBackgroundColor(Color.TRANSPARENT);
  }

  public void setToolBarBackgroundResource(int resId) {
    toolbar.setBackgroundResource(resId);
  }

  public void setToolBarBackgroundColor(@ColorInt int color) {
    toolbar.setBackgroundColor(color);
  }

  public void setToolBarBackgroundDrawable(Drawable drawable) {
    toolbar.setBackgroundDrawable(drawable);
  }

  public void setActivityBackgroundResource(int resId) {
    rootActivityLayout.setBackgroundResource(resId);
  }

  public void setActivityBackgroundColor(@ColorInt int color) {
    rootActivityLayout.setBackgroundColor(color);
  }

  public void setActivityBackgroundDrawable(Drawable drawable) {
    rootActivityLayout.setBackgroundDrawable(drawable);
  }

  public void setContainerLayoutBackgroundResource(int resId) {
    containerLayout.setBackgroundResource(resId);
  }

  public void setContainerLayoutBackgroundColor(@ColorInt int color) {
    containerLayout.setBackgroundColor(color);
  }

  public void setContainerLayoutBackgroundDrawable(Drawable drawable) {
    containerLayout.setBackgroundDrawable(drawable);
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    View.inflate(this, layoutResID, containerLayout);
    initView();
    initData();
  }

  @Override
  public void setContentView(View view) {
    this.setContentView(view, view.getLayoutParams());
  }

  @Override
  public void setContentView(View view, ViewGroup.LayoutParams params) {
    containerLayout.addView(view, params);
    initView();
    initData();
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

  public void setTitleColorResource(@ColorRes int resColor) {
    setTitleColor(getResources().getColor(resColor));
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

  public void setToolbarLeftBackDrawableLeftResource(@DrawableRes int resId) {
    ViewUtil.setTextViewCompoundDrawableLeft(tvToolbarLeftBack, resId);
  }

  public void setToolbarLeftBackDrawableLeft(Drawable drawable) {
    ViewUtil.setTextViewCompoundDrawableLeft(tvToolbarLeftBack, drawable);
  }

  public void setToolbarLeftBackDrawableColor(@ColorRes int resColor) {
    try {
      ViewUtil.setTextViewCompoundDrawableLeft(tvToolbarLeftBack, DrawableUtil.tintDrawable(this, DrawableUtil.getVectorDrawable(this, R.drawable.ui_back), resColor));
    } catch (Exception e) {
      try {
        ViewUtil.setTextViewCompoundDrawableLeft(tvToolbarLeftBack, DrawableUtil.tintDrawable(this, getResources().getDrawable(R.drawable.ui_back_other), resColor));
      } catch (Exception ee) {
      }
    }
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
   * 点击右按钮(第一个)
   * @param view
   */
  protected void onClickToolbarRightOption(View view) {
  }

  /**
   * 点击右按钮(第二个)
   * @param view
   */
  protected void onClickToolbarRightOption1(View view) {
  }

  /**
   * 点击右按钮(第三个)
   * @param view
   */
  protected void onClickToolbarRightOption2(View view) {
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
  @Override
  protected void initData() {
  }

  /**
   * 初始化View控件
   */
  @Override
  protected void initView() {
  }

  /**
   * 获取ContentViewLayoutResID
   * @return
   */
  protected int getContentViewLayoutResID() {
    return getActivityLayoutResID();
  }

  /**
   * 获取ContentViewLayoutResID
   * @return
   */
  protected int getActivityLayoutResID() {
    return -1;
  }
}
