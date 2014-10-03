package com.keller23.android.aorb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            Toast.makeText(getApplicationContext(),R.string.toast_WIP,Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.action_generate) { // TODO Fix the case where generation runs twice.
            OptionPicker gen = new OptionPicker();
            final EditText a = (EditText) findViewById(R.id.editText_optionA),
                           b = (EditText) findViewById(R.id.editText_optionB),
                           c = (EditText) findViewById(R.id.editText_optionC),
                           d = (EditText) findViewById(R.id.editText_optionD);

            // TODO Dynamically add however many options we have to default/blank notification checker.
            // TODO Add in the case to deny generation when an option field is enabled, but blank.
            if (a.getText().toString().contentEquals(getString(R.string.editText_blank)) || a.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),"Please enter Option A",Toast.LENGTH_SHORT).show();
            else if (b.getText().toString().contentEquals(getString(R.string.editText_blank)) || b.getText().toString().isEmpty()) Toast.makeText(getApplicationContext(),"Please enter Option B",Toast.LENGTH_SHORT).show();
            else if (c.isEnabled() && (c.getText().toString().isEmpty() || c.getText().toString().contentEquals(getString(R.string.editText_blank)))) Toast.makeText(getApplicationContext(),"Please enter Option C",Toast.LENGTH_SHORT).show();
            else if (d.isEnabled() && (d.getText().toString().isEmpty() || d.getText().toString().contentEquals(getString(R.string.editText_blank)))) Toast.makeText(getApplicationContext(),"Please enter Option D",Toast.LENGTH_SHORT).show();
            //else Toast.makeText(getApplicationContext(),R.string.toast_error + "in default/empty check",Toast.LENGTH_SHORT).show();

            String result;
            int x = 2;
            final CheckBox checkC, checkD;
            checkC = (CheckBox) findViewById(R.id.checkBox_optionC);
            checkD = (CheckBox) findViewById(R.id.checkBox_optionD);
            if (checkC.isChecked()) {
                x += 1;
                if (checkD.isChecked()) x += 1;
            }
            int i = gen.choose(x);
            switch (i) {
                case 1:
                    result =  a.getText().toString();
                    Toast.makeText(getApplicationContext(),result + "is the result, duh.", Toast.LENGTH_LONG);
                    break;
                case 2:
                    result = b.getText().toString();
                    break;
                case 3:
                    result = c.getText().toString();
                    break;
                case 4:
                    result = b.getText().toString(); // TODO Fix this option switch to include all options.
                    break;
                default:
                    result = R.string.toast_error + " in SWITCH";
            }
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            //result = null; // TODO Figure out if result = null is even necessary, let alone helpful.
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}