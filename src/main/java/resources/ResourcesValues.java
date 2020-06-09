package resources;

import java.awt.*;
import java.time.ZoneId;
import java.util.HashMap;

public class ResourcesValues {

    public static String BASE_URL = System.getenv("API_BASE");
    public static String API_VERSION = System.getenv("API_VERSION");
    public static String API_TOKEN = System.getenv("API_TOKEN");
    public static String DISCORD_BOT_TOKEN = System.getenv("BOT_TOKEN");

//    public static String BASE_URL = ConfidentialItems.API_BASE;
//    public static String API_VERSION = ConfidentialItems.API_VERSION;
//    public static String API_TOKEN = ConfidentialItems.API_TOKEN;
//    public static String DISCORD_BOT_TOKEN = ConfidentialItems.BOT_TOKEN;

    public static ZoneId indianZone = ZoneId.of("Asia/Kolkata");
    public static ZoneId GMT = ZoneId.of("UTC");
    private static HashMap<String, Color> colorHashMap;
    private static HashMap<String, String> imageMap;
    public static String ORDER_BY_START = "start";

    static {

        colorHashMap = new HashMap<>();
        colorHashMap.put("codeforces.com",Color.RED);
        colorHashMap.put("codingcompetitions.withgoogle.com",Color.RED);
        colorHashMap.put("codechef.com",Color.RED);
        colorHashMap.put("hackerrank.com",Color.GREEN);
        colorHashMap.put("hackerearth.com",Color.BLUE);
        colorHashMap.put("topcoder.com",Color.ORANGE);
        colorHashMap.put("leetcode.com",Color.BLACK);

        imageMap = new HashMap<>();
        imageMap.put("codeforces.com","https://firebasestorage.googleapis.com/v0/b/opio-208612.appspot.com/o/codeforces.jpeg?alt=media&token=3349df67-d829-47db-bdb8-1a9b05d7b54b");
        imageMap.put("codingcompetitions.withgoogle.com","https://firebasestorage.googleapis.com/v0/b/opio-208612.appspot.com/o/google.jpg?alt=media&token=934db7bc-1c45-41e9-ae8a-6dca45abddda");
        imageMap.put("codechef.com","https://firebasestorage.googleapis.com/v0/b/opio-208612.appspot.com/o/codechef.jpg?alt=media&token=abc9647b-8abc-4a7c-9909-4ba1568f2cd0");
        imageMap.put("hackerrank.com","https://firebasestorage.googleapis.com/v0/b/opio-208612.appspot.com/o/hackerrank.jpeg?alt=media&token=0c96d72d-9179-4363-b098-4b4b14490b9a");
        imageMap.put("hackerearth.com","https://firebasestorage.googleapis.com/v0/b/opio-208612.appspot.com/o/HackerEarth_logo.png?alt=media&token=21dd50d9-c0f4-45df-8ab3-dc078976ba57");
        imageMap.put("topcoder.com","https://firebasestorage.googleapis.com/v0/b/opio-208612.appspot.com/o/topcoder.jpeg?alt=media&token=cccb7e04-0b9f-4ff3-b51e-a4245b518f41");
        imageMap.put("leetcode.com","https://firebasestorage.googleapis.com/v0/b/opio-208612.appspot.com/o/leetcode.png?alt=media&token=03868087-7afc-4ac7-a7ff-d6fff14546d9");

    }

    public static Color getColor(String resource){
        return colorHashMap.getOrDefault(resource,Color.YELLOW);
    }

    public static String getImage(String resource){
        return imageMap.getOrDefault(resource,null);
    }

}