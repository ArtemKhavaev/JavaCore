package com.domain.lesson20Annotation;

import java.lang.annotation.*;




    //@Target(ElementType.TYPE) аннотация для классов
    //@Target(ElementType.METHOD)аннотация для методов
    //@Target(ElementType.CONSTRUCTOR)аннотация для конструкторов
    //@Target(ElementType.FIELD)аннотация для полей
    //@Target(ElementType.PARAMETER)аннотация для параметров метода
    //@Target(ElementType.LOCAL_VARIABLE)аннотация для локальных переменных
    //@Target(ElementType.PACKAGE)аннотация для пакета
    //@Target(ElementType.METHOD, ElementType.CONSTRUCTOR ) ссоставная аннотация для метода и конструктора
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)//аннотацию м.б. использована во время выполнения программы
   // @Retention(RetentionPolicy.CLASS)//аннотацию м.б. использована во время компиляции (в .class-файлах)
   // @Retention(RetentionPolicy.SOURCE)//аннотацию м.б. использована в исходниках (в .java -файлах)
    public @interface MethodInfo {
        // строки, примитивы, перечисления(Enum)
        String author();// д.б. определить обязательно
        int version () default 1;// со значением по умолчанию
    }
    @Inherited // аннотация передается для использования всем потомкам
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ClassInfo{}
//    @ClassInfo
//    class Parent {}
//    class Child extends Parent{}

 //   @Target(ElementType.PARAMETER)
  //  @Retention(RetentionPolicy.RUNTIME)
  //  @interface


