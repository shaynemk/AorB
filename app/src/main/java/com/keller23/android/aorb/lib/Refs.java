package com.keller23.android.aorb.lib;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

import com.keller23.android.aorb.R;


public class Refs {
    public static Activity activityMain;


    public static boolean debug = false;
    public static Context contextMain;
    public static PackageInfo appInfo;

    public static EditText editTextA;
    public static EditText editTextB;
    public static EditText editTextC;
    public static EditText editTextD;

    public static CheckBox checkBoxC;
    public static CheckBox checkBoxD;

    public static MenuItem menuItemLog;

    public static String appName;
    public static String version;
    public static String versionDebug;
    public static String nameVersion;
    public static String nameVersionDebug;

    public static final String debugPrefix = "DEBUG: ";
    public static final String WIP = "Work in Progress";
    public static final String debugError = "ERROR: ";
    public static final String optionIncomplete = "Please fill all applicable boxes.";
    public static final String enterOption = "Please enter Option ";

    //public static versionProps = new PropertiesHelper(contextMain);

    public static void init(Context _context, Activity _activity){
        Debug.toast("Initializing References");
        activityMain = _activity;
        contextMain = _context;
        debug = (contextMain.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;

        editTextA = (EditText) activityMain.findViewById(R.id.editText_optionA);
        editTextB = (EditText) activityMain.findViewById(R.id.editText_optionB);
        editTextC = (EditText) activityMain.findViewById(R.id.editText_optionC);
        editTextD = (EditText) activityMain.findViewById(R.id.editText_optionD);

        checkBoxC = (CheckBox) activityMain.findViewById(R.id.checkBox_optionC);
        checkBoxD = (CheckBox) activityMain.findViewById(R.id.checkBox_optionD);

        menuItemLog = (MenuItem) activityMain.findViewById(R.id.action_log);


        try {
            Refs.appInfo = contextMain.getPackageManager().getPackageInfo(contextMain.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        appName = activityMain.getString(R.string.app_name);
        version = "v" + appInfo.versionName;
        versionDebug = version + "|DEBUG";
        nameVersion = appName + ", " + version;
        nameVersionDebug = appName + ", " + versionDebug;
    }

    /*public Refs(Activity _act){
        //activity = _act;
    }*/
}
