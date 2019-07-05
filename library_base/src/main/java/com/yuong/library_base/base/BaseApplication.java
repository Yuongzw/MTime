package com.yuong.library_base.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.yuong.library_base.ActivityManager;
import com.yuong.library_base.R;
import com.yuong.library_base.di.component.ApplicationComponent;
import com.yuong.library_base.di.component.DaggerApplicationComponent;
import com.yuong.library_base.di.module.ApplicationModule;

import java.util.ArrayList;
import java.util.List;

public class BaseApplication extends Application {
    private static Context context;
    private ApplicationComponent mApplicationComponent;
    private static BaseApplication mInstance;
    private static ActivityManager activityManager;

    private int refCount = 0;
    private boolean isBackground;


    @Override
    public void onCreate() {
        super.onCreate();
        // enable cookies
        context = getApplicationContext();
        initApplicationComponent();
        mInstance = this;
        initArouter();
        activityManager = ActivityManager.getInstance();
        Utils.init(mInstance);
        //配置ToastUtils的相关的属性
        ToastUtils.setGravity(Gravity.CENTER, 0, (int) (80 * Utils.getApp().getResources().getDisplayMetrics().density + 0.5));
        ToastUtils.setBgColor(getResources().getColor(R.color.white));
        ToastUtils.setMsgColor(getResources().getColor(R.color.black));
        registerActivityLifecycleCallbacks();

    }

    private void registerActivityLifecycleCallbacks() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                refCount++;
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                refCount--;
                isBackground = refCount == 0;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }


    private void initArouter() {
        if (isDebug(mInstance)) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mInstance); // 尽可能早，推荐在Application中初始化
    }


    /**
     * 初始化ApplicationComponent
     */
    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public boolean isDebug(Context context) {
        boolean isDebug = context.getApplicationInfo() != null &&
                (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        return isDebug;
    }

    public boolean isBackground() {
        return isBackground;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }

    public static Context getContext() {
        return context;
    }

    //检查是否存在此包名的应用程序
    public static boolean isAppInstalled(String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfo = packageManager.getInstalledPackages(0);
        List<String> pName = new ArrayList<String>();
        if (packageInfo != null) {
            for (int i = 0; i < packageInfo.size(); i++) {
                String pn = packageInfo.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);
    }

    public static ActivityManager getActivityManager() {
        return activityManager;
    }

}

