package dam2.add.p11;

public class Usuario {

	private String nombre; // objeto usuario con atributos y metodos
	private String password;
	private boolean bloqueado = false;

	public String cadena() {

		String cadena;
		cadena = "Nombre: " + nombre + " / Contraseña: " + password;
		return cadena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
}