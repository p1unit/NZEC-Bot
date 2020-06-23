package listner;

import contestService.FetchContest;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import resources.ResourcesValues;

import javax.annotation.Nonnull;

public class MessageListner extends ListenerAdapter {

    FetchContest fetchContest;

    public MessageListner(){
        fetchContest = new FetchContest();
    }


    @Override
    public void onPrivateMessageReceived(@Nonnull PrivateMessageReceivedEvent event) {

        if(event.getAuthor().isBot())
            return;

        String[] command = event.getMessage().getContentRaw().split("-");

        if(!command[0].equals("$ contest") ){
            return;
        }

        MessageChannel messageChannel = event.getChannel();
        callApi(command, messageChannel);
    }



    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        if(event.getMessage().getAuthor().isBot() )
            return;

        String[] command = event.getMessage().getContentRaw().split("-");

        if(!command[0].equals("$ contest") || !event.getChannel().getId().equals(ResourcesValues.CHANNEL_ID)){
            return;
        }

        MessageChannel messageChannel = event.getChannel();
        callApi(command,messageChannel);

    }

    private void callApi(String[] command, MessageChannel event){

        switch (command.length){
            case 1:
                fetchContest.getAllContests(event,1,null);
                break;
            case 2:
                fetchContest.getAllContests(event,Integer.parseInt(command[1]),null);
                break;
            case 3:
                fetchContest.getAllContests(event,Integer.parseInt(command[1]),command[2]);
                break;
        }

    }
}