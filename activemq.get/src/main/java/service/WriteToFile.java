package service;

import java.io.IOException;

public interface WriteToFile {
    void setWrite(String message, String prop) throws IOException;
}
