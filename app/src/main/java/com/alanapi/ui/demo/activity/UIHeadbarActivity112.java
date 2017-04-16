package com.alanapi.ui.demo.activity;

import android.widget.EditText;
import android.widget.LinearLayout;

import com.alanapi.ui.HeadbarActivity;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/4/16下午6:24
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class UIHeadbarActivity112 extends HeadbarActivity {
  @Override
  protected void initData() {
    super.initData();
  }

  @Override
  protected void initView() {
    super.initView();
    setTitle("普通HeadbarActivity");

    //showToolbarRightOption("右侧1");

    showToolbarLeftOption("关闭");

    EditText etSearch = new EditText(getContext());
    LinearLayout.LayoutParams vl = new LinearLayout.LayoutParams(600, LinearLayout.LayoutParams.WRAP_CONTENT);
    etSearch.setLayoutParams(vl);

    replaceToolbarCenterLayout(etSearch);
  }

  @Override
  protected int getContentViewLayoutResID() {
    return R.layout.activity_ui_header_112;
  }
}
