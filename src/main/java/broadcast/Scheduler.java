package broadcast;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler{

    private static ScheduledExecutorService scheduler;

    public static void schedule(){
        scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(yourRunnable, 8, 8, TimeUnit.HOURS);
    }

}