package com.keller23.android.aorb.libs;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
    private Context context;
    private Properties props;

    public PropertiesHelper(Context context) {
        this.context = context;
        props = new Properties();
    }

    public Properties getProps(String file) {
        try {
            AssetManager assetMgr = context.getAssets();
            InputStream iStream = assetMgr.open(file);
            props.load(iStream);
        } catch (IOException e) {
            // LogActivity.e("PropertiesHelper",e.toString());
            //Toast.makeText(contextMain, R.string.toast_error + ": IOException thrown in PropertiesHelper.getProps()", Toast.LENGTH_LONG).show();
        }
        return props;
    }
}