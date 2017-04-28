
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
     * ��HashMap���û���-HttpSession����洢һ���˺�ֻ�ܱ�һ���˵�½����Ϣ��  
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
  
            // ɾ����һ��¼�м�¼�ı���  
            if(session.getAttribute( "users" ) != null)  
            {  
                User user = (User) session.getAttribute( "users" );  
                SessionListener.sessionMap.remove( user.getUsername() );  
            }  
        }  
    }  
  
}  