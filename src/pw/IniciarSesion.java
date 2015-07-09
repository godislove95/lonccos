package pw;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class IniciarSesion extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Cliente.class);
		RequestDispatcher mandar = null ;
		HttpSession sesion = req.getSession();
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		q.setFilter("email == emailParam");
		q.declareParameters("String emailParam");
		
		try{
			@SuppressWarnings("unchecked")
			List<Cliente> cliente = (List<Cliente>) q.execute(email);
			if(cliente.size() == 0){
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/noExisteEmail.jsp");
			}
			else if(!cliente.get(0).getPass().equals(pass)){
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/passIncorrecto.jsp");
			}
			else {
				String login = cliente.get(0).getEmail() + "<br>"
						+ cliente.get(0).getNombre().toUpperCase() + " "
						+ cliente.get(0).getPaterno().toUpperCase() + "<br>"
						+ cliente.get(0).getDni();
				sesion.setAttribute("usuario", login);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
			}
		}catch(Exception e){
			System.out.println(e);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		}finally{
			pm.close();
			mandar.forward(req, resp);
		}
	}
}
