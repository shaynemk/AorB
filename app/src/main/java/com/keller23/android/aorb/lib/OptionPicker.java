package com.keller23.android.aorb.lib;

import com.keller23.android.aorb.R;
import com.keller23.android.common.utils.Debug;

import java.util.Date;
import java.util.Random;

public class OptionPicker {
    private final Date date = new Date();
    private final Random rand = new Random(date.getTime());
    private boolean a = false,
            b = false,
            c = false,
            d = false;

    private int generate(int options) {
        return rand.nextInt(options) + 1;
    }

    private boolean verifyOptions() {
        // If any of the EditText's are empty or has default text, let the user know.
        if (Refs.editTextA.getText().toString().contentEquals(Refs.activityMain.getString(R.string.editText_blank)) || Refs.editTextA.getText().toString().isEmpty())
            Info.toast(Refs.enterOption + "A");
        else a = true;

        if (Refs.editTextB.getText().toString().contentEquals(Refs.activityMain.getString(R.string.editText_blank)) || Refs.editTextB.getText().toString().isEmpty())
            Info.toast(Refs.enterOption + "B");
        else b = true;

        if (Refs.editTextC.isEnabled()) {
            if (Refs.editTextC.getText().toString().contentEquals(Refs.activityMain.getString(R.string.editText_blank)) || Refs.editTextC.getText().toString().isEmpty())
                Info.toast(Refs.enterOption + "C");
            else c = true;
        } else c = true;

        if (Refs.editTextD.isEnabled()) {
            if (Refs.editTextD.getText().toString().contentEquals(Refs.activityMain.getString(R.string.editText_blank)) || Refs.editTextD.getText().toString().isEmpty())
                Info.toast(Refs.enterOption + "D");
            else d = true;
        } else d = true;

        if (a && b && c && d) return true;
        else return false;
    }

    public void pickOption() {
        if (verifyOptions()) {

            // find out how many options we are generating for.
            int x = 2;
            if (Refs.editTextC.isEnabled()) {
                //Debug.toast("EditTextC is enabled");
                x = 3;
                if (Refs.editTextD.isEnabled()) {
                    //Debug.toast("EditTextD is enabled");
                    x = 4;
                }
            }
            Debug.toast("Generating for (" + x + ") options");


            // generate and decipher
            String result;
            switch (generate(x)) {
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
                    result = Refs.errorPrefix + " in SWITCH";
                    Debug.toast("Switch has hit default case: ERROR.");
            }
            Info.toast(result);
            result = "";
        }
    }
}
