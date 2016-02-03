package org.niray.dingtalkluckmoney;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;


public class Main implements IXposedHookLoadPackage {

    private final String APP_PACKAGE_NAME = "com.alibaba.android.rimet";
    private final String MAP_CLASS_NAME = "com.alibaba.android.dingtalk.redpackets.activities.PickRedPacketsActivity";
    private final String MAP_FUNCTION_NAME = "a";

    public void handleLoadPackage(final LoadPackageParam lpParam) throws Throwable {

        if (!lpParam.packageName.equals(APP_PACKAGE_NAME)) return;

//        //get version
//        final Object activityThread = callStaticMethod(findClass("android.app.ActivityThread", null), "currentActivityThread");
//        final Context systemContext = (Context) callMethod(activityThread, "getSystemContext");
        //map
        findAndHookMethod(MAP_CLASS_NAME, lpParam.classLoader, MAP_FUNCTION_NAME, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                View mView = (View) XposedHelpers.getObjectField(param.thisObject, "h");
                XposedBridge.log("Hook  h  Success" + mView.getId());
                Log.e("Ding", "Hook  h  Success" + mView.getId());

                mView.callOnClick();
//                mView.performClick();
                mView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                    }
                });
            }
        });
    }
}

