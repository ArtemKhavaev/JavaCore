package com.domain.lesson26PatternSingletonDecorator.singleton;


// ленивая (отложенная) реализация -не подходит для многопоточной среды (т.к. у каждого потока бует своя переменная)
public class Singleton {
    private static Singleton instance;
    // закрываем возможность создания объектов вне класса (делаем конструктор private)
    // создаем статическую переменную instance
    private Singleton(){
    }

    public static Singleton getInstance(){// метод создающий переменную instance в одном экземпляре
        if (instance == null) {// проверка был ли создан объект
            instance = new Singleton();
        }
        return instance;

    }
}

// thread- safe Singleton (так себе вариант по производительности, тк. происходит постоянная синхронизация и блокировка всего метода)
class Singleton2 {
    private static Singleton2 instance;
    // закрываем возможность создания объектов вне класса (делаем конструктор private)
    // создаем статическую переменную instance
    private Singleton2(){
    }

    public static synchronized Singleton2 getInstance(){// метод создающий переменную instance в одном экземпляре
        if (instance == null) {// проверка был ли создан объект
            instance = new Singleton2();
        }
        return instance;

    }
}

// thread- safe Singleton (более производительный вариант) если производная создана то синхронизация заблокирует др. поток один раз
class Singleton3 {
    private static volatile Singleton3 instance;
    // закрываем возможность создания объектов вне класса (делаем конструктор private)
    // создаем статическую переменную instance
    private Singleton3(){
    }

    public static  Singleton3 getInstance(){// метод создающий переменную instance в одном экземпляре
        Singleton3 local = instance;
        if (local == null) {// проверка был ли создан объект
            synchronized (Singleton3.class){
                local = instance;
                if (local == null){
                    instance = local = new Singleton3();
                }
            }

        }
        return instance;
    }
}


// реализация не явл. ленивой, тк объект создается изначально, а не через вызов метода
class Singleton4 {
    public static class SingletonInst{
        private static final Singleton4 SINGLETON_INSTANCE = new Singleton4();
        }

        private Singleton4(){}

        public static Singleton4 getInstance(){
        return SingletonInst.SINGLETON_INSTANCE;
        }


}