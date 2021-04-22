package Tycoon.tycoonmain;

import Tycoon.utilityCommands.*;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import Tycoon.Events.*;
import Tycoon.Filter.Filter;
import Tycoon.commands.*;

import javax.security.auth.login.LoginException;

public class TycoonBETA {
public static JDA jda;
public static String prefix = "~";
//main method
public static void main(String[] args) throws LoginException {
    jda= new JDABuilder(AccountType.BOT).setToken("ODI4ODg2MTQ1NTE3NjE3MTcz.YGwGYQ.tjvXNHgp6xCQXUNaOcmilM03GDE").build();
    jda.getPresence().setStatus(OnlineStatus.ONLINE);
    jda.addEventListener(new Clear());
    jda.addEventListener(new GuildMemberJoin());
    jda.addEventListener(new GuildMemberLeave());
    jda.addEventListener(new HelloReply());
    jda.addEventListener(new CategoryCreate());
    jda.addEventListener(new Calculate());
    jda.addEventListener(new InviteCommand());
    jda.addEventListener(new Filter());
    jda.addEventListener(new FilterOnOff());
    jda.addEventListener(new FilterMessageOnOff());
    jda.addEventListener(new ChannelCreate());

    EventWaiter waiter = new EventWaiter();
    CommandClientBuilder builder =new CommandClientBuilder();
    builder.setOwnerId("828886145517617173");
    builder.setPrefix("~");
    builder.setHelpWord("help");
    builder.setAlternativePrefix("#");
    builder.useHelpBuilder(true);

    builder.addCommand(new utilityServerInfo());
    builder.addCommand(new utilityClear());
    builder.addCommand(new utilityFiterOnOff());
    builder.addCommand(new utilityFilterMessage());
    builder.addCommand(new utilityInviteCommand());
    builder.addCommand(new utilityUserInfo(waiter));
    builder.addCommand(new utilityCalculate());





    CommandClient client =  builder.build();
    jda.addEventListener(client);
    jda.addEventListener(waiter);










    /*jda.addEventListener(new GuildMessageReceived());
    jda.addEventListener(new GuildMessageReactionAdd());
*/




}
}





