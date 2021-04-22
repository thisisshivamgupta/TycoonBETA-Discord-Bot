package Tycoon.utilityCommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class utilityCalculate extends Command {
    public utilityCalculate(){
     super.name="cal";
     super.help="You can [add/subtract] two numbers(int).";
     super.category=new Category("Basic Calculator Command!");

    }
    @Override
    protected void execute(CommandEvent commandEvent) {

    }
}
