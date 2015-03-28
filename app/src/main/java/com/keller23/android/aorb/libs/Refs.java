package com.keller23.android.aorb.libs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.keller23.android.aorb.R;
import com.keller23.android.common.log.Log;

public class Refs extends com.keller23.android.common.libs.Refs {

    public static final String enterOption = "Please enter Option ";
    public static Activity activityLog;
    public static Bundle bundleLog;
    public static Context contextLog;
    public static Button buttonClearLog;
    public static Button buttonCrash;
    public static CheckBox checkBoxC;
    public static CheckBox checkBoxD;
    public static EditText editTextA;
    public static EditText editTextB;
    public static EditText editTextC;
    public static EditText editTextD;
    public static MenuItem menuItemLog;
    public static TextView textViewLogAppInfo;
    public static TextView textViewLog;

    //public static versionProps = new PropertiesHelper(contextMain);

    public static void initMain() {
        Log.d("Initializing App Main Refs.");
        /*Debug.toast("Initializing App Main Refs.");*/
        editTextA = (EditText) activityMain.findViewById(R.id.editText_optionA);
        editTextB = (EditText) activityMain.findViewById(R.id.editText_optionB);
        editTextC = (EditText) activityMain.findViewById(R.id.editText_optionC);
        editTextD = (EditText) activityMain.findViewById(R.id.editText_optionD);
        checkBoxC = (CheckBox) activityMain.findViewById(R.id.checkBox_optionC);
        checkBoxD = (CheckBox) activityMain.findViewById(R.id.checkBox_optionD);
    }

    public static void initLog(Context _context, Activity _activity, Bundle _bundle) {
        Log.d("Initializing App Log Refs.");
        /*Debug.toast("Initializing App Log Refs.");*/
        contextLog = _context;
        activityLog = _activity;
        bundleLog = _bundle;
        textViewLogAppInfo = (TextView) activityLog.findViewById(R.id.textView_LogAppInfo);
        textViewLog = (TextView) activityLog.findViewById(R.id.textView_Log);
        buttonClearLog = (Button) activityLog.findViewById(R.id.buttonClearLog);
        buttonCrash = (Button) activityLog.findViewById(R.id.buttonCrash);

        textViewLog.setText(Html.fromHtml(logContent));
    }

    /*public Refs(Activity _act){
        //activity = _act;
    }*/
}
