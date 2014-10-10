package com.keller23.android.aorb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.keller23.android.aorb.init.UserInterface;
import com.keller23.android.aorb.lib.Debug;
import com.keller23.android.aorb.lib.OptionPicker;
import com.keller23.android.aorb.lib.Refs;


public class MainActivity extends Activity {
    // TODO Add GAnalytics [https://support.google.com/googleplay/android-developer/answer/3389759]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // TODO Use this to change to our settings activity?

        // init the References
        Refs.init(getApplicationContext(), this);

        // init the UserInterface
        UserInterface.init();

        // one last init
        //Refs.menuItem_debugLog = (MenuItem) findViewById(R.id.action_log);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        // FIXME Fix the attempt at disabling the CheckBox's and Debug Log if not in debug mode.
        //menu.findItem(R.id.checkBox_optionC).setVisible(!Refs.debug);
        //menu.findItem(R.id.checkBox_optionD).setVisible(!Refs.debug);
        //menu.findItem(R.id.action_log).setEnabled(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if (id == R.id.action_settings) { // TODO Add settings activity and link it to the settings button.
            Debug.toast(Refs.debugWIP);
            return true;
        }
        else if (id == R.id.action_version) { // TODO Move this to display on the settings page or something.
            if (Refs.debug)
                Toast.makeText(Refs.contextMain,Refs.nameVersionDebug,Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Refs.contextMain,Refs.nameVersion,Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.action_log) { // TODO Create log activity and logging backend.
            Debug.toast(Refs.debugWIP);
        }
        else if (id == R.id.action_generate) {
            // FIXME Fix the case where generation runs twice.
            // FIXME Move the option picking code to a separate class.

            OptionPicker gen = new OptionPicker();
            String result;
            int x = 2;

            // TODO Dynamically add however many options we have to default/blank notification checker.
            // FIXME Keep option d from running If c isn't enabled.
            // TODO Nest the oC and oD if statements to require being selected as well as not empty/default.
            // TODO Move the option picking logic to the OptionPicker class.
            if (Refs.editTextA.getText().toString().contentEquals(getString(R.string.editText_blank)) || Refs.editTextA.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),Refs.optionEnter + "A",Toast.LENGTH_SHORT).show();
            else if (Refs.editTextB.getText().toString().contentEquals(getString(R.string.editText_blank)) || Refs.editTextB.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),Refs.optionEnter + "B",Toast.LENGTH_SHORT).show();
            else if (Refs.editTextC.isEnabled()) {
                Debug.toast("C is enabled, checking content.");
                if (Refs.editTextC.getText().toString().contentEquals("") || Refs.editTextC.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Toast.makeText(getApplicationContext(), Refs.optionEnter + "C", Toast.LENGTH_SHORT).show();
            }
            else if (Refs.editTextD.isEnabled()) {
                if (Refs.editTextD.getText().toString().contentEquals("") || Refs.editTextD.getText().toString().contentEquals(getString(R.string.editText_blank)))
                    Toast.makeText(getApplicationContext(),Refs.optionEnter + "D",Toast.LENGTH_SHORT).show();
            }
            else {
                // FIXME If you select option D it will still generate regardless of oC being selected or oD being selected/not filled.

                if (Refs.checkBoxC.isChecked()) {
                    Debug.toast("CheckBox C is checked.");
                    x += 1;
                    if (Refs.checkBoxD.isChecked()) {
                        Debug.toast("CheckBox D is checked.");
                        x += 1;
                    }
                }

                Debug.toast("Generating for (" + x + ") options.");
                switch (gen.generate(x)) {
                    case 1:
                        result = Refs.editTextA.getText().toString();
                        Refs.editTextA.selectAll();
                        Debug.toast("Case 1 has been chosen.");
                        break;
                    case 2:
                        result = Refs.editTextB.getText().toString();
                        Refs.editTextB.selectAll();
                        Debug.toast("Case 2 has been chosen.");
                        break;
                    case 3:
                        result = Refs.editTextC.getText().toString();
                        Refs.editTextC.selectAll();
                        Debug.toast("Case 3 has been chosen.");
                        break;
                    case 4:
                        result = Refs.editTextD.getText().toString();
                        Refs.editTextD.selectAll();
                        Debug.toast("Case 4 has been chosen.");
                        break;
                    default:
                        result = Refs.debugError + " in SWITCH";
                        Debug.toast("Switch has hit default case: ERROR.");
                }
                // TODO Change results display to a popup window that you have to accept answer to close.
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}