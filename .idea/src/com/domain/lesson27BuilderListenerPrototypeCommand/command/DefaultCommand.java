package com.domain.lesson27BuilderListenerPrototypeCommand.command;

import java.io.IOException;

public class DefaultCommand extends ServerCommand {
    public DefaultCommand(MessageServer messageServer) {
        super(messageServer);
    }

    @Override
    public void execute() {
        try {
            messageServer.getConnection().sendMessage(new Message("server", "неизвюкоманда"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
