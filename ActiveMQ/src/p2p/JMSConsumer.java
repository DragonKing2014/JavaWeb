package p2p;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import publishToSubscribe.Listener;

import javax.jms.*;

/**
 * @author Dragon.
 */
public class JMSConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session;//会话 接受或者发送消息的线程
        Destination destination;//消息的目的地
        MessageConsumer messageConsumer;//消息的消费者
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);//实例化连接工厂
        try {
            connection = connectionFactory.createConnection();//通过连接工厂获取连接
            connection.start();//启动连接
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建session
            destination = session.createQueue("AMQQueue");//创建一个连接到HelloWorld的消息队列
            messageConsumer = session.createConsumer(destination);//创建消息消费者

            //只能收到一个
            //使这个messageConsumer运行500秒
            TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
            if(textMessage != null){
                System.out.println("收到的消息内容是:" + textMessage.getText());
            }
            //收到所有
            messageConsumer.setMessageListener(new Listener());

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}