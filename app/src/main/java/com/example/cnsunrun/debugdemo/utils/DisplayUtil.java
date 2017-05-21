/**
 * Project Name: juju_android
 * Package Name: la.juju.android.util
 * File Name: DisplayUtil.java
 * Created Time: 2014-10-6 下午2:28:12
 * Copyright (c) 2014, imRock.juju.la All Rights Reserved.
 */
package com.example.cnsunrun.debugdemo.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Field;

import static android.util.Log.w;

/**
 * Utils for getting display metrics such as screen size, dp, sp and px...
 * depend on different user device.
 * <p>This class is thread safe.<p/>
 *
 * @author imRock, *rockyoungljy@gmail.com*
 * @version DisplayUtil, v 0.1
 */
public class DisplayUtil {

    private static final String DEBUG_TAG = DisplayUtil.class.getSimpleName();

    private static Context appContext;

    private static int screenWidth;
    private static int screenHeight;

    private static int statusBarHeight;

    private DisplayUtil() {
    }

    /**
     * If want to use the more convenient method like {@link #getScreenWidth()},
     * {@link #getScreenHeight()} and {@link #getStatusBarHeight()}, should call this
     * with application context before. it's good to initialize in the application's
     * onCreate call back.
     *
     * @param appContext must be application context for best practise
     */
    public synchronized static void init(Context appContext) {
        DisplayUtil.appContext = appContext;
        int[] size = getScreenSize(appContext);
        screenWidth = size[0];
        screenHeight = size[1];
        statusBarHeight = getStatusBarHeight(appContext);
    }

    /**
     * This method is guaranteed to get the proper screen width and height.
     *
     * @param context any activity or application context
     * @return the size with width and height pixels of screen
     */
    public synchronized static int[] getScreenSize(Context context) {
        final String name = Context.WINDOW_SERVICE;
        final Object service = context.getSystemService(name);
        final WindowManager wm = (WindowManager) service;
        final Display display = wm.getDefaultDisplay();
        final DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        int[] size = new int[2];
        size[0] = screenWidth;
        size[1] = screenHeight;
//        Log.d("screenWidth of size[0]", String.valueOf(size[0]));
//        Log.d("screenHeight of size[1]", String.valueOf(size[1]));
        return size;
    }

    private static final String DIMEN_CLASS_NAME = "com.android.internal.R$dimen";
    private static final String SB_HEIGHT_FIELD_NAME = "status_bar_height";

