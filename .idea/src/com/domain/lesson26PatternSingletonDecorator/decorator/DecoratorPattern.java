package com.domain.lesson26PatternSingletonDecorator.decorator;

import java.time.LocalDateTime;

public class DecoratorPattern {
    public static void main(String[] args) {
        Ilogger logger = new Logger();
        logger.write("log info");

        Ilogger datelogger = new DateLogger(logger);
        datelogger.write("log info");

        Ilogger codeLogger = new CodeLogger (new DateLogger(new Logger()));
        codeLogger.write("log info");



    }
}

interface Ilogger {
    public void write (String data);

}

class Logger implements Ilogger {// декорируемый класс и класс декоратор должны иметь общ. интерфейс

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
// базовый класс- декоратор
class LoggerDecorator implements Ilogger{// класс -декоратор должен иметь  тот же интерфейс что декорируемый класс
    private Ilogger logger;
    public LoggerDecorator (Ilogger logger){
        this.logger = logger;
    }
    @Override
    public void write(String data) {
        logger.write(data);
        System.out.println(data);
    }
}

// класс - декоратор
class DateLogger extends LoggerDecorator{// наследуется от базового декоратора
    public DateLogger(Ilogger logger){
        super(logger);
    }
    @Override
    public void write(String data){
        String newData = data + "date: " + LocalDateTime.now();
        super.write(newData);
    }
}
// еще класс - декоратор
class CodeLogger extends LoggerDecorator{// наследуется от базового декоратора
    public CodeLogger(Ilogger logger){
        super(logger);
    }
    @Override
    public void write(String data){
        String newData = data + "date: " + " " + Math.random()*10;
        super.write(newData);

    }
}