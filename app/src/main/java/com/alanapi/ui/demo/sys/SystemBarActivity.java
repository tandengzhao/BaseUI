package com.alanapi.ui.demo.sys;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.view.WindowManager;

import com.alanapi.ui.AppCompatActivity;
import com.alanapi.ui.demo.R;

/**
 * @version V1.0  2017/5/22下午1:39
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class SystemBarActivity extends AppCompatActivity {

  @Override
  protected void initActivityData() {
    super.initActivityData();
  }

  @Override
  protected void initActivityView() {
    super.initActivityView();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      getWindow().setStatusBarColor(calculateStatusColor(Color.parseColor("#303030"), 1));
    }
  }

  @Override
  protected int getActivityContentViewLayoutResID() {
    return R.layout.activity_systembar;
  }


  /**
   * 计算状态栏颜色
   * @param color color值
   * @param alpha alpha值
   * @return 最终的状态栏颜色
   */
  private static int calculateStatusColor(@ColorInt int color, int alpha) {
    if (alpha == 0) {
      return color;
    }
    float a = 1 - alpha / 255f;
    int red = color >> 16 & 0xff;
    int green = color >> 8 & 0xff;
    int blue = color & 0xff;
    red = (int) (red * a + 0.5);
    green = (int) (green * a + 0.5);
    blue = (int) (blue * a + 0.5);
    return 0xff << 24 | red << 16 | green << 8 | blue;
  }
}
