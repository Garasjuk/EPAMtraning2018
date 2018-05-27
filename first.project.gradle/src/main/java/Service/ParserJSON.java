package Service;

import Entity.Weather;

import java.io.IOException;

public interface ParserJSON {
    public Weather pars(Object object) throws IOException;

}
