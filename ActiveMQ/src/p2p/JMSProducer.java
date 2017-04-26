package p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 消息的生产者（发送者） 
 *
 */
public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;//默认连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址
    private static final int SENDNUM = 10; //发送的消息数量

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session;//会话 接受或者发送消息的线程
        Destination destination;//消息的目的地
        MessageProducer messageProducer;//消息生产者
        
        connectionFactory = new ActiveMQConnectionFactory(
        		JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);//实例化连接工厂
        try {
            connection = connectionFactory.createConnection();//通过连接工厂获取连接
            connection.start();//启动连接
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);//创建session
            destination = session.createQueue("AMQQueue");//创建一个名称为AMQQueue的消息队列
            messageProducer = session.createProducer(destination);//创建消息生产者
            //调用类方法发送消息
            sendMessage(session, messageProducer);//发送消息
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 发送消息
     * @param session
     * @param messageProducer  消息生产者
     * @throws Exception
     */
    public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
        	//创建一条文本消息
            TextMessage message = session.createTextMessage("Producer 发送消息" +i); 
            System.out.println("发送消息：Producer 发送消息" + i);
            messageProducer.send(message);//通过消息生产者发出消息 
        }
    }
}
