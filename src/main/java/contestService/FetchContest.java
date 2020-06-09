package contestService;

import broadcast.EmbedMessageSender;
import model.ContestList;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import resources.ResourcesValues;
import retrofit2.Call;
import retrofit2.Response;
import serviceGenerator.CListService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class FetchContest {

    ContestLIstService cListService  =  CListService.createService(ContestLIstService.class);
    EmbedMessageSender embededMessageSender;

    public FetchContest(){
        embededMessageSender = new EmbedMessageSender();
    }


    public void getAllContests(MessageChannel channel, int days, String resourceName){

        if(days<=0 || days>7){
            channel.sendMessage("Days should be between 1 to 7").queue();
            return;
        }

        LocalDateTime startTime = LocalDateTime.now(ResourcesValues.GMT);
        LocalDateTime endTime = LocalDateTime.now(ResourcesValues.GMT).plusDays(days);

        getConstrainedContest(channel,startTime,endTime,resourceName,days);

    }

    private void getConstrainedContest(MessageChannel channel, LocalDateTime startTime, LocalDateTime endTime,
                                       String resourceName, int days) {

        Call<ContestList> callSync = cListService.getContests(resourceName,startTime,endTime,ResourcesValues.ORDER_BY_START);
        ContestList contestList ;

        try {
            Response<ContestList> response = callSync.execute();
            contestList = response.body();
            embededMessageSender.sendMessages( channel,contestList.getObjects(),days);

        } catch (Exception ex) { ex.printStackTrace(); }

    }

}