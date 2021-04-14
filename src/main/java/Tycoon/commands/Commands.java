package Tycoon.commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Tycoon.tycoonmain.TycoonBETA;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(TycoonBETA.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Tycoon's Server Information");
            info.setDescription("I'm Here To help!\nTell me how can I help you!\n\n     `~info `  --    To get Information\n       `~clear x`  --    To clear Messages, where `x` is number of messages!");

            info.setColor(0xf45646);
            info.setFooter("\nCreated by thisisshivamgupta", event.getMember().getUser().getAvatarUrl());
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
           // info.clear();
        }

    }
}
