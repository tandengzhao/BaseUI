package com.alanapi.ui.demo;

import android.view.View;
import android.widget.ListView;

import com.alanapi.ui.HeadbarActivity;

public class MainHeadbarListActivity extends HeadbarActivity {

  private ListView listView;
  private ListAdapter listAdapter;

  @Override
  protected void initData() {
    listAdapter = new ListAdapter();
    listView.setAdapter(listAdapter);
  }

  @Override
  protected void initView() {
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//      getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//    }
    //LightStatusBarUtils.setLightStatusBar(this, true);

//    setStatusBarColorResource(R.color.blue, 0.1f);

    setToolbarTitle("Headbar列表");
    setToolbarLeftBack("返回");
    setToolbarLeftOption("关闭");
    showToolbarLeftOption();

    setToolbarRightOption("右侧0");
    showToolbarRightOption();

//    Button button = new Button(getContext());
//    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
//    button.setLayoutParams(lp);
//    button.setText("登录按钮");
//    addViewContainerLayout(button);

//    Button button1 = new Button(getContext());
//    button1.setLayoutParams(lp);
//    button1.setText("登录按钮底部");
//    addViewContainerLayout(button1, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);

    listView = getViewById(R.id.listView);
  }

  @Override
  protected int getContentViewLayoutResID() {
    return R.layout.activity_main_headbar_list;
  }

  @Override
  protected void onClickToolbarLeftBack(View view) {
    showToastMessage("返回");
    super.onClickToolbarLeftBack(view);
  }

  @Override
  protected void onClickToolbarLeftOption(View view) {
    showToastMessage("关闭");
  }

  @Override
  protected void onClickToolbarRightOption(View view) {
    super.onClickToolbarRightOption(view);
    showToastMessage("右侧0");
  }
  @Override
  protected void onClickToolbarRightOption1(View view) {
    super.onClickToolbarRightOption(view);
    showToastMessage("右侧1");
  }
  @Override
  protected void onClickToolbarRightOption2(View view) {
    super.onClickToolbarRightOption(view);
    showToastMessage("右侧2");
  }
}
