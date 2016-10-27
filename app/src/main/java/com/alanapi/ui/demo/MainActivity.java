package com.alanapi.ui.demo;

import android.os.Bundle;
import android.view.View;

import com.alanapi.ui.AppCompatActivity;
import com.alanapi.ui.UIHelper;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
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
