
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import java.io.IOException;  
 
@WebServlet(urlPatterns = "/login")  
public class LoginServlet extends HttpServlet  
{  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  
    {  
        User user = new User();  
        HttpSession session = req.getSession();  
        /** 
         * ���˺��Ѿ�����½ 
         */  
        if(null != SessionListener.sessionMap.get( user.getUsername() ))  
        {  
            /** 
             * ���Ѿ���½����Ϣ�õ�,���µ��û���¼��Ϣ�Ž�ȥ 
             */  
            ForceLogoutUtils.forceUserLogout( user.getUsername() );  
  
            SessionListener.sessionMap.put( user.getUsername(), session );  
        }  
        /** 
         * ���˺�δ����½ 
         */  
        else  
        {  
            SessionListener.sessionMap.put( user.getUsername(), session );  
        }  
        session.setAttribute( "users", user );  
        req.getRequestDispatcher( "result.jsp" ).forward( req,resp );  
    }  
}  