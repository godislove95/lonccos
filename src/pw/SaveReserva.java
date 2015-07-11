package pw;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SaveReserva extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		HttpSession session = req.getSession();
		String hora = req.getParameter("hora");
		String numero = req.getParameter("numero");
		String lugar = req.getParameter("lugar");
		String zona = "EXCLUSIVA";
		String tipo= req.getParameter("tipo");
		String fecha =req.getParameter("fecha");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Usuario.class);
		q.setFilter("email == emailParam");
		q.declareParameters("String emailParam");
		@SuppressWarnings("unchecked")
		List<Usuario> cliente= (List<Usuario>)q.execute("deyby_57@hotmail.com");
		try{
			if(cliente.get(0).getReservas().size() == 0){
				System.out.println("!>>>");
				Reserva r = new Reserva( 1, hora, numero, lugar, zona, fecha, tipo);
				System.out.println("!>");
				cliente.get(0).getReservas().add(r);
				System.out.println("!>>>");
			}
			else
				if(cliente.size() != 0){
					System.out.println("!");
					int l = cliente.get(0).getReservas().size();
					Reserva r = new Reserva( ++l , hora, numero, lugar, zona, fecha, tipo);
					cliente.get(0).getReservas().add(r);
					System.out.println("?");
				}
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
