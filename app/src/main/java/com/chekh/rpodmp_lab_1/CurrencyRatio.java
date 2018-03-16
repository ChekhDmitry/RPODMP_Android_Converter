package com.chekh.rpodmp_lab_1;

/**
 * Created by dima on 03.03.2018.
 */

public enum CurrencyRatio {

    USA_DOLLAR_TO_EURO(0.93),
    USA_DOLLAR_TO_BEL_RUBLE(1.93),
    USA_DOLLAR_TO_RUS_RUBLE(56.85);

    private double value;

    CurrencyRatio(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
