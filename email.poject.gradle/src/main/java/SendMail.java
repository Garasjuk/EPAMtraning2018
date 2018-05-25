import java.io.IOException;
import Service.Send;

public class SendMail {
    public static void main(String[] args) throws IOException {
        Send send = new Send();
        send.sendMessage(args);
    }
}
