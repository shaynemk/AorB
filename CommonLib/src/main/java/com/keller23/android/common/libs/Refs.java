package com.keller23.android.common.libs;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
/*import com.keller23.android.common.utils.Debug;*/

public class Refs {

    public static Activity activityMain;
    public static Bundle bundleMain;
    public static Context contextMain;

    public static boolean debug = false;
    public static PackageInfo appInfo;

    public static final String defaultAppName = "default";
    public static String appName = defaultAppName;
    public static String version;
    public static String versionDebug;
    public static String appNameVersion;
    public static String appNameVersionDebug;
    public static final String debugPrefix = "DEBUG: ";
    public static final String WIP = "Work in Progress";
    public static final String errorPrefix = "ERROR: ";

    public static void init(Context _context, Activity _activity, Bundle _bundle, String nameOfApp){
        toast("Initializing Common Refs");
        activityMain = _activity;
        contextMain = _context;
        bundleMain =_bundle;
        debug = (contextMain.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;

        try {
            Refs.appInfo = contextMain.getPackageManager().getPackageInfo(contextMain.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        /*appName = activityMain.getString(R.string.app_name);*/ // refactored in favor of more dynamic assignment
        appName = nameOfApp;
        version = "v" + appInfo.versionName;
        versionDebug = version + "|DEBUG";
        if (!appName.contentEquals(defaultAppName)) {
            appNameVersion = appName + ", " + version;
            appNameVersionDebug = appName + ", " + versionDebug;
        }
        else toast("appName has not been defined properly.");
    }

    private static void toast(String str) {
        if (debug) Toast.makeText(contextMain,str,Toast.LENGTH_LONG).show();
    }
}


/* Leftover definitions unneeded since building commonLib package.
    // Old global definitions
    /*public static final String optionIncomplete = "Please fill all applicable boxes.";
    public static final String enterOption = "Please enter Option ";
    public static versionProps = new PropertiesHelper(contextMain);
    public static Activity activityLog;
    public static Bundle bundleLog;
    public static Context contextLog;
    public static EditText editTextA;
    public static EditText editTextB;
    public static EditText editTextC;
    public static EditText editTextD;
    public static CheckBox checkBoxC;
    public static CheckBox checkBoxD;
    public static MenuItem menuItemLog;
    public static MenuItem menuItemSettings;
    public static TextView textViewLogAppInfo;

    // From init()
    editTextA = (EditText) activityMain.findViewById(R.id.editText_optionA);
    editTextB = (EditText) activityMain.findViewById(R.id.editText_optionB);
    editTextC = (EditText) activityMain.findViewById(R.id.editText_optionC);
    editTextD = (EditText) activityMain.findViewById(R.id.editText_optionD);
    checkBoxC = (CheckBox) activityMain.findViewById(R.id.checkBox_optionC);
    checkBoxD = (CheckBox) activityMain.findViewById(R.id.checkBox_optionD);
    menuItemLog = (MenuItem) activityMain.findViewById(R.id.action_log);
    menuItemSettings = (MenuItem) activityMain.findViewById(R.id.action_settings);

    // Misc classes
    public static void initLog(Context _context, Activity _activity, Bundle _bundle) {
        Debug.toast("Initializing Log Refs.");

        contextLog = _context;
        activityLog = _activity;
        bundleLog = _bundle;
        textViewLogAppInfo = (TextView) activityLog.findViewById(R.id.textView_LogAppInfo);
    }
    public Refs(Activity _act){
        //activity = _act;
    }*/

