import redis.clients.jedis.Jedis;


public class RedisConnection {

	public static Jedis RedisConn(){
		
		try {
			//���ӱ��ص� Redis ����
		    Jedis jedis = new Jedis("localhost");
		    System.out.println("����Redis����˳ɹ���");
		    //�鿴�����Ƿ�����
		    System.out.println("Server is running: "+jedis.ping());
		    return jedis;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����Redis�����ʧ�ܣ�");
			return null;
		}
		
	}
}
