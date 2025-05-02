package com.satz.annotation;

public interface IDummyModel {

    default String getDefaultMethod(){
        return "getGsi9";
    }

    String getNonDefaultMethod();
}
