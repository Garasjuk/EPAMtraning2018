package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public interface AllProperties {
    public List getAllCitys() throws IOException;
    public Properties getConnectJSON() throws IOException;

}
