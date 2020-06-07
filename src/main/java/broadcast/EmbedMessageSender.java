package broadcast;

import model.Object;
import model.Resource;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import resources.ResourcesValues;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class EmbedMessageSender {

    public void sendMessages(GuildMessageReceivedEvent event, List<Object> objects, int days){

        if(objects.size()==0){
            event.getChannel().sendMessage("No Contest Found").queue();
            return;
        }

        event.getChannel().sendMessage("Contest Starting under "+days+" days").queue();

        for(Object object:objects){

            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle(object.getEvent());
            embedBuilder.setColor(ResourcesValues.getColor(object.getResource().getName()));
            embedBuilder.setAuthor(object.getResource().getName(),"http://"+object.getResource().getName()
                    ,ResourcesValues.getImage(object.getResource().getName()));

            String startDate = convertToIST(object.getStart());
            String endDate = convertToIST(object.getEnd());

            embedBuilder.addField("Start Date",startDate.split("T")[0],true);
            embedBuilder.addBlankField(true);
            embedBuilder.addField("Start Time",startDate.split("T")[1],true);


            embedBuilder.addField("End Date",endDate.split("T")[0],true);
            embedBuilder.addBlankField(true);
            embedBuilder.addField("End Time",endDate.split("T")[1],true);

            embedBuilder.addField("Contest Link",object.getHref(),false);

            event.getChannel().sendMessage(embedBuilder.build()).queue();


        }


    }

    private String convertToIST(String dateAndTime){

        LocalDateTime ldt = LocalDateTime.parse(dateAndTime);
        LocalDateTime dateTime = ldt.plusHours(5).plusMinutes(30);
        return dateTime.toString();
    }
}