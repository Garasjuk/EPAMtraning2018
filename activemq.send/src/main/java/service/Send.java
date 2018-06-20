package service;

import javax.jms.JMSException;

public interface Send {
    void goSend(String str, long count) throws JMSException;
}
