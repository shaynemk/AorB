package com.keller23.android.aorb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.keller23.android.aorb.init.UserInterface;
import com.keller23.android.aorb.libs.Info;
import com.keller23.android.aorb.libs.OptionPicker;
import com.keller23.android.aorb.libs.Refs;
import com.keller23.android.common.log.Log;

import io.fabric.sdk.android.Fabric;


public class MainActivity extends Activity {
    // TODO Add GAnalytics [https://support.google.com/googleplay/android-developer/answer/3389759]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Fabric.with(this, new Crashlytics());*/
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);
        Crashlytics.setBool("forced_crash", false);;

        setContentView(R.layout.activity_main);
        Refs.activityCurrent = this;
        Refs.contextCurrent = getApplicationContext();

        // mainInit the References
        Refs.init(getApplicationContext(), this, savedInstanceState, getString(R.string.app_name));
        Refs.initMain();

        // mainInit the UserInterface
        UserInterface.mainInit();

        // one last mainInit
        //Refs.menuItem_debugLog = (MenuItem) findViewById(R.id.action_log);

        // log testing. not ready yet.
        Log.d("App finished loading.");
        /*Debug.log(Refs.textViewLog, "App finished loading.");*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        Refs.menuItemLog = menu.findItem(R.id.action_log);
        Refs.menuItemLog.setEnabled(Refs.debug);
        Refs.menuItemLog.setVisible(Refs.debug);

    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Log.d("Clicked on Settings.");
            /*Debug.toast("Clicked on Settings");*/
            if (Refs.debug) runSettings();
            else Info.toast(Refs.WIP);
            return true;
        }
        else if (id == R.id.action_version) { // TODO Move this to display on the settings page or something.
            if (Refs.debug)
                Toast.makeText(Refs.contextMain,Refs.appNameVersionDebug,Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Refs.contextMain,Refs.appNameVersion,Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.action_log) { // TODO Create log activity and logging backend.
            Log.d("Clicked on Log.");
            /*Debug.toast("Clicked on Log");*/
            if (Refs.debug) runLog();
            else Info.toast(Refs.WIP);
        }
        else if (id == R.id.action_generate) {

            OptionPicker pick = new OptionPicker();
            pick.pickOption();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*called when user clicks on settings menu button*/
    public void runSettings() {
        Log.d("Inside runSettings().");
        /*Debug.toast("Inside runSettings()");*/
        // Copied from http://developer.android.com/training/basics/firstapp/starting-activity.html
        Intent intent = new Intent(this, SettingsActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);

        Log.d("Starting Settings Activity.");
        /*Debug.toast("Starting Settings Activity");*/
        startActivity(intent);
    }

    /*called when user clicks on settings menu button*/
    public void runLog() {
        //Debug.toast("Inside runLog()");
        // Copied from http://developer.android.com/training/basics/firstapp/starting-activity.html
        Intent intent = new Intent(this, LogActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);

        Log.d("Starting Log Activity.");
        /*Debug.toast("Starting Log Activity");*/
        startActivity(intent);
    }
}
