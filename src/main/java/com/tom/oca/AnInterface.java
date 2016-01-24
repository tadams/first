package com.tom.oca;

public interface AnInterface {

//    static final String CONST = calcConstant();

    default  String calcConstant() {
        return "TheValue";
    }

}
