package com.keller23.android.common.log;

import android.widget.Toast;

import com.keller23.android.common.libs.Refs;

public class Log {

    private static void log(String _msg) {
        Refs.logContent += _msg + "<br>";
        //Crashlytics.log(_msg);
        /*if (Refs.activityCurrent.getClass().getSimpleName().equals(".LogActivity")) Refs.textViewLog.setText(Html.fromHtml(Refs.logContent));*/
    }

    private static void toast(String msg) {
        Toast.makeText(Refs.activityCurrent, msg, Toast.LENGTH_SHORT).show();
    }

    public static void d(String _msg) {
        String msg = "<font color=blue>" + "[DEBUG] " + _msg + "</font>";
        log(msg);
    }

    public static void i(String _msg) {
        String msg = "<font color=black>" + "[INFO] " + _msg + "</font>";
        toast(_msg);
        log(msg);
    }
}
