package pw;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SaveCliente extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		RequestDispatcher mandar = null ;
		String email=req.getParameter("email");
		String nombre = req.getParameter("nombre");
		String paterno=req.getParameter("paterno");
		String materno = req.getParameter("materno");
		int dni = Integer.parseInt(req.getParameter("dni"));
		String pass =req.getParameter("pass");
		
		Cliente registro= new Cliente(email, nombre, paterno, materno, dni, pass);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(registro);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");	
			mandar.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		}finally{
			pm.close();
		}
	}
}
