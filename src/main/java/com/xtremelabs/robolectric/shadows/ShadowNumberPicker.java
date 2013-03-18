package com.xtremelabs.robolectric.shadows;

import android.widget.NumberPicker;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;


// todo test me!
@Implements(NumberPicker.class)
public class ShadowNumberPicker extends ShadowLinearLayout {
    private int value;
    private String[] displayedValues;
    private int minValue;
    private int maxValue;

    @Implementation
    public void setValue(int value) {
        this.value = value;
    }

    @Implementation
    public int getValue() {
        return value;
    }

    @Implementation
    public void setDisplayedValues(String[] displayedValues) {
        if (displayedValues.length != (maxValue - minValue) + 1) {
            throw new RuntimeException("Displayed values should fit into range min and max values");
        }
        this.displayedValues = displayedValues;
    }

    @Implementation
    public String[] getDisplayedValues() {
        return displayedValues;
    }

    @Implementation
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    @Implementation
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