    /**
     * Get the proper system status bar's height using reflection.
     *
     * @param context any activity or application context
     * @return the height in pixel of system status bar
     */
    public synchronized static int getStatusBarHeight(Context context) {
        try {
            final Class<?> theClass = Class.forName(DIMEN_CLASS_NAME);
            final Object classObj = theClass.newInstance();
            final Field field = theClass.getField(SB_HEIGHT_FIELD_NAME);
            final Object idObj = field.get(classObj);
            final String idStr = idObj.toString();
            final int id = Integer.parseInt(idStr);
            final Resources resources = context.getResources();
            statusBarHeight = resources.getDimensionPixelSize(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Log.d("statusBarHeight", String.valueOf(statusBarHeight));
        return statusBarHeight;
    }

    /**
     * Get the user device's screen width, the correctness is not guaranteed,
     * because it's depend on the calling sequence.
     * WARNING: Should calling {@link #init(Context)} or {@link #getScreenSize(Context)} before,
     * or you may get 0 as result.
     *
     * @return the pixel width of screen, return 0 if the call order is wrong
     */
    public synchronized static int getScreenWidth() {
        if (screenWidth == 0 && appContext != null) {
            int[] size = getScreenSize(appContext);
            screenWidth = size[0];
            screenHeight = size[1];
        }
        return screenWidth;
    }

    /**
     * Get the user device's screen height, the correctness is not guaranteed,
     * because it's depend on the calling sequence.
     * WARNING: Should calling {@link #init(Context)} or {@link #getScreenSize(Context)} before,
     * or you may get 0 as result.
     *
     * @return the pixel height of screen, return 0 if the call order is wrong
     */
    public synchronized static int getScreenHeight() {
        if (screenHeight == 0 && appContext != null) {
            int[] size = getScreenSize(appContext);
            screenWidth = size[0];
            screenHeight = size[1];
        }
        return screenHeight;
    }

    public synchronized static float getScreenRate() {
        if ((screenWidth == 0 || screenHeight == 0) && appContext != null) {
            int[] size = getScreenSize(appContext);
            screenWidth = size[0];
            screenHeight = size[1];
        }
        return (float) screenHeight / (float) screenWidth;
    }

    /**
     * Get the system status bar's height, the correctness is not guaranteed,
     * because it's depend on the calling sequence.
     * WARNING: Should calling {@link #init(Context)} or {@link #getStatusBarHeight(Context)} before,
     * or you may get 0 as result.
     *
     * @return the pixel height of system status bar, return 0 if the call order is wrong
     */
    public synchronized static int getStatusBarHeight() {
        if (statusBarHeight == 0 && appContext != null) {
            statusBarHeight = getStatusBarHeight(appContext);
        }
        return statusBarHeight;
    }


    private static final String WARNING_MSG0 = "Should call init(Context appContext) before this!";
    private static final String WARNING_MSG1 = "The result from this method is WRONG basically!";

    /**
     * Another way to convert dp(density-independent pixels) unit to equivalent px(pixels),
     * depending on device {@link DisplayMetrics}, using {@link TypedValue}.
     * This method is more recommended compared to {@link #convertDpToPx(float, Context)}.
     *
     * @param dp      value in dp unit which will be converted into px
     * @param context context to get resources and device specific display metrics
     * @return a float value to represent px equivalent to dp
     */
    public synchronized static float dpToPx(float dp, Context context) {
        final Resources resources = context.getResources();
        final DisplayMetrics metrics = resources.getDisplayMetrics();
        final int unit = TypedValue.COMPLEX_UNIT_DIP;
        return TypedValue.applyDimension(unit, dp, metrics);
    }

    /**
     * Calling this instead of {@link #dpToPx(float, Context)} for convenience, ONLY
     * IF you have {@link #init(Context)} with the application context before.
     * WARNING: Will return the original value passed in by @param dp when calling
     * sequence is wrong!
     *
     * @param dp value in dp unit which will be converted into px
     * @return a float value to represent px equivalent to dp
     */
    public synchronized static float dpToPx(float dp) {
        if (appContext != null) {
            return dpToPx(dp, appContext);
        } else {
            w(DEBUG_TAG + ".dpToPx()", WARNING_MSG0);
            w(DEBUG_TAG + ".dpToPx()", WARNING_MSG1);
            return dp;
        }
    }

    /**
     * Convert dp(density-independent pixels) unit to equivalent px(pixels), depending on
     * device densityDpi of {@link DisplayMetrics}.
     *
     * @param dp      value in dp unit which will be converted into px
     * @param context context to get resources and device specific display metrics
     * @return a float value to represent px equivalent to dp
     */
    public synchronized static float convertDpToPx(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        final int densityDpi = metrics.densityDpi;
        return dp * (densityDpi / 160f);
    }

    /**
     * Calling this instead of {@link #convertDpToPx(float, Context)} for convenience,
     * ONLY IF you have {@link #init(Context)} with the application context before.
     * WARNING: Will return the original value passed in by @param dp when calling
     * sequence is wrong!
     *
     * @param dp value in dp unit which will be converted into px
     * @return a float value to represent px equivalent to dp
     */
    public synchronized static float convertDpToPx(float dp) {
        if (appContext != null) {
            return convertDpToPx(dp, appContext);
        } else {
            w(DEBUG_TAG + ".convertDpToPixel()", WARNING_MSG0);
            w(DEBUG_TAG + ".convertDpToPixel()", WARNING_MSG1);
            return dp;
        }
    }

    /**
     * Convert px(pixels) unit to equivalent dp(density-independent pixels), depending on
     * device densityDpi of {@link DisplayMetrics}.
     *
     * @param px      value in px unit which will be converted into dp
     * @param context context to get resources and device specific display metrics
     * @return a float value to represent dp equivalent to px
     */
    public synchronized static float convertPxToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        final int densityDpi = metrics.densityDpi;
        return px / (densityDpi / 160f);
    }

    /**
     * Calling this instead of {@link #convertPxToDp(float, Context)} for convenience,
     * ONLY IF you have {@link #init(Context)} with the application context before.
     * WARNING: Will return the original value passed in by @param px when calling
     * sequence is wrong!
     *
     * @param px value in px unit which will be converted into dp
     * @return a float value to represent dp equivalent to px
     */
    public synchronized static float convertPxToDp(float px) {
        if (appContext != null) {
            return convertPxToDp(px, appContext);
        } else {
            w(DEBUG_TAG + ".convertPixelsToDp()", WARNING_MSG0);
            w(DEBUG_TAG + ".convertPixelsToDp()", WARNING_MSG1);
            return px;
        }
    }

    /**
     * Convert sp(scale-independent pixels) unit to equivalent px(pixels), depending on
     * device scaledDensity of {@link DisplayMetrics}.
     *
     * @param sp      value in sp unit which will be converted into px
     * @param context context to get resources and device specific display metrics
     * @return a float value to represent px equivalent to sp
     */
    public synchronized static float convertSpToPx(float sp, Context context) {
        final Resources resources = context.getResources();
        final DisplayMetrics metrics = resources.getDisplayMetrics();
        final float fontScale = metrics.scaledDensity;
        return sp * fontScale;
    }

    /**
     * Calling this instead of {@link #convertSpToPx(float, Context)} for convenience,
     * ONLY IF you have {@link #init(Context)} with the application context before.
     * WARNING: Will return the original value passed in by @param px when calling
     * sequence is wrong!
     *
     * @param sp value in sp unit which will be converted into px
     * @return a float value to represent px equivalent to sp
     */
    public synchronized static float convertSpToPx(float sp) {
        if (appContext != null) {
            return convertSpToPx(sp, appContext);
        } else {
            w(DEBUG_TAG + ".spToPx()", WARNING_MSG0);
            w(DEBUG_TAG + ".spToPx()", WARNING_MSG1);
            return sp;
        }
    }

    /**
     * Convert px(pixels) unit to equivalent sp(scale-independent pixels), depending on
     * device scaledDensity of {@link DisplayMetrics}.
     *
     * @param px      value in px unit which will be converted into sp
     * @param context context to get resources and device specific display metrics
     * @return a float value to represent sp equivalent to px
     */
    public synchronized static float convertPxToSp(float px, Context context) {
        final Resources resources = context.getResources();
        final DisplayMetrics metrics = resources.getDisplayMetrics();
        final float fontScale = metrics.scaledDensity;
        return px / fontScale;
    }

    /**
     * Calling this instead of {@link #convertPxToSp(float, Context)} for convenience,
     * ONLY IF you have {@link #init(Context)} with the application context before.
     * WARNING: Will return the original value passed in by @param px when calling
     * sequence is wrong!
     *
     * @param px value in px unit which will be converted into sp
     * @return a float value to represent sp equivalent to px
     */
    public synchronized static float convertPxToSp(float px) {
        if (appContext != null) {
            return convertPxToSp(px, appContext);
        } else {
            w(DEBUG_TAG + ".pxToSp()", WARNING_MSG0);
            w(DEBUG_TAG + ".pxToSp()", WARNING_MSG1);
            return px;
        }
    }

}
