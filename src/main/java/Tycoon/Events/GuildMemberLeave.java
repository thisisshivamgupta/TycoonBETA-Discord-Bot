package Tycoon.Events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {

    String[] messages ={
            "We'll miss you 😭 [member]",
            "We'd love to have you back [member]",
            "[member] opps! Your buddy left the party!"
    };

    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        Random rand = new Random();
        int number= rand.nextInt(messages.length);
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0xf48342);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getSystemChannel().sendMessage(join.build()).queue();
    }
}
