package com.alanapi.ui.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

/**
 * @version V1.0  2017/3/14下午4:06
 * @author:OliverTan(www.tandunzhao.cn)
 */
public class DrawableUtil {

  /**
   * 获取Drawable
   * @param context
   * @param drawableRes
   * @return
   */
  public static Drawable getDrawable(Context context, @DrawableRes int drawableRes) {
    return getDrawable(context.getResources(), drawableRes);
  }

  /**
   * 获取Drawable
   * @param resources
   * @param drawableRes
   * @return
   */
  public static Drawable getDrawable(Resources resources, @DrawableRes int drawableRes) {
    return resources.getDrawable(drawableRes);
  }

  /**
   * 获取Drawable
   * @param drawable
   * @return Drawable
   */
  public static Drawable getCompoundDrawable(Drawable drawable) {
    if(drawable != null) {
      drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }
    return drawable;
  }


  public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
    if(drawable == null) {
      return null;
    }
    final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
    DrawableCompat.setTintList(wrappedDrawable, colors);
    return wrappedDrawable;
  }

  public static Drawable tintDrawable(Drawable drawable, int color) {
    return tintDrawable(drawable, ColorStateList.valueOf(color));
  }

  public static Drawable tintDrawable(Context context, Drawable drawable, @ColorRes int colorRes) {
    return tintDrawable(drawable, context.getResources().getColorStateList(colorRes));
  }

  public static Drawable getVectorDrawable(Context context, @DrawableRes int drawableRes) {
    VectorDrawableCompat drawableCompat = VectorDrawableCompat.create(context.getResources(), drawableRes, context.getTheme());
    return drawableCompat;
  }

  public static Drawable getVectorDrawable(Context context, @DrawableRes int drawableRes, @ColorRes int colorRes) {
    VectorDrawableCompat drawableCompat = VectorDrawableCompat.create(context.getResources(), drawableRes, context.getTheme());
    return tintDrawable(context, drawableCompat, colorRes);
  }

  public static GradientDrawable setGradientDrawableRadius(GradientDrawable gradientDrawable, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {
    gradientDrawable.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius});
    return gradientDrawable;
  }

  public static GradientDrawable setGradientDrawableRadius(GradientDrawable gradientDrawable, float radius) {
    gradientDrawable.setCornerRadius(radius);
    return gradientDrawable;
  }

  public static GradientDrawable setGradientDrawableStroke(GradientDrawable gradientDrawable, int width, int strokeColor, float dashWidth, float dashGap) {
    gradientDrawable.setStroke(width, strokeColor, dashWidth, dashGap);
    return gradientDrawable;
  }

  public static GradientDrawable setGradientDrawableStroke(GradientDrawable gradientDrawable, int width, int strokeColor) {
    gradientDrawable.setStroke(width, strokeColor);
    return gradientDrawable;
  }

  public static GradientDrawable setGradientDrawableSolid(GradientDrawable gradientDrawable, int solidColor) {
    gradientDrawable.setColor(solidColor);
    return gradientDrawable;
  }

  public static GradientDrawable getRectangleDrawable() {
    GradientDrawable gradientDrawable = getGradientDrawable();
    gradientDrawable.setShape(GradientDrawable.RECTANGLE);
    return gradientDrawable;
  }

  public static GradientDrawable getOvalDrawable() {
    GradientDrawable gradientDrawable = getGradientDrawable();
    gradientDrawable.setShape(GradientDrawable.OVAL);
    return gradientDrawable;
  }

  public static GradientDrawable getGradientDrawable() {
    return new GradientDrawable();
  }
}
