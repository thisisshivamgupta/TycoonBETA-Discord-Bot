package Tycoon.tycoonmain;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import Tycoon.Events.*;
import Tycoon.Filter.Filter;
import Tycoon.commands.*;

import javax.security.auth.login.LoginException;

public class TycoonBETA {
public static JDA jda;
public static String prefix = "~";
//main method
public static void main(String[] args) throws LoginException {
    jda= new JDABuilder(AccountType.BOT).setToken("PUT_YOUR_APPS_TOKEN_HERE").build();
    jda.getPresence().setStatus(OnlineStatus.ONLINE);
    jda.getPresence().setGame(Game.playing("~info"));
    jda.addEventListener(new Commands());
    jda.addEventListener(new Clear());
    jda.addEventListener(new GuildMemberJoin());
    jda.addEventListener(new GuildMemberLeave());
    jda.addEventListener(new HelloReply());
    jda.addEventListener(new CategoryCreate());
    jda.addEventListener(new Calculate());
    jda.addEventListener(new InviteCommand());
    jda.addEventListener(new UserInfoCommand());
    jda.addEventListener(new Filter());
    jda.addEventListener(new FilterOnOff());
    jda.addEventListener(new FilterMessageOnOff());
    jda.addEventListener(new ChannelCreate());










    /*jda.addEventListener(new GuildMessageReceived());
    jda.addEventListener(new GuildMessageReactionAdd());
*/




}
}





