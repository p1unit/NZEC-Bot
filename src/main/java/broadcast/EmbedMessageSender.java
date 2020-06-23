package broadcast;

import model.Object;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import resources.ResourcesValues;
import java.time.LocalDateTime;
import java.util.List;

public class EmbedMessageSender {

    public void sendMessages(MessageChannel channel, List<Object> objects, int days){

        if(objects.size()==0){
            channel.sendMessage("No Contest Found").queue();
            return;
        }

        channel.sendMessage("Contest Starting under "+days+" days").queue();

        for(Object object:objects){

            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle(object.getEvent());
            embedBuilder.setColor(ResourcesValues.getColor(object.getResource().getName()));
            embedBuilder.setAuthor(object.getResource().getName(),"http://"+object.getResource().getName()
                    ,ResourcesValues.getImage(object.getResource().getName()));

            String startDate = convertToIST(object.getStart());
            String endDate = convertToIST(object.getEnd());

            embedBuilder.addField("Start Date",startDate.split("T")[0],true);
            embedBuilder.addField("Start Time",startDate.split("T")[1],true);

            embedBuilder.addBlankField(false);

            embedBuilder.addField("End Date",endDate.split("T")[0],true);
            embedBuilder.addField("End Time",endDate.split("T")[1],true);

            embedBuilder.addField("Contest Link",object.getHref(),false);

            channel.sendMessage(embedBuilder.build()).queue();
        }
    }

    private String convertToIST(String dateAndTime){

        LocalDateTime ldt = LocalDateTime.parse(dateAndTime);
        LocalDateTime dateTime = ldt.plusHours(5).plusMinutes(30);
        return dateTime.toString();

    }
}