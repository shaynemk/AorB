package com.keller23.android.aorb;

/**
 * Created by skeller on 10/2/14.
 */

import java.util.Random;

public class OptionPicker {

    public int  choose(int options) {

        Random rand = new Random();
        return rand.nextInt(options) + 1;
    }
}
