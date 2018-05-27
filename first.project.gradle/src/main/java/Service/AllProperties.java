package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public interface AllProperties {
    public ArrayList getAllCitys() throws IOException;
    public Properties getConnectJSON() throws IOException;

}
