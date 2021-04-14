package Tycoon.Events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;


public class HelloReply extends ListenerAdapter {
    String[] messages ={
            "How are you doing?💤",
            "What's your plan for today?",
            "How is your quarantine😆 going on?",
            "What's the time now?🕐"
    };
    String[] greet ={
            "Namaste ",
            "Hey ",
            "Wadakam ",
            "Hey, yo yo!"
    };

public void onGuildMessageReceived(GuildMessageReceivedEvent event){

    String messageSent = event.getMessage().getContentRaw();
    String name = event.getMember().getUser().getAsMention();
    Random ran = new Random();
    Random rand = new Random();

    int number = ran.nextInt(messages.length);
    int number2 = rand.nextInt(greet.length);
    if(messageSent.equalsIgnoreCase("hello") || messageSent.equalsIgnoreCase("hi")||messageSent.equalsIgnoreCase("hey")||messageSent.equalsIgnoreCase("yo")||messageSent.equalsIgnoreCase("heyy")){
          event.getChannel().sendMessage(greet[number2]+ name +".\n"+ messages[number]).queue();
    }
}

}
