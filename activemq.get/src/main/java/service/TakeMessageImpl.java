package service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;
import java.util.Properties;

public class TakeMessageImpl implements TakeMessage {
    @Autowired
    private static AllProperties allProperties = new AllPropertiesImpl();
    @Autowired
    private  static WriteToFile writeToFile = new WriteToFileImpl();

    private static final Log log = LogFactory.getLog(TakeMessageImpl.class);
    private Connection connection;

    public void goTake() throws JMSException {

        try {
            Properties prop = allProperties.getProperties();

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(prop.getProperty("activeMQConnection"));
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(prop.getProperty("queue_Name"));
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                writeToFile.setWrite(textMessage.getText(), prop.getProperty("file.name"));
                log.info("Get message successfully .... ");
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            connection.close();
        }
    }
}
