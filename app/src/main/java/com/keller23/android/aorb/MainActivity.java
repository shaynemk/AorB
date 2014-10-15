package com.keller23.android.aorb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.keller23.android.aorb.init.UserInterface;
import com.keller23.android.aorb.lib.Debug;
import com.keller23.android.aorb.lib.Info;
import com.keller23.android.aorb.lib.OptionPicker;
import com.keller23.android.aorb.lib.Refs;


public class MainActivity extends Activity {
    // TODO Add GAnalytics [https://support.google.com/googleplay/android-developer/answer/3389759]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // TODO Use this to change to our settings activity?

        // init the References
        Refs.init(getApplicationContext(), this, savedInstanceState);

        // init the UserInterface
        UserInterface.init();

        // one last init
        //Refs.menuItem_debugLog = (MenuItem) findViewById(R.id.action_log);
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
        if (id == R.id.action_settings) { // TODO Learn how to hook the SettingsActivity.java in this.
            Debug.toast("Clicked on Settings");
            //Info.toast(Refs.WIP);
            //runSettingsActivity();
            return true;
        }
        else if (id == R.id.action_version) { // TODO Move this to display on the settings page or something.
            if (Refs.debug)
                Toast.makeText(Refs.contextMain,Refs.nameVersionDebug,Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Refs.contextMain,Refs.nameVersion,Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.action_log) { // TODO Create log activity and logging backend.
            Info.toast(Refs.WIP);
        }
        else if (id == R.id.action_generate) {

            OptionPicker pick = new OptionPicker();
            pick.pickOption();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // This should be auto hooked from android:onClick in the main.xml menu
    public void runSettingsActivity(View v) {
        Debug.toast("Inside runSettingsActivity()");
        // Copied from http://developer.android.com/training/basics/firstapp/starting-activity.html
        Intent intent = new Intent(this, SettingsActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        Debug.toast("Starting Settings Activity");
        startActivity(intent);
    }
}