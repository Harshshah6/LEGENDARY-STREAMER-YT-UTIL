package LEGENDARY.STREAMER.YT.UTIL;

import org.json.*;
import java.util.HashMap;
import java.util.ArrayList;


public class LegendaryStreamerYTUTIL {
    
    public static org.json.JSONObject obj;
    public static org.json.JSONArray array;
    public static org.json.JSONObject object;
    public static org.json.JSONObject snippet;
    public static org.json.JSONObject thumbs;
    public static org.json.JSONObject thumbDF;
    public static org.json.JSONObject thumbMD;
    public static org.json.JSONObject thumbHG;
    public static org.json.JSONObject thumbSD;
    public static String getTitle;
    public static String getDescription;
    public static String API = "AIzaSyDX_ZISf6qaLNPYtQ70ZZRwCdwALzWa6Uw";
    private static String API_URL;
    private static String VIDEO_ID;
    public static String getThumbnailDF;
    public static String getThumbnailMD;
    public static String getThumbnailHG;
    public static String getThumbnailSD;
    public static ArrayList<String> tags_list = new ArrayList<>();

public static String  getURL(String _URL){
    
    VIDEO_ID = _URL.replace("https://youtu.be/", "");
API_URL = "https://www.googleapis.com/youtube/v3/videos?part=id%2C+snippet&id=".concat(VIDEO_ID.concat("&key=".concat(API)));
return API_URL;
}
    
    public static void Response(String _response){
        try {
         org.json.JSONObject obj = new org.json.JSONObject(_response);

	org.json.JSONArray array = obj.getJSONArray("items");
	
	org.json.JSONObject object = array.getJSONObject(0);
	
	org.json.JSONObject snippet = object.getJSONObject("snippet");

org.json.JSONObject thumbs = snippet.getJSONObject("thumbnails");


try {

org.json.JSONArray tags = snippet.getJSONArray("tags");

for (int i = 0; i < (int)(tags.length()); i++) {
	tags_list.add(tags.getString(i));
}

}catch(Exception tagError){
    tags_list.add("NO TAGS FOUND");
}

getTitle = snippet.getString("title");
getDescription = snippet.getString("description");


try {

getThumbnailDF = "https://img.youtube.com/vi/" + VIDEO_ID + "/maxresdefault.jpg";
    
}catch(Exception thumbError){
    getThumbnailDF = thumbError.getMessage();
}

try{
    
org.json.JSONObject thumbDF = thumbs.getJSONObject("default");

getThumbnailDF = thumbDF.getString("url");

}catch(Exception LowError){
    getThumbnailDF = LowError.getMessage();
}

try {
    org.json.JSONObject thumbMD = thumbs.getJSONObject("medium");
	
getThumbnailMD = thumbMD.getString("url");

}catch(Exception mde){
    getThumbnailMD = mde.getMessage();
}

try {
    org.json.JSONObject thumbHG = thumbs.getJSONObject("high");
	getThumbnailHG = thumbHG.getString("url");

}catch(Exception hge){
    getThumbnailHG = hge.getMessage();
}

try {
    org.json.JSONObject thumbSD = thumbs.getJSONObject("standard");

getThumbnailSD = thumbSD.getString("url");
}catch(Exception sde){
    getThumbnailSD = sde.getMessage();
}

}catch(Exception e){
    getTitle = e.getMessage();
    getDescription = e.getMessage();
}

    }
    
}
