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
        imageMap.put("codeforces.com","https://1.bp.blogspot.com/-pBimI1ZhYAA/Wnde0nmCz8I/AAAAAAAABPI/5LZ2y9tBOZIV-pm9KNbyNy3WZJkGS54WgCPcBGAYYCw/s1600/codeforce.png");

    }

    public static Color getColor(String resource){
        return colorHashMap.getOrDefault(resource,Color.YELLOW);
    }

    public static String getImage(String resource){
        return imageMap.getOrDefault(resource,null);
    }

}