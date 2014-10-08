package com.keller23.android.aorb.lib;


import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.widget.CheckBox;
import android.widget.EditText;

import com.keller23.android.aorb.R;


public class Refs {
    public static Activity activity;
    public Refs(Activity _act){
        activity = _act;
    }

    public static boolean debug = false;
    public static Context contextMain;
    public static PackageInfo appInfo;

    public static EditText editTextA = (EditText) activity.findViewById(R.id.editText_optionA);
    public static EditText editTextB = (EditText) activity.findViewById(R.id.editText_optionB);
    public static EditText editTextC = (EditText) activity.findViewById(R.id.editText_optionC);
    public static EditText editTextD = (EditText) activity.findViewById(R.id.editText_optionD);

    public static CheckBox checkBoxC = (CheckBox) activity.findViewById(R.id.checkBox_optionC);
    public static CheckBox checkBoxD = (CheckBox) activity.findViewById(R.id.checkBox_optionD);

}
