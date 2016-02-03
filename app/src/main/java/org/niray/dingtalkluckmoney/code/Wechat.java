//package org.niray.dingtalkluckmoney;
//
//import java.lang.reflect.Constructor;
//import java.util.regex.Pattern;
//
//import de.robv.android.xposed.XC_MethodHook;
//import de.robv.android.xposed.XposedBridge;
//
//import static de.robv.android.xposed.XposedHelpers.findClass;
//import static de.robv.android.xposed.XposedHelpers.findConstructorExact;
//
//public final class Wechat {
//    final static String PACKAGE_NAME = "com.tencent.mm";
//    static ClassLoader CLASS_LOADER;
//
//    //map
//    static String MAP_CLASS_NAME;
//    static String MAP_FUNCTION_NAME;
//    //db
//    static String[] DB_CONTEXT_STRINGS;
//    static Class FIND_CLASS_AH;
//
//    //msgId
//    static Object MESSAGE_TABLE_CONTEXT;
//    static String[] UPDATE_MSGID_STRINGS;
//
//
//    public static boolean init(String version, ClassLoader classLoader) {
//        Wechat.CLASS_LOADER = classLoader;
//
//                setArgs(new String[]{"u", "D"}, new String[]{"bh", "sS", "qQ", "dGo"}, new String[]{"Cv", "aSC"});
//                Constructor CONSTRUCTOR_AY = findConstructorExact(findClass("com.tencent.mm.storage.ay", CLASS_LOADER),
//                        findClass("com.tencent.mm.at.h", CLASS_LOADER));
//
//                XposedBridge.hookMethod(CONSTRUCTOR_AY, new XC_MethodHook() {
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        MESSAGE_TABLE_CONTEXT = param.thisObject;
//                    }
//                });
//
//    public static void setArgs(String[] mapStrings, String[] dbContextStrings, String[] updateMsgIdStrings) {
//        //map
//        MAP_CLASS_NAME = "com.tencent.mm.sdk.platformtools." + mapStrings[0];
//        MAP_FUNCTION_NAME = mapStrings[1];
//
//        //db
//        DB_CONTEXT_STRINGS = dbContextStrings;
//        FIND_CLASS_AH = findClass("com.tencent.mm.model." + dbContextStrings[0], CLASS_LOADER);
//
//        //msgId
//        UPDATE_MSGID_STRINGS = updateMsgIdStrings;
//    }
//}