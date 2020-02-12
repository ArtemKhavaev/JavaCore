package com.domain.lesson19Reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLession {
    static {
        if (System.getSecurityManager() == null){ //SecurityManager -не дает доступ к приватным переменным выключая setAccessible(true);
            System.setSecurityManager(new SecurityManager());
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // reflection API  класс  Class
        System.out.println(String.class);
        System.out.println(int.class);
        System.out.println(TextMessage.class);


        TextMessage textMessage = new TextMessage("Срочно", "Провести совещание");
        System.out.println(textMessage.getClass());

        Class cls = textMessage.getClass();// ссылка на класс TextMassage

        System.out.println(cls.getName());// возвращает имя класса
        // возвращает интерфейсы которые имплементирует класс
        System.out.println(Arrays.toString(cls.getInterfaces()));
        // возвращает родительский класс
        System.out.println(cls.getSuperclass().getSuperclass());
        // доступ к компонентам класса
        Class<TextMessage> textMessageClass = TextMessage.class;
        // доступ к полям класса
        Field[] fields = textMessageClass.getFields();//возвращает все публичные поля(включая родительские)
        System.out.println(Arrays.toString(fields));
        Field[] declaredFields = textMessageClass.getDeclaredFields();//возвращает все  поля (private protected)
        System.out.println(Arrays.toString(declaredFields));
        // доступ к методам
        Method[] methods = textMessageClass.getMethods();//возвращает все публичные методы(включая родительские)
        System.out.println(Arrays.toString(methods));
        Method[] declaredMethods = textMessageClass.getDeclaredMethods();//возвращает все  методы (private protected)
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструкторам
        Constructor[] declaredConstructors = textMessageClass.getDeclaredConstructors();//возвращает все  конструкторы (private protected)
        System.out.println(Arrays.toString(declaredConstructors));
        // доступ  к конкретному полю /методу
        Field field = textMessageClass.getDeclaredField("text");
        System.out.println(field.getType());//>>String
        field.setAccessible(true);// разрешает доступ к приватным полям
        System.out.println(field.get(textMessage));// вернет значение поля для конкретного объекта (если поле public, иначе IllegalAccessException)
        field.set(textMessage, "Новое сообщение");// установит значение поля для конкретного объекта (если поле public, иначе IllegalAccessException)


        Method method = textMessageClass.getDeclaredMethod("getMessageInfo");
        method.setAccessible(true);
        String messageResult = (String) method.invoke(textMessage);
        System.out.println("getMessageInfo "+ messageResult);

        Method printTitleMethod = textMessageClass.getSuperclass().getDeclaredMethod("printTitle", String.class);
        printTitleMethod.invoke(textMessage, "printTitleMethod");

        Constructor<TextMessage> tmConstructor = textMessageClass.getDeclaredConstructor(String.class, String.class);
        // создание объекта  через newInstance()
        TextMessage message = tmConstructor.newInstance("Reflect Message", "Obj Created");
        message.printTitle();

        // опеределение модификатора доступа
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());
        System.out.println("is 'text' private" + isPrivate);












    }
}
