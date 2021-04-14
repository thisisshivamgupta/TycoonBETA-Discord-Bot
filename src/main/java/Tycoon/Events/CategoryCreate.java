package Tycoon.Events;

import net.dv8tion.jda.core.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Objects;

public class CategoryCreate extends ListenerAdapter {

    @Override
    public void onCategoryCreate(CategoryCreateEvent event) {


        Objects.requireNonNull(event.getGuild().getSystemChannel()).sendMessage(event.getCategory().getName()+" CATEGORY HAS BEEN CREATED!!").queue();
    }
}
