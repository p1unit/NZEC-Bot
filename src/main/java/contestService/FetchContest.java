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


    public ContestList getAllContests( int days, String resourceName){

        LocalDateTime startTime = LocalDateTime.now(ResourcesValues.GMT);
        LocalDateTime endTime = LocalDateTime.now(ResourcesValues.GMT).plusDays(days);

        return getConstrainedContest(startTime,endTime,resourceName,days);

    }

    private ContestList getConstrainedContest( LocalDateTime startTime, LocalDateTime endTime,
                                              String resourceName, int days) {

        Call<ContestList> callSync = cListService.getContests(resourceName,startTime,endTime,ResourcesValues.ORDER_BY_START);
        ContestList contestList ;

        try {
            Response<ContestList> response = callSync.execute();
            contestList = response.body();
            return contestList;

        } catch (Exception ex) { ex.printStackTrace(); }

        return null;

    }

}