package pw;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.*;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;;

@SuppressWarnings("serial")

public class SaveEvento extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServerException, ServletException {
		RequestDispatcher mandar = null ;
		String nombre = req.getParameter("nombre");
		String lugar=req.getParameter("lugar");
		String fecha=req.getParameter("fecha");
		String hora=req.getParameter("hora");
		
		
		String descripcion = req.getParameter("descripcion");
		
		Evento evento = new Evento(hora	, lugar, fecha, nombre);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(evento);
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
