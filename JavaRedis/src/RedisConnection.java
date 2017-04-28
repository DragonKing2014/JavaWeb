import redis.clients.jedis.Jedis;


public class RedisConnection {

	public static Jedis RedisConn(){
		
		try {
			//连接本地的 Redis 服务
		    Jedis jedis = new Jedis("localhost");
		    System.out.println("连接Redis服务端成功！");
		    //查看服务是否运行
		    System.out.println("Server is running: "+jedis.ping());
		    return jedis;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("连接Redis服务端失败！");
			return null;
		}
		
	}
}
