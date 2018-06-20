package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteToFileImpl implements WriteToFile {

    private Writer writer = null;
    private static final Log log = LogFactory.getLog(WriteToFile.class);

    public void setWrite(String message, String prop) throws IOException {

        try {
            writer =  new FileWriter(prop, true);
            writer.write (message + System.getProperty("line.separator"));
        } catch (IOException e) {
            log.error(e);
        } finally {
            writer.close();
        }
    }
}
