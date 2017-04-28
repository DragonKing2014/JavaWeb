
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
         * 该账号已经被登陆 
         */  
        if(null != SessionListener.sessionMap.get( user.getUsername() ))  
        {  
            /** 
             * 将已经登陆的信息拿掉,将新的用户登录信息放进去 
             */  
            ForceLogoutUtils.forceUserLogout( user.getUsername() );  
  
            SessionListener.sessionMap.put( user.getUsername(), session );  
        }  
        /** 
         * 该账号未被登陆 
         */  
        else  
        {  
            SessionListener.sessionMap.put( user.getUsername(), session );  
        }  
        session.setAttribute( "users", user );  
        req.getRequestDispatcher( "result.jsp" ).forward( req,resp );  
    }  
}  