package timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.Send;
import service.SendImpl;

import javax.jms.JMSException;
import java.util.Timer;
import java.util.TimerTask;

public class NewTimerImpl implements  NewTimer {
    @Autowired
    private Send send = new SendImpl();

    private static final Log log = LogFactory.getLog(NewTimerImpl.class);
    private String str;
    private long count = 0;
    private Timer timer = new Timer();

    public void startTimer(String str) {
        this.str = str;
        timer.schedule( task, 10000,10000 );
    }

    TimerTask task = new TimerTask() {
        public void run()
        {
            try {
                send.goSend(str, count);
                count++;
            } catch (JMSException e) {
                log.error(e);
            }
        }
    };

}
