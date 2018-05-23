import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    public static void main(String[] args) {

        final String username = "king_5050@mail.ru";
        final String password = "Zhemchyzhina148";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            // от кого
            message.setFrom(new InternetAddress(username));
            // Кому
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(args[0]));
            // Заголовок
            message.setSubject(args[1]);
            // текст
            message.setText(args[2]);

            Transport.send(message);

            System.out.println("Email Sent successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("You should write 3 parameters...");
            System.out.println("Email, Title, Text");
        }
    }
}
