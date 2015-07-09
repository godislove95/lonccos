package pw;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SalirSesion extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;

        HttpSession session = req.getSession(false);
        session.setAttribute("usuario", null);
        if(session.getAttribute("usuario") == null){  
        	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
        }
        else{    
        	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");  
        }  
        mandar.forward(req, resp);
	}
}
