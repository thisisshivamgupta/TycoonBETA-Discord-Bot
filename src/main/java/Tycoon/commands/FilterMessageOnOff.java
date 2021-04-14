package Tycoon.commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Tycoon.tycoonmain.TycoonBETA;

public class FilterMessageOnOff extends ListenerAdapter {


    public static boolean allowed= true;
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase(TycoonBETA.prefix + "filtermessage")&& FilterOnOff.filterOn==true) {
            if (event.getMessage().getContentRaw().equalsIgnoreCase(TycoonBETA.prefix + "filtermessage") && allowed == true) {
                event.getChannel().sendMessage("Filter response has been disabled.🚫").queue();
                System.out.println("Filter messsage has been disabled!🚫");
                allowed = false;
            } else if (event.getMessage().getContentRaw().equalsIgnoreCase(TycoonBETA.prefix + "filtermessage") && allowed == false) {

                event.getChannel().sendMessage("Filter response has been enabled! ✅").queue();
                System.out.println("Flter messsage has been enabled! ✅");
                allowed = true;
            }
        }else if(event.getMessage().getContentRaw().equalsIgnoreCase(TycoonBETA.prefix + "filtermessage") && FilterOnOff.filterOn==false){
            event.getChannel().sendMessage("You can not toggle filter response while the filter is `OFF`.\nTo turn it on use `"+ TycoonBETA.prefix+ "togglefilter`").queue();


        }
    }
}
