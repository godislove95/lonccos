package pw;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * @author Juan Manuel
 *
 */
@PersistenceCapable
public class Historial {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private Date date;
	
	@Persistent
	public String accion;

	public Historial(String accion) {
		this.date = new Date();
		this.accion = accion;
	}

	public Key getKey() {
		return key;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Override
	public String toString() {
		return "Historial [key=" + key + ", date=" + date + ", accion="
				+ accion + "]";
	}
	
}