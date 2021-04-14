package Tycoon.Events;

import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){

        if(event.getReactionEmote().getName().equals("❎") && !event.getMember().getUser().equals(event.getJDA().getSelfUser())){
            if(event.getMember().getUser().equals(event.getChannel().getMessageById(event.getMessageId()).complete().getAuthor())){
                // If it's The Author
                event.getChannel().getMessageById(event.getMessageId()).complete().delete().queue();

            }
            else{
                // If it's not the author
                event.getReaction().removeReaction().queue();



            }



        }



    }


}
