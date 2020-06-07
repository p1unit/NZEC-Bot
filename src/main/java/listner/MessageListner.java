package listner;

import contestService.FetchContest;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MessageListner extends ListenerAdapter {

    FetchContest fetchContest;

    public MessageListner(){
        fetchContest = new FetchContest();
    }

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        if(event.getMessage().getAuthor().isBot())
            return;

        String[] command = event.getMessage().getContentRaw().split("_");

        if(!command[0].equals("$ contest")){
            event.getChannel().sendMessage("Unrecognised Command").queue();
            return;
        }

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