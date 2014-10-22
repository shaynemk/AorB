package com.keller23.android.common.utils;


import android.widget.TextView;
import android.widget.Toast;

import com.keller23.android.common.libs.Refs;

import java.util.Date;

public class Debug {

    private static Date date = new Date();

    public static void toast(String debugMsg) {
        if (Refs.debug) Toast.makeText(Refs.contextMain, Refs.debugPrefix + debugMsg, Toast.LENGTH_SHORT).show();
    }

    public static void log(TextView textViewLog, String logMSG) {
        if (Refs.debug){
            final String strLog = textViewLog.getText().toString() + "\n";
            textViewLog.setText(strLog + date.getTime() + Refs.debugPrefix + logMSG);
        }
    }
}
