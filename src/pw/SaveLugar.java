package pw;

import java.io.IOException;

import java.rmi.ServerException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")

public class SaveLugar extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServerException, ServletException {
		RequestDispatcher mandar = null ;
		String nombre = req.getParameter("nombre");
		
		Lugar l = new Lugar(nombre);
		System.out.println(l.getNombre());
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(l);
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
