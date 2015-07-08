package pw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class IniciarSesion extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher mandar = null;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(Cliente.class);
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		
//		q.setFilter("user == userParam && pass == passParam");
//		q.declareParameters("String userParam,String passParam");
		
		try{
			List<Cliente> cliente = (List<Cliente>) q.execute();
			out.println("<ul>");
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
			mandar.forward(req, resp);
		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
	}
}
