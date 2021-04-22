package Tycoon.utilityCommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class utilityUserInfo extends Command {
    private EventWaiter waiter;

    public utilityUserInfo(EventWaiter waiter){
        super.name="UserInfo";
        super.help="Gives you the user information!";
        super.aliases=new String[]{"userinfo"};
        super.category=new Category("USER INFO COMMAND");
        super.cooldown=10;
        super.arguments="[name]";
        this.waiter =waiter;
    }
    @Override
    protected void execute(CommandEvent event) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(event.getArgs().isEmpty()) {
            event.reply("Okay! Please enter the name of user, like @shivam.");
            waiter.waitForEvent(GuildMessageReceivedEvent.class, e -> e.getAuthor().equals(event.getAuthor()) && e.getChannel().equals(event.getChannel()), e -> {
                try {
                    Member name = e.getMessage().getMentionedMembers().get(0);
                    EmbedBuilder eb = new EmbedBuilder()
                            .setColor(Color.magenta)
                            .setThumbnail("https://w7.pngwing.com/pngs/377/24/png-transparent-user-interface-design-flat-design-design.png")
                            .setDescription(name.getUser().getName() + " joined on " + name.getJoinDate().format(fmt) + " :clock:")
                            .addField("Nickname: ", name.getNickname() == null ? "No Nickname" : name.getNickname(), true)
                            .addField("Status: ", name.getOnlineStatus().toString(), true)
                            .addField("Game: ", displayGameInfo(name), true)
                            .addField("Roles Assigned: ", getRolesAsstring(name.getRoles()), true)


                            .setAuthor("Information on " + name.getUser().getName(), "https://github.com/", name.getUser().getAvatarUrl());
                    event.reply(eb.build());
                    event.reply(event.getAuthor().getAsMention() + " there you go!");

                } catch (IndexOutOfBoundsException ex) {
                    System.out.println("Exception Occurred!");
                    event.reply("Provide the user name as mention! [@username]");
                }
            }, 10, TimeUnit.SECONDS, () -> event.reply("You did not give the name! Try it again!"));
        }else{
            try {
                Member name = event.getMessage().getMentionedMembers().get(0);
                EmbedBuilder eb = new EmbedBuilder()
                        .setColor(Color.magenta)
                        .setThumbnail("https://w7.pngwing.com/pngs/377/24/png-transparent-user-interface-design-flat-design-design.png")
                        .setDescription(name.getUser().getName() + " joined on " + name.getJoinDate().format(fmt) + " :clock:")
                        .addField("Nickname: ", name.getNickname() == null ? "No Nickname" : name.getNickname(), true)
                        .addField("Status: ", name.getOnlineStatus().toString(), true)
                        .addField("Game: ", displayGameInfo(name), true)
                        .addField("Roles Assigned: ", getRolesAsstring(name.getRoles()), true)


                        .setAuthor("Information on " + name.getUser().getName(), "https://github.com/", name.getUser().getAvatarUrl());
                event.reply(eb.build());
                event.reply(event.getAuthor().getAsMention() + " there you go!");

            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Exception Occurred!");
                event.reply("Provide the user name as mention! [@username]");
            }


        }










    }

    private String displayGameInfo(Member name){
        try {
            String game = name.getGame().getName();
            return "Playing game: "+ game;
        }catch (NullPointerException exx){
            return "No game is being played!";

        }
    }
    private String getRolesAsstring(List roleslist){
        String roles="";
        if(!roleslist.isEmpty()){
            Role tempRole= (Role) roleslist.get(0);
            roles = tempRole.getName();

            for (int i =1; i<roleslist.size();i++) {
                tempRole =(Role) roleslist.get(i);
                roles = roles + ", "+tempRole.getName();
            }

        }else{
            roles="No Roles!";

        }

        return roles;

    }
}
