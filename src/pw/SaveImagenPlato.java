package pw;

//file Upload.java

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class SaveImagenPlato extends HttpServlet {
 private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

 @Override
 public void doPost(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException, IOException {
	 PersistenceManager pm=PMF.get().getPersistenceManager();
	 RequestDispatcher mandar=null;
	 String id =req.getParameter("id");

	 
     Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);  
     List<BlobKey> blobKeys = blobs.get("myFile");
    
	 Query q=pm.newQuery(Plato.class);
	 q.setFilter("id == idParam ");
	 q.declareParameters("Long idParam");
	 List<Plato> platos=(List<Plato>)q.execute(Long.parseLong(id));
	 if(platos.size()==0){
	      resp.sendRedirect("/error.jsp");
          return ;
	 }
	 platos.get(0).setImg(blobKeys.get(0).getKeyString());
	 System.out.println(platos.get(0).toString());
	 
         resp.sendRedirect("/mostrarImagen?blob-key=" + blobKeys.get(0).getKeyString());
         mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
         mandar.forward(req, resp);
     
 }
}