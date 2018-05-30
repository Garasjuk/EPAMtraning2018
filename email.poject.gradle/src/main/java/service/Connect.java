package service;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class Connect  {

    public Session connctEmail(Properties prop) {
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(prop.getProperty("mail.username"), prop.getProperty("mail.password"));
                    }
                });
        return session;
    }
}
