package listner;

import broadcast.EmbedMessageSender;
import contestService.FetchContest;
import model.ContestList;
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
    EmbedMessageSender embedMessageSender;

    public MessageListner(){
        fetchContest = new FetchContest();
        embedMessageSender = new EmbedMessageSender();
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
        execute(command, messageChannel);
    }



    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        if(event.getMessage().getAuthor().isBot() )
            return;

        String[] command = event.getMessage().getContentRaw().split("-");

        if(!command[0].equals("$ contest") || !event.getChannel().getName().equals(ResourcesValues.CHANNEL_NAME)){
            return;
        }

        MessageChannel messageChannel = event.getChannel();
        execute(command,messageChannel);

    }

    private void execute(String[] command, MessageChannel channel){

        int days = command.length==1 ? 1 : Integer.parseInt(command[1]);

        if(days<=0 || days>7){
            channel.sendMessage("Days should be between 1 to 7").queue();
            return;
        }

        ContestList contestList = callApi(command);
        embedMessageSender.sendMessages( channel,contestList.getObjects(),days);

    }

    private ContestList callApi(String[] command ){

        switch (command.length){
            case 1:
                return fetchContest.getAllContests(1,null);
            case 2:
                return fetchContest.getAllContests(Integer.parseInt(command[1]),null);
            case 3:
                return fetchContest.getAllContests(Integer.parseInt(command[1]),command[2]);
        }

        return null;
    }
}