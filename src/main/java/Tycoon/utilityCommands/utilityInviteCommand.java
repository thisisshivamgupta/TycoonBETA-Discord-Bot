package Tycoon.utilityCommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class utilityInviteCommand extends Command {

    public utilityInviteCommand(){
        this.name="invite";
        this.help="Creates invite link for you!";
        super.category=new Category("Generates Invite Link!");
    }
    @Override
    protected void execute(CommandEvent commandEvent) {

    }
}
