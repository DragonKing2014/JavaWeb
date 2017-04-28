
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;  
  
@WebServlet(urlPatterns = "/check")  
public class CheckServlet extends HttpServlet  
{  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  
    {  
        User user = (User) req.getSession().getAttribute( "users" );  
  
        if(null == user)  
        {  
  
            resp.sendRedirect( "login.jsp" );  
        }  
        else  
        {  
            resp.sendRedirect( "result.jsp" );  
        }  
  
    }  
}  

