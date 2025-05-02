package com.satz.annotation;

public class DummyModelImpl implements IDummyModel{

    @Override
    @MyAnnotation(name="DefaultMethod")
    public String getDefaultMethod() {
        return IDummyModel.super.getDefaultMethod();
    }

    @Override
    @MyAnnotation(name="NonDefaultMethod")
    public String getNonDefaultMethod() {
        return "";
    }
}
