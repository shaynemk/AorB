package com.keller23.android.aorb;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.keller23.android.aorb.lib.OptionPicker;
import com.keller23.android.aorb.lib.PropertiesHelper;
import java.util.Properties;


public class MainActivity extends Activity {
    // TODO Add GAnalytics [https://support.google.com/googleplay/android-developer/answer/3389759]
    // TODO

    private Context context;
    private PropertiesHelper versionProps;
    private Properties props;
    private PackageInfo appInfo;
    private String versionName = "emptyVersion";
    private boolean debugMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        versionProps = new PropertiesHelper(context);
        versionProps.getProps("version.properties");
        try {
            appInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        versionName = appInfo.versionName.toString();
        //if (ApplicationInfo.FLAG_DEBUGGABLE) ; // TODO figure this debugging flag out?

        final CheckBox checkBoxC, checkBoxD;
        final EditText editTextA, editTextB, editTextC, editTextD;
        editTextA = (EditText) findViewById(R.id.editText_optionA);
        editTextA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextA.getText().toString().contentEquals(getString(R.string.editText_blank))) editTextA.setText("");
            }
        });

        editTextB = (EditText) findViewById(R.id.editText_optionB);
        editTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextB.getText().toString().contentEquals(getString(R.string.editText_blank))) editTextB.setText("");
            }
        });

        checkBoxC = (CheckBox) findViewById(R.id.checkBox_optionC);
        editTextC = (EditText) findViewById(R.id.editText_optionC);
        if (checkBoxC.isChecked()) editTextC.setEnabled(true);
        else editTextC.setEnabled(false);
        editTextC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextC.getText().toString().contentEquals(getString(R.string.editText_blank))) editTextC.setText("");
            }
        });
        checkBoxC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxC.isChecked()) editTextC.setEnabled(true);
                else if (!checkBoxC.isChecked()) editTextC.setEnabled(false);
            }
        });

        checkBoxD = (CheckBox) findViewById(R.id.checkBox_optionD);
        editTextD = (EditText) findViewById(R.id.editText_optionD);
        if (checkBoxD.isChecked()) editTextC.setEnabled(true);
        else editTextD.setEnabled(false);
        editTextD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextD.getText().toString().contentEquals(getString(R.string.editText_blank))) editTextD.setText("");
            }
        });
        checkBoxD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxD.isChecked()) editTextD.setEnabled(true);
                else if (!checkBoxD.isChecked()) editTextD.setEnabled(false);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) { // TODO Add settings activity and link it to the settings button.
            Toast.makeText(getApplicationContext(), R.string.toast_WIP,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_version) { // TODO modify the version Toast to include the current version number. Then, modify it to bring up a custom 'About' toast/page.
            Toast.makeText(getApplicationContext(),"A or B, v"+versionName,Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.action_generate) {
        // FIXME Fix the case where generation runs twice.

            OptionPicker gen = new OptionPicker();
            EditText a = (EditText) findViewById(R.id.editText_optionA),
                           b = (EditText) findViewById(R.id.editText_optionB),
                           c = (EditText) findViewById(R.id.editText_optionC),
                           d = (EditText) findViewById(R.id.editText_optionD);
            CheckBox checkC = (CheckBox) findViewById(R.id.checkBox_optionC),
                           checkD = (CheckBox) findViewById(R.id.checkBox_optionD);
            String result;
            int x = 2;
            //long resultSleep = 5 * 1000;



            // TODO Dynamically add however many options we have to default/blank notification checker.
            // FIXME Keep option d from running If c isn't enabled.
            // TODO Nest the oC and of if statements to require being selected as well as not empty/default.
            if (a.getText().toString().contentEquals(getString(R.string.editText_blank)) || a.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),"Please enter Option A",Toast.LENGTH_SHORT).show();
            else if (b.getText().toString().contentEquals(getString(R.string.editText_blank)) || b.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),"Please enter Option B",Toast.LENGTH_SHORT).show();
            else if (c.isEnabled()) {
                if (c.getText().toString().isEmpty() || c.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Toast.makeText(getApplicationContext(), "Please enter Option C", Toast.LENGTH_SHORT).show();
            }
            else if (d.isEnabled()) {
                if (d.getText().toString().isEmpty() || d.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Toast.makeText(getApplicationContext(),"Please enter Option D",Toast.LENGTH_SHORT).show();
            }
            else {
                // FIXME If you select option D it will still generate regardless of oC being selected or oD being selected/not filled.

                if (checkC.isChecked()) {
                    x += 1;
                    if (checkD.isChecked()) x += 1;
                }

                switch (gen.choose(x)) {
                    case 1:
                        result = a.getText().toString();
                        a.selectAll(); // FIXME EditText selection doesn't appear to be working anymore?
                        //Thread.sleep(resultSleep); // FIXME Select answer, sleep/delay, then deselect and continue?
                        Toast.makeText(getApplicationContext(), "Case 1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        result = b.getText().toString();
                        b.selectAll();
                        Toast.makeText(getApplicationContext(), "Case 2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        result = c.getText().toString();
                        c.selectAll();
                        Toast.makeText(getApplicationContext(), "Case 3", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        result = d.getText().toString();
                        d.selectAll();
                        Toast.makeText(getApplicationContext(), "Case 4", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        result = R.string.toast_error + " in SWITCH";
                }
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                //result = null; // TODO Figure out if result = null is even necessary, let alone helpful.
                //return true; // TODO  Does this make more sense (with below as false) or leave the true return below?
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}