package com.alanapi.ui.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alanapi.ui.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.e("Debug", "Person isAssignableFrom Student = " + Person.class.isAssignableFrom(Student.class));
    Log.e("Debug", "Person isAssignableFrom Student = " + Person.class.isAssignableFrom(Person.class));
    Log.e("Debug", "Student isAssignableFrom Person = " + Student.class.isAssignableFrom(Person.class));
  }

  public void top(View v) {
  }
  public void bottom(View v) {
  }
  public void topBottom(View v) {
  }
}
