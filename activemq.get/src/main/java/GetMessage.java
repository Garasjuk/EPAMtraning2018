
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import timer.NewTimer;
import timer.NewTimerImpl;

public class GetMessage {

    @Autowired
    private static NewTimer newTimer = new NewTimerImpl();

    private static final Log log = LogFactory.getLog(GetMessage.class);

    public static void main(String[] args){

        try {
            newTimer.startTimer();
        } catch (Exception e) {
            log.error(e);
        }
    }
}
