import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONRead {

    public static void main(String[] args) {

        try {
            URL weather = new URL("http://api.openweathermap.org/data/2.5/weather?id=627904&appid=9f975a0c8664151251c09c6aaa4c6794&units=metric&lang=ru");
            HttpURLConnection con = (HttpURLConnection) weather.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(weather.openStream()));
            String inputLine;

            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jo = new JSONObject(response.toString());
            JSONObject jmain = jo.getJSONObject("main");
            JSONObject jsys = jo.getJSONObject("sys");
            JSONObject jweather = jo.getJSONArray("weather").getJSONObject(0);

            // getting Country
            String name = (String) jo.get("name");
            String country = (String) jsys.get("country");

            System.out.println("city = " + name);
            System.out.println("country = " + country);

            // getting Weather
            String main = (String) jweather.get("main");
            String description = (String) jweather.get("description");

            System.out.println("main = " + main);
            System.out.println("description = " + description);

            // getting temp
            int temp = (int) jmain.get("temp");
            System.out.println("temp = " + temp);

            // getting humidity
            int humidity = (int) jmain.get("humidity");
            System.out.println("humidity = " + humidity + "%");

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
