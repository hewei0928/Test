package com.design.pattern.command;

/**
 * Created by Administrator on 2017/7/6.
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void startCommand(){
        command.execute();
    }
}
