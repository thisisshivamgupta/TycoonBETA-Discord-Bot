package Tycoon.Events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages ={
            "[member] joined. You must construct additional pylons.",
            "Hey! Listen! [member] has joined!",
            "Swoosh. [member] just landed.",
            "Bade Bhaiya is here! [member]",
            "Chintu ke papa Sunte ho, [member] aaye hain!",
            "Hey guys we've [member] with us!"
    };

    public void onGuildMemberJoin(GuildMemberJoinEvent event){

        Random rand = new Random();
        int number= rand.nextInt(messages.length);
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getSystemChannel().sendMessage(join.build()).queue();

        // Add role
        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Guest🤩",true)).complete();

    }




}
