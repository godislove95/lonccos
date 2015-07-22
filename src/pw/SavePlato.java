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

public class SavePlato extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServerException, ServletException {
		RequestDispatcher mandar = null ;
		String nombre = req.getParameter("nombre");
		int precio = Integer.parseInt(req.getParameter("precio"));
		String tipo = req.getParameter("tipo");
		
//		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
//		List<BlobKey> blobKeys = blobs.get("imagen");
		
		String descripcion = req.getParameter("descripcion");
		
		Plato plato = new Plato(nombre, tipo, precio, descripcion, "null");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(plato);
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
