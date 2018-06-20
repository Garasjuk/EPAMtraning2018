package service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;
import java.util.Properties;

public class SendImpl implements Send {

    @Autowired
    private AllProperties allProperties = new AllPropertiesImpl();

    private static final Log log = LogFactory.getLog(SendImpl.class);
    private Connection connection;

    public void goSend(String str, long count) throws JMSException {
        try {

            Properties prop = allProperties.getProperties();

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(prop.getProperty("ActiveMQConnection"));
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(prop.getProperty("Queue_Name"));
            MessageProducer producer = session.createProducer(destination);

            TextMessage message = session.createTextMessage(str + " " + count);
            producer.send(message);

            log.info("Sent successfully.... Queue: " + prop.getProperty("Queue_Name"));

        } catch (Exception e) {
            log.error(e);
        } finally {
            connection.close();
        }
    }
}
