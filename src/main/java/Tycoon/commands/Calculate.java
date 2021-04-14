package Tycoon.commands;

import Tycoon.tycoonmain.TycoonBETA;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Calculate extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        String [] message = e.getMessage().getContentRaw().split(" ");


        if(message[0].equalsIgnoreCase(TycoonBETA.prefix +"calculate") && message.length<3){
            e.getChannel().sendMessage("Follow the format.\n`~calculate [add/sub] [First number: x] [Second number: y]`").queue();
        }
        else if(message[0].equalsIgnoreCase(TycoonBETA.prefix +"calculate") && message[1].equalsIgnoreCase("add")){
            int x= Integer.parseInt(message[2]);
            int y=Integer.parseInt(message[3]);

            e.getChannel().sendMessage("This is a `Addition` command!").queue();
           e.getChannel().sendMessage("Your result of addition is "+ (x+y)).queue();
       }
       else if(message[0].equalsIgnoreCase(TycoonBETA.prefix +"calculate") && message[1].equalsIgnoreCase("Sub")){
            int x= Integer.parseInt(message[2]);
            int y=Integer.parseInt(message[3]);

            e.getChannel().sendMessage("This is a `Subtraction` command!").queue();
            e.getChannel().sendMessage("Your result of subtraction is "+ (x-y)).queue();
       }
    }
}
