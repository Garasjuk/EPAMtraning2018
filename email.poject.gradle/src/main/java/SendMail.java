import java.io.IOException;
import service.Send;

public class SendMail {
    public static void main(String[] args) throws IOException {
        Send send = new Send();
        send.sendMessage(args);
    }
}
