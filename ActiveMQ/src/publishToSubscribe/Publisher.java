package publishToSubscribe;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.*;


public class Publisher {
	
    ConnectionFactory factory;//连接工厂
    Connection connection = null;//连接
    Session session;//会话 接受或者发送消息的线程
    Destination[] destinations;//消息的目的地
    MessageProducer producer;

    public Publisher() throws JMSException {
        factory = new ActiveMQConnectionFactory(
        		ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
        connection = factory.createConnection();
        try {
            connection.start();//启动连接
        } catch (JMSException e) {
            connection.close();
            throw e;
        }
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(null);
    }

    protected void setTopics(String[] stocks) throws JMSException {
        destinations = new Destination[stocks.length];
        for(int i = 0; i < stocks.length; i++) {
            destinations[i] = session.createTopic("STOCKS." + stocks[i]);
        }
    }


    protected void sendMessage(String[] stocks) throws JMSException {
        for(int i = 0; i < stocks.length; i++) {
            Message message = createStockMessage(stocks[i], session);
            System.out.println("Sending: " + ((ActiveMQMapMessage)message).getContentMap() + " on destination: " + destinations[i]);
            producer.send(destinations[i], message);
        }
    }

    protected Message createStockMessage(String stock, Session session) throws JMSException {
        MapMessage message = session.createMapMessage();
        message.setString("stock", stock);
        message.setDouble("price", 1.00);
        message.setDouble("offer", 0.01);
        message.setBoolean("up", true);
        return message;
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws JMSException {

        // Create publisher
        Publisher publisher = new Publisher();

        // Set topics
        String[] stocks = {"a","b","c","d","e"};
        publisher.setTopics(stocks);

        for(int i = 0; i < 10; i++) {
            publisher.sendMessage(stocks);
            System.out.println("Publisher '" + i + " price messages");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Close all resources
        publisher.close();
    }
}