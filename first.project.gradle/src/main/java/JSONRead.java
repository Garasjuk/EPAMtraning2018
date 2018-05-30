
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Weather;
import service.AllPropertiesImpl;
import service.AllProperties;
import service.ParserJSON;
import service.ParserJSONImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

public class JSONRead {

    @Autowired
    private static AllProperties allProperties = new AllPropertiesImpl();
    @Autowired
    private static ParserJSON parserJSON = new ParserJSONImpl();

    private static final Log log = LogFactory.getLog(JSONRead.class);

    public static void main(String[] args) {

        try {
            List arrayList = allProperties.getAllCitys();
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
