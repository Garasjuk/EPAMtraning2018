package Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Send {
    private final static Log log = LogFactory.getLog(Send.class);

    public void sendMessage(String[] args) throws IOException {
        AllProperties allProperties = new AllProperties();
        Properties prop = allProperties.getConnectEmain();

        Connect connect = new Connect();
        Session session = connect.connctEmail(prop);
        try {
            Message message = new MimeMessage(session);
            // от кого
            message.setFrom(new InternetAddress(prop.getProperty("mail.username")));
            // Кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(args[0]));
            // Заголовок
            message.setSubject(args[1]);
            // текст
            message.setText(args[2]);

            Transport.send(message);

           log.info("Email Sent successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Error: " , e);
            log.info("You should write 3 parameters...");
            log.info("Email, Title, Text");
        }
    }

}
