package broadcast;

import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import resources.ResourcesValues;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class DailyScheduler {

    private static Scheduler scheduler ;
    private static DailyScheduler dailyScheduler;
    private static JobDetail job;
    private static SimpleTrigger trigger;

    private DailyScheduler() throws SchedulerException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
    }

    private static void configureScheduler(){

        Calendar startTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        startTime.set(Calendar.HOUR, ResourcesValues.GET_HRS);
        startTime.set(Calendar.MINUTE, ResourcesValues.GET_MIN);
        startTime.set(Calendar.SECOND, ResourcesValues.GET_SEC);
        startTime.set(Calendar.AM_PM, Calendar.AM);

        if (startTime.getTime().getTime() < Calendar.getInstance().getTime().getTime()) {
            startTime.add(Calendar.HOUR, 12);
        }

        if (startTime.getTime().getTime() < Calendar.getInstance().getTime().getTime()) {
            startTime.add(Calendar.HOUR, 12);
        }

        System.out.println(startTime.getTime().getTime()+" "+Calendar.getInstance().getTime().getTime());

        job = JobBuilder.newJob(ContestAnnoucment.class)
                .withIdentity("daily-announcement-job", "announcement-group")
                .build();

        trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("daily-announcement-trigger", "announcement-group")
                .startAt(startTime.getTime())
                .withSchedule(simpleSchedule()
                        .withIntervalInHours(12)
                        .repeatForever())
                .build();
    }

    @SneakyThrows
    public static DailyScheduler getInstance(){

        if(dailyScheduler==null) {
            dailyScheduler = new DailyScheduler();
            configureScheduler();
        }

        return dailyScheduler;
    }

    @SneakyThrows
    public void triggerAnnouncement(){

        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }
}