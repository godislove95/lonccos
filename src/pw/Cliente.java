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


		public Cliente(String nombre, String paterno, String materno,int dni, String email, String pass) {
			super();
			this.nombre = nombre;
			this.paterno = paterno;
			this.materno = materno;
			this.dni = dni;
			this.email = email;
			this.pass = pass;
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

		public int getDni() {
			return dni;
		}


		public void setDni(int dni) {
			this.dni = dni;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPass() {
			return pass;
		}


		public void setPass(String pass) {
			this.pass = pass;
		}


		@Override
		public String toString() {
			return "Registro [nombre=" + nombre + ", paterno=" + paterno
					+ ", materno=" + materno +", dni=" + dni + ", email=" + email + ", pass=" + pass
					+ "]";
		}
		
		
		
		
		}