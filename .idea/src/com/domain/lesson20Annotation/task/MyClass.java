package com.domain.lesson20Annotation.task;

public class MyClass {
    @Exclude
    String string;

    int var;

    public MyClass() {
        this.string = "string";
        this.var = 1;
    }
}
