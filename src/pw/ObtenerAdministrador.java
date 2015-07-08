
package pw;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@SuppressWarnings("serial")
public class ObtenerAdministrador extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	

			try{
				Query q = pm.newQuery(Cliente.class);
				@SuppressWarnings("unchecked")
				List<Administrador> admin = (List<Administrador>) q.execute();
				req.setAttribute("lista", admin);
				System.out.println("good");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Administrador.jsp");
				rd.forward(req, resp);
			}catch(Exception e){
				System.out.println("  ");
			}
		}

	}

