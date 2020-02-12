package com.domain.lesson20Annotation.task.task2;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
/*Пройтись по сету и проверить есть ли аннотация(initClass),
если она есть - тогда этот объект создать.

Чтобы создать сервер нужны настройки сервера (они у сервера в конструкторе)
Настройки настроекСервера взять с файла.
Для сервера инициализировать(=создать, остальные оставить дефолтными)
только те настройки, отмеченные аннтоацией initProp

По итогу создали сервер с объектом настроек (у объекта настройки из файла),
а дальше проверяем аннотации методов сервера, если есть RunMethod, то этот метод вызываем,
а остальные игнорируем
Объекты создавать не руками, а с помощью рефлексии(Invoke)*/
public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Set<Class> classes = new HashSet<>();
        classes.add(ServerSettings.class);
        classes.add(Server.class);
        Container container = new Container(classes);
        container.init();

    }
}
