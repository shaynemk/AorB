package com.keller23.android.aorb.init;


import android.view.View;
import com.keller23.android.aorb.R;
import com.keller23.android.aorb.lib.Refs;

public class ClickListeners {

    public static void init(){

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

        if (Refs.checkBoxC.isChecked()) Refs.editTextC.setEnabled(true);
        else Refs.editTextC.setEnabled(false);
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
                if (Refs.checkBoxC.isChecked()) Refs.editTextC.setEnabled(true);
                else if (!Refs.checkBoxC.isChecked()) Refs.editTextC.setEnabled(false);
            }
        });

        if (Refs.checkBoxD.isChecked()) Refs.editTextC.setEnabled(true);
        else Refs.editTextD.setEnabled(false);
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
                if (Refs.checkBoxD.isChecked()) Refs.editTextD.setEnabled(true);
                else if (!Refs.checkBoxD.isChecked()) Refs.editTextD.setEnabled(false);
            }
        });
    }
}
