package service;

import entity.Weather;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service("ParserJSON")
public class ParserJSONImpl implements ParserJSON {

    @Autowired
    private Connect connect = new ConnectImpl();

    public Weather pars(Object object) throws IOException {

        BufferedReader in = connect.connctJSON(object);
        String inputLine;

        Weather weather = new Weather();
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jo = new JSONObject(response.toString());
        JSONObject jmain = jo.getJSONObject("main");
        JSONObject jsys = jo.getJSONObject("sys");
        JSONObject jwind = jo.getJSONObject("wind");
        JSONObject jweather = jo.getJSONArray("weather").getJSONObject(0);

        // getting Country
        weather.setCity((String) jo.get("name"));
        weather.setCountry((String) jsys.get("country"));

        // getting Weather
        weather.setDescription((String) jweather.get("description"));

        // getting temp
        weather.setTemp(Double.valueOf(String.valueOf(jmain.get("temp"))));

        // getting humidity
        weather.setHumidity((int) jmain.get("humidity"));

        //getting wind
        weather.setSpeed(Double.valueOf(String.valueOf(jwind.get("speed"))));

        return weather;
    }
}
