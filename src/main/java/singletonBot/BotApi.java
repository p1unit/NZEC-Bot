package singletonBot;

import listner.MessageListner;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import resources.ResourcesValues;

import javax.security.auth.login.LoginException;

public class BotApi {

    static JDA jdaApi ;

    private BotApi(){
        try {
            jdaApi = JDABuilder.createDefault(ResourcesValues.DISCORD_BOT_TOKEN).build();
            jdaApi.addEventListener(new MessageListner());
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static JDA getInstance() {
        if(jdaApi==null) new BotApi();
        return jdaApi;
    }
}