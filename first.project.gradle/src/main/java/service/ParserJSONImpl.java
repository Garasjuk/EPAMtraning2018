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


        Weather.Builder weatherBuilder = Weather.builder();
                weatherBuilder.setDescription((String) jweather.get("description"));
                weatherBuilder.setTemp(Double.valueOf(String.valueOf(jmain.get("temp"))));
                weatherBuilder.setHumidity((int) jmain.get("humidity"));
                weatherBuilder.setSpeed(Double.valueOf(String.valueOf(jwind.get("speed"))));
                weatherBuilder.setCountry((String) jsys.get("country"));
                weatherBuilder.setCity((String) jo.get("name"));

        return weatherBuilder.build();
    }
}
