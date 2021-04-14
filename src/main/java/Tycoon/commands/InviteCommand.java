package Tycoon.commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Tycoon.tycoonmain.TycoonBETA;

public class InviteCommand extends ListenerAdapter {
    int time = 3600;
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String [] message = e.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase(TycoonBETA.prefix+"invite")&& message.length==1){
            e.getChannel().sendMessage("Follow the format\n`~invite [create]`").queue();
        }
        else if(message[0].equalsIgnoreCase(TycoonBETA.prefix+"invite")&&message[1].equalsIgnoreCase("create") && message.length>=2){

            e.getChannel().sendMessage("Hey! "+e.getAuthor().getName()+", You've created an invite link!\nEnjoy!\n").queue();
            e.getChannel().sendMessage("Share the link ✂ " + e.getChannel().createInvite().setMaxAge(time).complete().getURL()+"\nInvite Expires in "+ (time/60)+ " Minutes!").queue();
        }
    }
}
