package Tycoon.utilityCommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class utilityFiterOnOff extends Command {
    public utilityFiterOnOff(){
        this.name="filter";
        this.help="To Maintain the decorum of server!";
        super.category=new Category("Stop Curse-Word!");

    }
    @Override
    protected void execute(CommandEvent commandEvent) {

    }
}
