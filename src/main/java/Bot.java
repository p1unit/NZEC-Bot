import broadcast.ContestAnnoucment;
import contestService.ContestLIstService;
import model.ContestList;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import resources.ResourcesValues;
import retrofit2.Call;
import retrofit2.Response;
import serviceGenerator.CListService;
import singletonBot.BotApi;

import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) throws LoginException {

        BotApi.getInstance();


//        ContestLIstService cListService  =  CListService.createService(ContestLIstService.class);
//        Call<ContestList> callSync = cListService.getContests();
//        ContestList contestList ;
//
//        try {
//            Response<ContestList> response = callSync.execute();
//            contestList = response.body();
//        } catch (Exception ex) { ex.printStackTrace(); }

    }
}