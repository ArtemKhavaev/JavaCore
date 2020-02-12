package com.domain.lesson20Annotation.task;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class cls = myClass.getClass();
        Field[] fields = cls.getFields();
        for(Field field:fields){
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations == null) System.out.println(Arrays.toString(annotations));
        }


    }
}
