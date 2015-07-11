package pw;

//file Upload.java

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class Upload extends HttpServlet {
 private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

 @Override
 public void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException {
	 String nombre = req.getParameter("nombre");
		String tipo = req.getParameter("tipo");
		String criterio = req.getParameter("criterio");
		String tipocarne = req.getParameter("tipocarne");
		String precio = req.getParameter("precio");
		String descripcion = req.getParameter("descripcion");
		


     Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
     List<BlobKey> blobKeys = blobs.get("myFile");
//     Plato p = new Plato(nombre, tipo,criterio,tipocarne,precio,descripcion, blobKeys.get(0).getKeyString());

		 PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
//			pm.makePersistent(p);
			System.out.println("bien");
			RequestDispatcher rd = req.getRequestDispatcher("/IngresarPlato.jsp");
			rd.forward(req, res);
		}catch(Exception e){
			System.out.println(e);
			System.out.println("mal");
		}finally{
			
		}
//     if (blobKeys == null || blobKeys.isEmpty()) {
//         System.out.println("mal");
//     } else {
//         res.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
//     }
 }
}