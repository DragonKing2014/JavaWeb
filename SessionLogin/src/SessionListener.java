
import javax.servlet.http.HttpSession;  
import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  
import java.util.HashMap;  
  
/**  
 * @author Dragon
 */  
public class SessionListener implements HttpSessionListener  
{  
    /**  
     * 该HashMap以用户名-HttpSession对象存储一个账号只能被一个人登陆的信息。  
     */  
    public static HashMap<String,HttpSession> sessionMap = new HashMap<String,HttpSession>();  
  
    @Override  
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  
    {  
        HttpSession session = httpSessionEvent.getSession();  
    }  
  
    @Override  
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)  
    {  
  
        HttpSession session = httpSessionEvent.getSession();  
  
        delSession( session );  
    }  
  
    public static synchronized void delSession(HttpSession session)  
    {  
        if(session != null)  
        {  
  
            // 删除单一登录中记录的变量  
            if(session.getAttribute( "users" ) != null)  
            {  
                User user = (User) session.getAttribute( "users" );  
                SessionListener.sessionMap.remove( user.getUsername() );  
            }  
        }  
    }  
  
}  