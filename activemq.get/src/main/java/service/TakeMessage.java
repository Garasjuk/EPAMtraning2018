package service;

import javax.jms.JMSException;

public interface TakeMessage {
     void goTake() throws JMSException;
}
