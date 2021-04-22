package Tycoon.utilityCommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class utilityClear extends Command {
    public utilityClear(){
        this.name="clear";
        this.aliases=new String[]{"del"};
        this.help="To delete Messages.";
        super.category=new Category("Delete Message Command");
    }
    @Override
    protected void execute(CommandEvent commandEvent) {

    }
}
