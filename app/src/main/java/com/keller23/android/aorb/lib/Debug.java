package com.keller23.android.aorb.lib;


import android.widget.Toast;

public class Debug {

    public static void toast(String debugMsg) {
        if (Refs.debug) Toast.makeText(Refs.contextMain, Refs.debugPrefix + debugMsg, Toast.LENGTH_SHORT).show();
    }
}
