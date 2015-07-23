package pw;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Bebida {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
	private String nombre;
	@Persistent
	private String tipo;
	@Persistent
	private int precio;
	@Persistent
	private String descripcion;
	@Persistent
	private String img;
	public Bebida(String nombre, String tipo, int precio, String descripcion,
			String img) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.img = img;
	}
	public Key getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", precio=" + precio + ", descripcion=" + descripcion
				+ ", img=" + img + "]";
	}
	
}
