import java.io.IOException;
import java.util.ArrayList;

import Entity.Weather;
import Service.AllPropertiesImpl;
import Service.AllProperties;
import Service.ParserJSON;
import Service.ParserJSONImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

public class JSONRead {

    @Autowired
    private static AllProperties allProperties = new AllPropertiesImpl();
    @Autowired
    private static ParserJSON parserJSON = new ParserJSONImpl();

    private final static Log log = LogFactory.getLog(JSONRead.class);

    public static void main(String[] args) {

        try {
            ArrayList arrayList = allProperties.getAllCitys();
            for (Object mass : arrayList) {
                show(parserJSON.pars(mass));
            }
        } catch (IOException | JSONException e) {
            log.error(e);
        }
    }

    public static void show(Weather weather) {
        System.out.println("country = " + weather.getCountry());
        System.out.println("city = " + weather.getCity());
        System.out.println("description = " + weather.getDescription());
        System.out.println("temp = " + weather.getTemp() + " C");
        System.out.println("humidity = " + weather.getHumidity() + "%");
        System.out.println("speed = " + weather.getSpeed());
        System.out.println("__________________________________ ");

    }
}
