package Tycoon.Events;

import net.dv8tion.jda.core.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Objects;

public class ChannelCreate extends ListenerAdapter {

    @Override
    public void onTextChannelCreate(TextChannelCreateEvent event) {
        Objects.requireNonNull(event.getGuild().getSystemChannel()).sendMessage(event.getChannel().getAsMention()+" CHANNEL HAS BEEN CREATED!!").queue();
    }
}
