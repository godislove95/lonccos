package pw;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SaveCliente extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		String email=req.getParameter("email");
		String nombre = req.getParameter("nombre");
		String paterno=req.getParameter("paterno");
		String materno = req.getParameter("materno");
		int dni = Integer.parseInt(req.getParameter("dni"));
		String pass =req.getParameter("pass");
		
		Usuario registro= new Usuario(email, nombre, paterno, materno, dni, pass, 0);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(registro);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
		}catch(Exception e){
			System.out.println(e);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			
		}finally{
			pm.close();
			mandar.forward(req, resp);
		}
	}
}
