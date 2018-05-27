package Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.springframework.stereotype.Service;

@Service("AllProperties")
public class AllPropertiesImpl implements AllProperties {

    public ArrayList getAllCitys() throws IOException {
        ArrayList arrayList = new ArrayList();
        Properties propCity = new Properties();
        String propFileCity = "city.properties";
        InputStream inputStreamCity = getClass().getClassLoader().getResourceAsStream(propFileCity);
        if (inputStreamCity != null) {
            propCity.load(inputStreamCity);
        } else {
            throw new FileNotFoundException("property file '" + inputStreamCity + "' not found in the classpath");
        }
        String stateInfo = propCity.getProperty("city");

        for (String str : stateInfo.split(",")){
            arrayList.add(str);
        }
        return arrayList;
    }

    public Properties getConnectJSON() throws IOException {
        Properties prop = new Properties();
        String propFileName = "setting.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        return prop;
    }

}
