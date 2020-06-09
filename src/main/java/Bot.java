
import broadcast.DailyScheduler;
import org.quartz.SchedulerException;
import singletonBot.BotApi;
import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) throws LoginException, SchedulerException {

        BotApi.getInstance();
        DailyScheduler.getInstance().triggerAnnouncement();

    }
}