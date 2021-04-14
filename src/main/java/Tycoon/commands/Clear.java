package Tycoon.commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Tycoon.tycoonmain.TycoonBETA;

import java.util.List;

public class Clear extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(TycoonBETA.prefix + "clear")) {

            if (args.length < 2) {
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(0xff3923);
                usage.setTitle("Specify the amount to delete!");
                usage.setDescription("Usage: `"+ TycoonBETA.prefix+"clear[# of messages]`");
                event.getChannel().sendMessage(usage.build()).queue();

            } else {

                try {
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();
                    EmbedBuilder success= new EmbedBuilder();
                    success.setColor(0xff3923);
                    success.setTitle("Successfully Deleted "+ args[1]+".");
                    success.setDescription("Usage: `"+ TycoonBETA.prefix+"clear[# of messages]`");
                    event.getChannel().sendMessage(success.build()).queue();


                } catch (IllegalArgumentException e) {
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                        //Too many messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("🔴 Too many messages selected!");
                        error.setDescription("Between 1-100 messages can be deleted at a time.");
                        event.getChannel().sendMessage(error.build()).queue();

                    } else {
                        // Messages too old to delete
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("🔴 Selected messages Are older than two weeks");
                        error.setDescription("Between 1-100 messages can be deleted at a time.");
                        event.getChannel().sendMessage(error.build()).queue();

                    }


                }
            }
        }
    }
}
