package gtf35.hacke4achecks;

import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook  implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        /*判断包名，不是需要的就跳过*/
        if (lpparam.packageName.equals(HookSettings.E4aPackageName) == false ) return;
        /*到这里还没return就是目标进程了*/
        XposedBridge.log("找到目标 HOOK 程序:" + HookSettings.E4aPackageName);
        XposedHelpers.findAndHookMethod(HookSettings.E4aApplicationName, lpparam.classLoader,
                "attachBaseContext", Context.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        //获取到Context对象，通过这个对象来获取classloader
                        Context context = (Context) param.args[0];
                        //获取classloader，之后hook加固后的就使用这个classloader
                        ClassLoader classLoader =context.getClassLoader();
                        //下面就是将classloader修改成壳的classloader就可以成功的hook了
                        XposedHelpers.findAndHookMethod(HookSettings.HookCheckClass, classLoader, HookSettings.HookCheckMethod, Context.class, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                param.setResult((Boolean) false);
                                XposedBridge.log("去除了一次Hook检测：PackageName=" +
                                        HookSettings.E4aPackageName +
                                        ",ApplicationName=" +
                                        HookSettings.E4aApplicationName +
                                        ",HookCheckClass=" + HookSettings.HookCheckClass +
                                        ",HookCheckMethod=" + HookSettings.HookCheckMethod);
                            }
                        });

                        XposedHelpers.findAndHookMethod(HookSettings.RootCheckClass, classLoader, HookSettings.RootCheckMethod, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                param.setResult((Boolean) false);
                                XposedBridge.log("去除了一次Root检测：PackageName=" +
                                        HookSettings.E4aPackageName +
                                        ",ApplicationName=" +
                                        HookSettings.E4aApplicationName +
                                        ",RootCheckClass=" + HookSettings.RootCheckClass +
                                        ",RootCheckClass=" + HookSettings.RootCheckClass);
                            }
                        });

                        XposedHelpers.findAndHookMethod(HookSettings.VirtualCheckClass, classLoader, HookSettings.VirtualCheckMethod, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                param.setResult((Boolean) false);
                                XposedBridge.log("去除了一次双开检测：PackageName=" +
                                        HookSettings.E4aPackageName +
                                        ",ApplicationName=" +
                                        HookSettings.E4aApplicationName +
                                        ",VirtualCheckClass=" + HookSettings.VirtualCheckClass +
                                        ",VirtualCheckMethod=" + HookSettings.VirtualCheckMethod);
                            }
                        });

                        XposedHelpers.findAndHookMethod(HookSettings.EmulatorCheckClass, classLoader, HookSettings.EmulatorCheckMethod, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                param.setResult((Boolean) false);
                                XposedBridge.log("去除了一次模拟器检测：PackageName=" +
                                        HookSettings.E4aPackageName +
                                        ",ApplicationName=" +
                                        HookSettings.E4aApplicationName +
                                        ",EmulatorCheckClass=" + HookSettings.EmulatorCheckClass +
                                        ",EmulatorCheckMethod=" + HookSettings.EmulatorCheckMethod);
                            }
                        });

                        XposedHelpers.findAndHookMethod(HookSettings.VPNCheckClass, classLoader, HookSettings.VPNCheckMethod, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                param.setResult((Boolean) false);
                                XposedBridge.log("去除了一次VPN检测：PackageName=" +
                                        HookSettings.E4aPackageName +
                                        ",ApplicationName=" +
                                        HookSettings.E4aApplicationName +
                                        ",VPNCheckClass=" + HookSettings.VPNCheckClass +
                                        ",VPNCheckMethod=" + HookSettings.VPNCheckMethod);
                            }
                        });

                        XposedHelpers.findAndHookMethod(HookSettings.EmulatorCheckClass2, classLoader, HookSettings.EmulatorCheckMethod21, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                param.setResult((Boolean) true);
                                XposedBridge.log("去除了一次模拟器检测21：PackageName=" +
                                        HookSettings.E4aPackageName +
                                        ",ApplicationName=" +
                                        HookSettings.E4aApplicationName +
                                        ",EmulatorCheckClass2=" + HookSettings.EmulatorCheckClass2 +
                                        ",EmulatorCheckMethod21=" + HookSettings.EmulatorCheckMethod21);
                            }
                        });

                        XposedHelpers.findAndHookMethod(HookSettings.EmulatorCheckClass2, classLoader, HookSettings.EmulatorCheckMethod22, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                                super.afterHookedMethod(param);
                                param.setResult((Boolean) true);
                                XposedBridge.log("去除了一次模拟器检测22：PackageName=" +
                                        HookSettings.E4aPackageName +
                                        ",ApplicationName=" +
                                        HookSettings.E4aApplicationName +
                                        ",EmulatorCheckClass2=" + HookSettings.EmulatorCheckClass2 +
                                        ",EmulatorCheckMethod22=" + HookSettings.EmulatorCheckMethod22);
                            }
                        });

                    }

                });
        }
    }
