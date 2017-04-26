package publishToSubscribe;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.DecimalFormat;


public class Subscriber {
    ConnectionFactory factory;//连接工厂
    Connection connection = null;//连接
    Session session;//会话 接受或者发送消息的线程
    Destination destination;//消息的目的地

    public Subscriber() throws JMSException {
        factory = new ActiveMQConnectionFactory(
        		ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public static void main(String[] args) throws JMSException {
        Subscriber consumer = new Subscriber();
        String[] stocks = {"a","b","c","d","e"};//找到发布的Topic
        for (String stock : stocks) {
            Destination destination = consumer.getSession().createTopic("STOCKS." + stock);
            MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);

            //只能收到一次
            MapMessage map = (MapMessage) messageConsumer.receive();//使这个messageConsumer运行500秒
            if(map != null){
                stock = map.getString("stock");
                double price = map.getDouble("price");
                double offer = map.getDouble("offer");
                boolean up = map.getBoolean("up");
                DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
                System.out.println(stock + "\t" + df.format(price) + "\t" + df.format(offer) + "\t" + (up ? "up" : "down"));
            }else {
                break;
            }
            //监听收到所有
            messageConsumer.setMessageListener(new Listener());
        }
    }

    public Session getSession() {
        return session;
    }
}
