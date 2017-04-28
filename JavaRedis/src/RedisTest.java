import redis.clients.jedis.Jedis;

public class RedisTest {
	
	public static void main(String[] args){
      
	Jedis jedis=RedisConnection.RedisConn();
		
    //设置 redis 字符串数据
	for(Integer i=0;i<=100000;i++){
		Integer j=(int) Math.sqrt(i);
		jedis.set(i.toString(),j.toString());
	}
	
	long start=System.currentTimeMillis();
	
	// 获取存储的数据并输出
	for(Integer k=0;k<100000;k++){
		System.out.println("数字"+k.toString()+"开方取整后等于："+ jedis.get(k.toString()));
	}
	
	long end=System.currentTimeMillis();
	int time=(int) (end-start);
	System.out.println("操作100000条数据用时"+time+"ms");
      
 }
}