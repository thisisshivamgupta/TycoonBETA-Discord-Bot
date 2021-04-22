package Tycoon.Filter;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Tycoon.commands.FilterMessageOnOff;
import Tycoon.commands.FilterOnOff;

public class Filter extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(Tycoon.commands.FilterOnOff.filterOn) {
            String[] badWords = {"ass","anal", "stfu", "mc", "madharchod", "lauda", "gandu", "fuck", "fucking", "pikina", "bsdk","bitch","bhadwa","chutka","jhat","jhaat","maachuda","gaandmarwa","fuckoff","fuck!","lowda","chutiya"};
            String[] message = event.getMessage().getContentRaw().split(" ");
            for (int i = 0; i < message.length; i++) {
                for (int j = 0; j < badWords.length; j++) {
                    if (message[i].equalsIgnoreCase(badWords[j])) {
                        event.getMessage().delete().queue();
                        if(Tycoon.commands.FilterMessageOnOff.allowed== true) {
                            event.getChannel().sendMessage("Watch Your Vernacular🧨").queue();
                        }
                    }
                }
            }
        }else if ((!Tycoon.commands.FilterOnOff.filterOn)){
            System.out.println("The filter is disabled");

        }
    }
}
