package com.keller23.android.aorb;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.keller23.android.aorb.init.UserInterface;
import com.keller23.android.aorb.libs.Refs;
import com.keller23.android.common.log.Log;


public class LogActivity extends Activity {
    /*https://github.com/shaynemk/AorB.git*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Refs.activityCurrent = this;
        Refs.contextCurrent = getApplicationContext();

        Log.d("In LogActivity's onCreate()");
        /*Debug.toast("In LogActivity's onCreate()");*/

        Refs.initLog(getApplicationContext(), this, savedInstanceState);
        UserInterface.logInit();

        if (com.keller23.android.common.libs.Refs.activityCurrent.getClass().getSimpleName().equals(".LogActivity")) Refs.textViewLog.setText(Html.fromHtml(Refs.logContent));

        if (Refs.debug) Refs.textViewLogAppInfo.setText(Refs.appNameVersionDebug);
        else Refs.textViewLogAppInfo.setText(Refs.appNameVersion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // Disabled as we don't yet need a menu in the LogActivity activity.
        /*getMenuInflater().inflate(R.menu.log, menu);*/

        Refs.textViewLogAppInfo = (TextView) findViewById(R.id.textView_LogAppInfo);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        /*if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);*/
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
