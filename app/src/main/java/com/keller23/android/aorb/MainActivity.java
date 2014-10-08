package com.keller23.android.aorb;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.keller23.android.aorb.lib.OptionPicker;
import com.keller23.android.aorb.lib.Refs;


public class MainActivity extends Activity {
    // TODO Add GAnalytics [https://support.google.com/googleplay/android-developer/answer/3389759]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Refs.contextMain = this;
        Refs.debug = (Refs.contextMain.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;

        //versionProps = new PropertiesHelper(contextMain);
        //versionProps.getProps("version.properties");
        try {
            Refs.appInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        debug("App ("+ Refs.appInfo.versionName +") is starting up...");


        Refs.editTextA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Refs.editTextA.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Refs.editTextA.setText("");
            }
        });

        Refs.editTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Refs.editTextB.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Refs.editTextB.setText("");
            }
        });

        if (Refs.checkBoxC.isChecked()) Refs.editTextC.setEnabled(true);
        else Refs.editTextC.setEnabled(false);
        Refs.editTextC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Refs.editTextC.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Refs.editTextC.setText("");
            }
        });
        Refs.checkBoxC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Refs.checkBoxC.isChecked()) Refs.editTextC.setEnabled(true);
                else if (!Refs.checkBoxC.isChecked()) Refs.editTextC.setEnabled(false);
            }
        });

        if (Refs.checkBoxD.isChecked()) Refs.editTextC.setEnabled(true);
        else Refs.editTextD.setEnabled(false);
        Refs.editTextD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Refs.editTextD.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Refs.editTextD.setText("");
            }
        });
        Refs.checkBoxD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Refs.checkBoxD.isChecked()) Refs.editTextD.setEnabled(true);
                else if (!Refs.checkBoxD.isChecked()) Refs.editTextD.setEnabled(false);
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
            Toast.makeText(Refs.contextMain, R.string.toast_WIP,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_version) { // TODO Move this to display on the settings page or something.
            Toast.makeText(Refs.contextMain,"A or B, v"+ Refs.appInfo.versionName,Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.action_generate) {
            // FIXME Fix the case where generation runs twice.
            // FIXME Move the option picking code to a separate class.

            OptionPicker gen = new OptionPicker();
            /*EditText a = (EditText) findViewById(R.id.editText_optionA),
                           b = (EditText) findViewById(R.id.editText_optionB),
                           c = (EditText) findViewById(R.id.editText_optionC),
                           d = (EditText) findViewById(R.id.editText_optionD);
            CheckBox checkC = (CheckBox) findViewById(R.id.checkBox_optionC),
                           checkD = (CheckBox) findViewById(R.id.checkBox_optionD);*/
            String result;
            int x = 2;


            // TODO Dynamically add however many options we have to default/blank notification checker.
            // FIXME Keep option d from running If c isn't enabled.
            // TODO Nest the oC and of if statements to require being selected as well as not empty/default.
            if (Refs.editTextA.getText().toString().contentEquals(getString(R.string.editText_blank)) || Refs.editTextA.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),"Please enter Option A",Toast.LENGTH_SHORT).show();
            else if (Refs.editTextB.getText().toString().contentEquals(getString(R.string.editText_blank)) || Refs.editTextB.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),"Please enter Option B",Toast.LENGTH_SHORT).show();
            else if (Refs.editTextC.isEnabled()) {
                debug("C is enabled, checking content.");
                if (Refs.editTextC.getText().toString().contentEquals("") || Refs.editTextC.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Toast.makeText(getApplicationContext(), "Please enter Option C", Toast.LENGTH_SHORT).show();
            }
            else if (Refs.editTextD.isEnabled()) {
                if (Refs.editTextD.getText().toString().contentEquals("") || Refs.editTextD.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Toast.makeText(getApplicationContext(),"Please enter Option D",Toast.LENGTH_SHORT).show();
            }
            else {
                // FIXME If you select option D it will still generate regardless of oC being selected or oD being selected/not filled.


                if (Refs.checkBoxC.isChecked()) {
                    debug("CheckBox C is checked.");
                    x += 1;
                    if (Refs.checkBoxD.isChecked()) {
                        debug("CheckBox D is checked.");
                        x += 1;
                    }
                }

                debug("Generating for ("+x+") options.");
                switch (gen.choose(x)) {
                    case 1:
                        result = Refs.editTextA.getText().toString();
                        Refs.editTextA.selectAll();
                        debug("Case 1 has been chosen.");
                        break;
                    case 2:
                        result = Refs.editTextB.getText().toString();
                        Refs.editTextB.selectAll();
                        debug("Case 2 has been chosen.");
                        break;
                    case 3:
                        result = Refs.editTextC.getText().toString();
                        Refs.editTextC.selectAll();
                        debug("Case 3 has been chosen.");
                        break;
                    case 4:
                        result = Refs.editTextD.getText().toString();
                        Refs.editTextD.selectAll();
                        debug("Case 4 has been chosen.");
                        break;
                    default:
                        result = R.string.toast_error + " in SWITCH";
                        debug("Switch has hit default case: ERROR.");
                }
                // TODO Change results display to a popup window that you have to accept answer to close.
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void debug(String debugMsg) { // FIXME fix how the numbers from debugMsg are coming up in the toast.
        if (Refs.debug) Toast.makeText(Refs.contextMain, getString(R.string.debugMsg) + debugMsg,Toast.LENGTH_SHORT).show();
    }
}