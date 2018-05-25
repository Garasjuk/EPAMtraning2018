package Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

public class Connect {

    private final static Log log = LogFactory.getLog(Connect.class);

    public BufferedReader connctJSON(Object object) {
        try {
            AllProperties allProperties = new AllProperties();
            Properties prop = allProperties.getConnectJSON();

            URL weather = new URL(prop.getProperty("weather.url") + "weather?id=" + object + "&appid=" + prop.getProperty("weather.appid") + "&units=" + prop.getProperty("weather.units") + "&lang=" + prop.getProperty("weather.lang"));
            HttpURLConnection con = (HttpURLConnection) weather.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(weather.openStream()));

            return in;
        } catch (MalformedURLException e) {
            log.error(e);
        } catch (ProtocolException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }
}
