package Tycoon.utilityCommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class utilityFilterMessage extends Command {
    public utilityFilterMessage(){
        this.name="filmsg";
        this.help="Do not send curse alert message!";
        super.category=new Category("Stops sending curse alert messages!");
    }
    @Override
    protected void execute(CommandEvent commandEvent) {

    }
}
