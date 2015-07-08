package pw;

	import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
  
	@PersistenceCapable
	public class Cliente {
		@PrimaryKey
		@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
		private String email;
		
		@Persistent
		private String nombre;
		
		@Persistent
		private String paterno;
		
		@Persistent
		private String materno;
		
		@Persistent
		private int dni;	

		@Persistent
		private String pass;

		public Cliente(String email, String nombre, String paterno,
				String materno, int dni, String pass) {
			super();
			this.email = email;
			this.nombre = nombre;
			this.paterno = paterno;
			this.materno = materno;
			this.dni = dni;
			this.pass = pass;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getPaterno() {
			return paterno;
		}

		public void setPaterno(String paterno) {
			this.paterno = paterno;
		}

		public String getMaterno() {
			return materno;
		}

		public void setMaterno(String materno) {
			this.materno = materno;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public int getDni() {
			return dni;
		}

		@Override
		public String toString() {
			return "Cliente [email=" + email + ", nombre=" + nombre
					+ ", paterno=" + paterno + ", materno=" + materno
					+ ", dni=" + dni + ", pass=" + pass + "]";
		}
		
		
}