package com.domain.lesson14IOSerialization.serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LaunchStatistic implements Serializable {
    private int launchCount;
    private LocalDateTime lastLaunch;
    private String user;
    transient private String name = "LaunchStatistic";// не будет сериализован -transient
    // уникальный идентификатор версии сериализованного класса, записывается в поток при сериализации
    // при десериализации значение этого поля сравнивается с имеющимся у локального класса
    private static final long serialVersionUID = 1L;

    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;
    }
    public void update(){
        launchCount ++;
        lastLaunch = LocalDateTime.now();
         user = System.getProperty("user.name");
    }

    @Override
    public String toString() {
        return "LaunchStatistic{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
class SomeClass extends LaunchStatistic{

}