
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import timer.NewTimer;
import timer.NewTimerImpl;

public class SendMessage {

    @Autowired
    private static NewTimer newTimer = new NewTimerImpl();

    private static final Log log = LogFactory.getLog(SendMessage.class);

    public static void main(String[] args) {
        try {
            if (args.length != 0)
                newTimer.startTimer(args[0]);
            newTimer.startTimer("Without parameters. ");
        }
        catch (Exception e){
            log.error("SendMessage ", e);
        }
    }
}
