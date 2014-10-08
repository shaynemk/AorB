package com.keller23.android.aorb.lib;


import android.widget.Toast;
import com.keller23.android.aorb.R;

public class Debug {

    public static void toast(String debugMsg) { // FIXME fix how the numbers from debugMsg are coming up in the toast.
        if (Refs.debug) Toast.makeText(Refs.contextMain, Refs.contextMain.getString(R.string.debugMsg) + debugMsg, Toast.LENGTH_SHORT).show();
    }
}
