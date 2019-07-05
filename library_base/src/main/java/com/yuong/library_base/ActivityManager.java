package com.yuong.library_base;


import com.yuong.library_base.base.BaseActivity;

import java.util.Stack;

public class ActivityManager {
    private static Stack<BaseActivity> activityStack;
    private static ActivityManager instance;

    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    //退出栈顶Activity
    public void popActivity(BaseActivity activity) {
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    //获得当前栈顶Activity
    public BaseActivity currentActivity() {
        BaseActivity activity = activityStack.lastElement();
        return activity;
    }

    //将当前Activity推入栈中
    public void pushActivity(BaseActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    //退出栈中所有Activity
    public void popAllActivityExceptOne(Class cls) {
        while (true) {
            BaseActivity activity = currentActivity();
            if (activity == null) {
                break;
            }
            if (activity.getClass().equals(cls)) {
                break;
            }
            popActivity(activity);
        }
    }
}
