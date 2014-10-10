package com.keller23.android.aorb.lib;

import java.util.Random;

public class OptionPicker {

    public int generate(int options) {

        Random rand = new Random();
        return rand.nextInt(options) + 1;
    }

    /*public boolean verify() {
        return true;
    }*/
}
