import redis.clients.jedis.Jedis;

public class RedisTest {
	
	public static void main(String[] args){
      
	Jedis jedis=RedisConnection.RedisConn();
		
    //���� redis �ַ�������
	for(Integer i=0;i<=100000;i++){
		Integer j=(int) Math.sqrt(i);
		jedis.set(i.toString(),j.toString());
	}
	
	long start=System.currentTimeMillis();
	
	// ��ȡ�洢�����ݲ����
	for(Integer k=0;k<100000;k++){
		System.out.println("����"+k.toString()+"����ȡ������ڣ�"+ jedis.get(k.toString()));
	}
	
	long end=System.currentTimeMillis();
	int time=(int) (end-start);
	System.out.println("����100000��������ʱ"+time+"ms");
      
 }
}