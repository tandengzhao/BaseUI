package com.alanapi.ui.demo;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.alanapi.ui.AppCompatActivity;

/**
 * @version V1.0  16/10/12下午2:48
 * @author:OliverTan(www.tandunzhao.cn)
 */

public class LoginActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    setContentView(R.layout.activity_login);
  }
}
