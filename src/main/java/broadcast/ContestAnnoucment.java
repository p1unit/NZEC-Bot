package broadcast;

import contestService.FetchContest;
import model.ContestList;
import net.dv8tion.jda.api.entities.TextChannel;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import resources.ResourcesValues;
import singletonBot.BotApi;

import java.awt.*;
import java.util.List;

public class ContestAnnoucment implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<TextChannel> channels = BotApi.getInstance().
                getTextChannelsByName(ResourcesValues.CHANNEL_NAME,true);

        ContestList contestList =  new FetchContest().getAllContests(1,null);

        EmbedMessageSender embedMessageSender = new EmbedMessageSender();

        for(TextChannel chnl:channels){
            embedMessageSender.sendMessages( chnl,contestList.getObjects(),1);
        }
    }
}