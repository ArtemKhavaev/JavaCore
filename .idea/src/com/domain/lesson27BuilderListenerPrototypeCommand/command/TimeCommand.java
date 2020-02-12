package com.domain.lesson27BuilderListenerPrototypeCommand.command;

import java.io.IOException;
import java.time.LocalDateTime;

public class TimeCommand extends ServerCommand{
    public TimeCommand(MessageServer messageServer){
        super(messageServer);
    }

    @Override
    public void execute() {
        //sendMessage(new Message("server", "сообщение получено"));
        try {
            messageServer.getConnection().sendMessage(new Message("server", LocalDateTime.now().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
