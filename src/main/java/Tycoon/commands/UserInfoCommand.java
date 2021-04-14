package Tycoon.commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Tycoon.tycoonmain.TycoonBETA;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoCommand extends ListenerAdapter {


    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY hh:mm:ss");
        String [] message = e.getMessage().getContentRaw().split(" ");
        if(message.length==1 && message[0].equalsIgnoreCase(TycoonBETA.prefix+"user")){
            e.getChannel().sendMessage("Follow the Format\n`~user [name]`").queue();

        }
        else if(message.length==2 && message[0].equalsIgnoreCase(TycoonBETA.prefix+"user")){
            String userName= message[1];

            User user = e.getGuild().getMembersByName(userName,true).get(0).getUser();
            String avatar = user.getAvatarUrl();
            EmbedBuilder eb =new EmbedBuilder();

            eb.setTitle(userName+"'s info:");
            eb.setColor(Color.green);
            eb.addField("Name",user.getName(),true);
            eb.addField("Online Status: ",e.getGuild().getMembersByName(userName,true).get(0).getOnlineStatus().toString(),true);
            eb.addField("Avatar: ","The Avatar is below! ",true);

            eb.setImage(avatar);
            eb.setFooter("Request was made at "+ formatter.format(date),e.getGuild().getIconUrl());


            e.getChannel().sendMessage(eb.build()).queue();
        }

    }
}
