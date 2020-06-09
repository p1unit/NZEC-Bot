package broadcast;

import contestService.FetchContest;
import net.dv8tion.jda.api.entities.TextChannel;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import singletonBot.BotApi;
import java.util.List;

public class ContestAnnoucment implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        TextChannel channel = BotApi.getInstance().
                getTextChannelById(System.getenv("CONTEST-CHANNEL"));

        new FetchContest().getAllContests(channel,1,null);
    }
}