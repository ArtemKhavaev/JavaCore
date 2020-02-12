package com.domain.lesson27BuilderListenerPrototypeCommand.command;

import java.io.IOException;

public class ConectionsCountCommand  extends ServerCommand{
    public ConectionsCountCommand (MessageServer messageServer){
        super(messageServer);
    }

    @Override
    public void execute() {
        try {
            messageServer.getConnection().sendMessage(new Message("server", String.valueOf(messageServer.getConnectionCount())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
