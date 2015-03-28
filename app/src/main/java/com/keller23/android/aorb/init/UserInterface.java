package com.keller23.android.aorb.init;

import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.keller23.android.aorb.R;
import com.keller23.android.aorb.libs.Refs;
import com.keller23.android.common.log.Log;

public class UserInterface {

    public static void mainInit() {
        Log.d("Running UI.mainInit()");
        /*Debug.toast("Running UI.mainInit()");*/
        mainClickListeners();
        MainUIElements();
    }

    public static void logInit() {
        logClickListeners();
    }

    private static void MainUIElements() {
        Refs.editTextC.setEnabled(Refs.checkBoxC.isChecked());
        Refs.editTextD.setEnabled(Refs.checkBoxD.isChecked());

        //Refs.checkBoxC.setEnabled(Refs.debug);
        //Refs.checkBoxD.setEnabled(Refs.debug);
    }

    private static void mainClickListeners(){
        Log.d("Running mainClickListeners()");
        /*Debug.toast("Running mainClickListeners()");*/

        Refs.editTextA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Refs.editTextA.getText().toString().contentEquals(Refs.contextMain.getString(R.string.editText_blank)))
                    Refs.editTextA.setText("");
            }
        });

        Refs.editTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Refs.editTextB.getText().toString().contentEquals(Refs.contextMain.getString(R.string.editText_blank)))
                    Refs.editTextB.setText("");
            }
        });

        Refs.editTextC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Refs.editTextC.getText().toString().contentEquals(Refs.contextMain.getString(R.string.editText_blank)))
                    Refs.editTextC.setText("");
            }
        });
        Refs.checkBoxC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Refs.editTextC.setEnabled(Refs.checkBoxC.isChecked());
            }
        });

        Refs.editTextD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Refs.editTextD.getText().toString().contentEquals(Refs.contextMain.getString(R.string.editText_blank)))
                    Refs.editTextD.setText("");
            }
        });
        Refs.checkBoxD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Refs.editTextD.setEnabled(Refs.checkBoxD.isChecked());
            }
        });
    }

    private static void logClickListeners() {
        Log.d("Running logClickListeners()");
        /*Debug.toast("Running logClickListeners()");*/

        Refs.buttonClearLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Refs.logContent = "";
                Refs.textViewLog.setText(Refs.logContent);
            }
        });

        Refs.buttonCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crashlytics.setBool("forced_crash", true);
                throw new RuntimeException("This is a forced crash.");
            }
        });
    }
}
