package com.mycompany.ex02;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private final List<Command> commands;

    public MacroCommand() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
