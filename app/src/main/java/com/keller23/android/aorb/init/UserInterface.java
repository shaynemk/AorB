package com.keller23.android.aorb.init;


import android.view.View;

import com.keller23.android.aorb.R;
import com.keller23.android.aorb.lib.Debug;
import com.keller23.android.aorb.lib.Refs;

public class UserInterface {

    public static void init() {
        Debug.toast("Running UI.init()");
        ClickListeners();
        UIElements();
    }

    public static void UIElements() {
        Refs.editTextC.setEnabled(Refs.checkBoxC.isChecked());
        Refs.editTextD.setEnabled(Refs.checkBoxD.isChecked());

        //Refs.checkBoxC.setEnabled(Refs.debug);
        //Refs.checkBoxD.setEnabled(Refs.debug);
    }

    public static void ClickListeners(){
        Debug.toast("Running ClickListeners()");

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
}
