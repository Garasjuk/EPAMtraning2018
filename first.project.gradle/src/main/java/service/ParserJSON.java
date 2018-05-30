package service;

import entity.Weather;

import java.io.IOException;

public interface ParserJSON {
    public Weather pars(Object object) throws IOException;

}
