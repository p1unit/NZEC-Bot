package broadcast;

import contestService.ContestLIstService;
import lombok.SneakyThrows;
import model.ContestList;
import retrofit2.Call;
import retrofit2.Response;
import serviceGenerator.CListService;
import singletonBot.BotApi;

import java.util.Scanner;
import java.util.TimerTask;

public class ContestAnnoucment implements Runnable {

    @Override
    public void run() {

        ContestLIstService cListService  =  CListService.createService(ContestLIstService.class);
        Call<ContestList> callSync = cListService.getContests(null,null,null,null);
        ContestList contestList ;


        try {
            Response<ContestList> response = callSync.execute();
            contestList = response.body();
            BotApi.getInstance().getTextChannelById(718694500981014602L).sendMessage("Hello");
//            BotApi.getInstance()
        } catch (Exception ex) { ex.printStackTrace(); }

    }
}