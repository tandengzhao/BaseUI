package com.alanapi.ui;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
  public ApplicationTest() {
    super(Application.class);
  }


  public void testActivity() {
    Log.e("Debug", "Activity.isAssignableFrom(Activity)" + (android.app.Activity.class.isAssignableFrom(Activity.class)));
    Log.e("Debug", "Activity.isAssignableFrom(FragmentActivity)" + (android.app.Activity.class.isAssignableFrom(FragmentActivity.class)));
    Log.e("Debug", "Activity.isAssignableFrom(AppCompatActivity)" + (android.app.Activity.class.isAssignableFrom(AppCompatActivity.class)));

    Log.e("Debug", "Activity.isAssignableFrom(Fragment)" + (android.app.Activity.class.isAssignableFrom(Fragment.class)));
    Log.e("Debug", "Activity.isAssignableFrom(UIHelper)" + (android.app.Activity.class.isAssignableFrom(UIHelper.class)));
    Log.e("Debug", "Activity.isAssignableFrom(ActivityManager)" + (android.app.Activity.class.isAssignableFrom(ActivityManager.class)));
    Log.e("Debug", "Activity.isAssignableFrom(ActivityPresenter)" + (android.app.Activity.class.isAssignableFrom(ActivityPresenter.class)));
  }
}