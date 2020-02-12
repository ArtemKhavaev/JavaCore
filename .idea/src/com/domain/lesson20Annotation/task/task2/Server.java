package com.domain.lesson20Annotation.task.task2;

@InitClass
public class Server {
    @InitProp
    private ServerSettings settings;

    @RunMethod
    public void start(){
        System.out.println("Server is running on..."
                + settings.getIp() + " " + settings.getPort());
    }
}
