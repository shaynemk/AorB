package com.keller23.android.aorb.libs;


import android.widget.Toast;

public class Info {

    public static void toast(String msg) {
        Toast.makeText(Refs.contextMain, msg, Toast.LENGTH_SHORT).show();
    }
}
