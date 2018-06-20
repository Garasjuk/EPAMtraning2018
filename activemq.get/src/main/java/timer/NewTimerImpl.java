package timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.TakeMessage;
import service.TakeMessageImpl;

import javax.jms.JMSException;
import java.util.Timer;
import java.util.TimerTask;

public class NewTimerImpl implements NewTimer {
    @Autowired
    private TakeMessage takeMessage = new TakeMessageImpl();

    private static final Log log = LogFactory.getLog(NewTimerImpl.class);

    private Timer timer = new Timer();

    public void startTimer() {
        timer.schedule(task, 5000, 9000);
    }

    TimerTask task = new TimerTask() {
        public void run() {
            try {
                takeMessage.goTake();
            } catch (JMSException e) {
                log.error(e);
            }
        }
    };
}
