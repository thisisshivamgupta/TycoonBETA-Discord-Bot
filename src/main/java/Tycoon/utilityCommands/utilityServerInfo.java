package Tycoon.utilityCommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;
import java.util.Arrays;

public class utilityServerInfo extends Command {

    public utilityServerInfo(){
        this.name="serverinfo";
        this.aliases=new String[]{"server"};
        super.category= new Category("Server Info Command");
        this.help="Gives info about the server!";
    }
    protected void execute(CommandEvent e){
        String[]members = new String[e.getGuild().getMembers().size()];
        for (int i =0;i<e.getGuild().getMembers().size();i++){
            members[i]= e.getGuild().getMembers().get(i).getEffectiveName();

        }


        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.red);
        eb.setAuthor(e.getGuild().getName());
        eb.setThumbnail(e.getGuild().getIconUrl());
        eb.addField("Members Count:",Integer.toString(e.getGuild().getMembers().size()),true);
        eb.setDescription("**Members:** \n"+ Arrays.toString(members)+ "\n **Invite Link:** \n"+"https://discord.gg/Y4TbPxzraM");
        eb.addField("SERVER OWNER: ",e.getGuild().getOwner().getEffectiveName(),true);

        e.getChannel().sendMessage(eb.build()).queue();

    }

}
