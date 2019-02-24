package gtf35.hacke4achecks;

public class HookSettings {
    /******************应用设置************************/
    public final static String E4aPackageName = "请替换为要绕过的应用的包名";
    public final static String E4aApplicationName = "请替换为要绕过的应用的Application类名";


    /******************Hook设置************************/
    /******************Hook检测设置************************/
    public final static String HookCheckClass = "com.e4a.runtime.components.impl.android.反群控软件类型类库.CheckHook";
    public final static String HookCheckMethod = "isHook";
    /******************Root检测设置************************/
    public final static String RootCheckClass = "com.e4a.runtime.components.impl.android.反群控软件类型类库.CheckRoot";
    public final static String RootCheckMethod = "isDeviceRooted";
    /******************双开检测设置************************/
    public final static String VirtualCheckClass = "com.e4a.runtime.components.impl.android.反群控软件类型类库.CheckVirtual";
    public final static String VirtualCheckMethod = "isRunInVirtual";
    /******************模拟器检测设置************************/
    public final static String EmulatorCheckClass = "com.e4a.runtime.components.impl.android.反群控软件类型类库.EmulatorDetector";
    public final static String EmulatorCheckMethod = "isEmulator";
    /******************VPN检测设置************************/
    public final static String VPNCheckClass = "com.e4a.runtime.components.impl.android.检测抓包类库.检测抓包Impl";
    public final static String VPNCheckMethod = "检测";
    /******************模拟器检测设置2************************/
    public final static String EmulatorCheckClass2 = "com.mnqjc.Simulatortest";
    public final static String EmulatorCheckMethod21 = "模拟器特定文件检测方案";
    public final static String EmulatorCheckMethod22 = "CPU检测方案";
}
