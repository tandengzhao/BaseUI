#BaseUI

#编译环境
1. compileSdkVersion 27
2. buildToolsVersion '27.0.3'
3. minSdkVersion 14
4. targetSdkVersion 27
5. gradle:3.0.1

#依赖库
1. compile 'com.android.support:support-v4:27.1.0'
2. compile 'com.android.support:appcompat-v7:27.1.0'
3. compile 'com.android.support:design:27.1.0'



#使用
compile 'com.alanapi.ui:alanapi-ui:1.1.5'



1，继承
2，实现
    getActivityLayoutResID() 方法获取Content View
    initView()   初始化View
    initData()   初始化数据


#Proguard
-dontwarn android.support.v4.**
-dontwarn android.support.v7.**
-dontwarn android.os.**

-keepattributes *Annotation*

-keep class android.support.v4.** { *; }
-keep class android.support.v7.** { *; }

-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.support.v4.app.FragmentActivity
-keep public class * extends android.support.v7.app.AppCompatActivity

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.support.v4.widget