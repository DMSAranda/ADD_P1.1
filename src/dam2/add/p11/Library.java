/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.add.p11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import dam2.add.p11.MenuAlta;
import dam2.add.p11.MenuNombre;
import dam2.add.p11.Usuario;

/**
 *
 * @author David
 */
public class Library {

	public static boolean isNumeric(String cadena) {

		boolean resultado;
		// metodo que comprueba si una cadena es numerica
		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	public static boolean esDecimal(String cadena) {
		// metodo que comprueba si una cadena es decimal
		boolean resultado;

		try {
			Double.parseDouble(cadena);
			resultado = true;

		} catch (NumberFormatException nfe) {
			resultado = false;
		}

		return resultado;
	}

	public static String formatoNombre(String cadena) {
		// metodo queparsea un nombre con la primera letra de nombre y apellidos en
		// mayuscula
		String[] separadaPorEspacios = cadena.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int indice = 0; indice < separadaPorEspacios.length; indice++) {
			String palabra = separadaPorEspacios[indice];

			// De la palabra, primero agregar la primera letra ya convertida a mayúscula
			char primeraLetra = palabra.charAt(0);
			sb.append(Character.toUpperCase(primeraLetra));

			// Luego agregarle "lo sobrante" de la palabra
			sb.append(palabra.substring(1));

			// Y si no es el último elemento del arreglo, le añadimos un espacio
			if (indice < separadaPorEspacios.length - 1) {
				sb.append(" ");
			}
		}
		// Finalmente regresamos la cadena
		return sb.toString();
	}

	public void escribirUsuarios(Usuario user) throws IOException { // metodo que en el fichero agrega usuarios

		String salida = "acceso.txt";
		App.directorio.add(user);
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(new File(salida), true));

			bw.write(user.getNombre() + ":" + user.getPassword() + ":" + user.isBloqueado() + "\n"); // escribimos
																										// nombre:clave:bloqueado
			// nombre:clave

		} catch (IOException errorDeFichero) {
			System.out.println("Ha habido problemas: " + errorDeFichero.getMessage());
		} finally {
			try {

				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void escribirUsuarios2(ArrayList<Usuario> lista2) throws IOException { // metodo que pisa el fichero
																					// reescribiendo con una lista

		String salida = "acceso.txt";

		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(new File(salida)));

			/*
			 * Iterator<Usuario> it = lista2.iterator();
			 * 
			 * while (it.hasNext()) { bw.write(it.next().getNombre() + ":" +
			 * it.next().getPassword() + ":" + it.next().isBloqueado() + "\n"); //
			 * escribimos // nombre:clave:bloqueado }
			 */

			for (int i = 0; i < lista2.size(); i++) {

				Usuario user = lista2.get(i);

				bw.write(user.getNombre() + ":" + user.getPassword() + ":" + user.isBloqueado() + "\n");

			}

		} catch (IOException errorDeFichero) {
			System.out.println("Ha habido problemas: " + errorDeFichero.getMessage());
		} finally {
			try {

				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Usuario> leerUsuarios() throws IOException {
		// metodo que devuelve un array de usuarios

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String entrada = "acceso.txt";

		try {

			BufferedReader br = new BufferedReader(new FileReader(new File(entrada)));

			String linea = br.readLine();

			// se lee linea a linea
			// si es null es que ha llegado al final del fichero

			while (linea != null) {
				// se lee cada linea, separando en 3 string nombre y pass y metiendolo en
				// objeto usuario
				Usuario user = new Usuario();

				String[] partes = linea.split(":");
				String name = partes[0];
				String pass = partes[1];
				boolean block = Boolean.parseBoolean(partes[2]);

				user.setNombre(name);
				user.setPassword(pass);
				user.setBloqueado(block);

				lista.add(user);

				linea = br.readLine(); // luego se agrega al array
			}

			br.close();

		} catch (IOException errorDeFichero) {
			System.out.println("Ha habido problemas: " + errorDeFichero.getMessage());
		} catch (Exception e) {
			System.out.println("Ha habido problemas: " + e.getMessage());
		} finally {

		}

		App.directorio = lista; // se guarda en la libreria

		return lista; // se devuelve

	}

	public boolean comprobarLogin(Usuario user) throws IOException { // para usuario y clave del login

		ArrayList<Usuario> lector = leerUsuarios();

		// metodo que recibe un usuario y lo conrasta con el fichero de usuarios pasado
		// a un arraylist
		String name2 = user.getNombre();
		String pass2 = user.getPassword();
		boolean existe = false;

		for (Usuario var : lector) {

			if (name2.equalsIgnoreCase(var.getNombre()) && pass2.equals(var.getPassword())) // se comprueba uno a uno si
																							// coinciden
				// nombre y claves
				existe = true;
		}

		return existe;
	}

	public boolean comprobarBloqueado(Usuario user) throws IOException { // para usuario y clave del login

		ArrayList<Usuario> lector = leerUsuarios();

		// metodo que recibe un usuario y lo conrasta con el fichero de usuarios pasado
		// a un arraylist
		String name2 = user.getNombre();
		boolean bloqueado = false;

		for (Usuario var : lector) {

			if (name2.equalsIgnoreCase(var.getNombre())) // se comprueba uno a uno si coinciden nombre y claves

				if (var.isBloqueado() == true) {

					bloqueado = true;

				}
		}

		return bloqueado;
	}

	public boolean comprobarUsuario(Usuario user) throws IOException { // para nombre

		ArrayList<Usuario> lector = leerUsuarios();

		// metodo que recibe un usuario y lo conrasta con el fichero de usuarios pasado
		// a un arraylist
		String name2 = user.getNombre();
		boolean existe = false;

		for (Usuario var : lector) {

			if (name2.equalsIgnoreCase(var.getNombre())) // se comprueba uno a uno si coinciden nombre y claves

				existe = true;
		}

		return existe;
	}
	
	public boolean comprobarNombre(String nombre) throws IOException { // para nombre

		ArrayList<Usuario> lector = leerUsuarios();

		// metodo que recibe un nombre y lo conrasta con el fichero de usuarios pasado
		// a un arraylist
		
		boolean existe = false;

		for (Usuario var : lector) {

			if (nombre.equalsIgnoreCase(var.getNombre())) // se comprueba uno a uno si coinciden nombre y claves

				existe = true;
		}

		return existe;
	}

	public void altaUsuario() throws IOException { // crea usuario admin

		MenuAlta menu = new MenuAlta(); // se crea un menu de alta y uno de usuario
		Usuario nuevo = new Usuario();
		Library lib = new Library();

		boolean existe;

		nuevo.setNombre(menu.estableceNombre()); // se agrega el usuario y clave
		nuevo.setPassword(menu.estableceClave());
		nuevo.setBloqueado(false);

		existe = lib.comprobarLogin(nuevo); // se comprueba si existe

		if (existe == false) {

			lib.escribirUsuarios(nuevo); // se añade al fichero de usuarios

		}

		else {

			System.out.print("El usuario ya existe."); // si existe se avisa

		}

	}

	public void mostrarUsuarios() throws IOException { // metodo que imprime en consola los usuarios

		ArrayList<Usuario> lista = App.directorio; // se trae el listado de usuarios a un arraylits

		try {
			// se itera el array
			Iterator<Usuario> it = lista.iterator();

			while (it.hasNext()) {
				// se imprime la cadena
				System.out.println(it.next().getNombre());
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Datos fuera de límites");
		}

	}
	
	public void mostrarUsuariosBloqueados() throws IOException { // metodo que imprime en consola los usuarios

		ArrayList<Usuario> lista = App.directorio; // se trae el listado de usuarios a un arraylits

		try {
			// se itera el array
			for(int i=0; i<lista.size(); i++) {
				Usuario user = lista.get(i);
				// se imprime la cadena solo de bloqueados
				if (user.isBloqueado() == true) {
				System.out.println(user.getNombre());
				}
			}	

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Datos fuera de límites");
		}

	}

	public void bloquearUsuario(Usuario activo) throws IOException { // metodo que bloquea al usuario

		ArrayList<Usuario> lista = App.directorio; // se trae el listado de usuarios a un arraylits

		// Iterator<Usuario> it = lista.iterator();
		// se busca al usuario en el array y se pone en activo su atributo bloqueado
		/*
		 * while (it.hasNext()) {
		 * 
		 * if (it.next().getNombre().equals(activo.nombre)) {
		 * it.next().setBloqueado(true); } }
		 */

		for (int i = 0; i < lista.size(); i++) {

			Usuario user = lista.get(i);

			if (user.getNombre().equalsIgnoreCase(activo.getNombre())) {

				user.setBloqueado(true);
			}
		}

		escribirUsuarios2(lista); // pisamos el fichero con la nueva lista modificada

	}

	public void desbloquearUsuario() throws IOException { // metodo para desbloquear al usuario

		MenuNombre menu = new MenuNombre(); // se crea un objeto baja

		String elegido = menu.eligeNombre(); // se crea un string que guarda el nombre del usuario a desbloquear

		Usuario nuevo = new Usuario(); // se crea un usuario

		ArrayList<Usuario> lista = App.directorio; // se trae el array con la lista

		Library lib = new Library();

		boolean existe = false;

		nuevo.setNombre(elegido);
		// se comprueba que el elegido existe
		existe = lib.comprobarUsuario(nuevo);

		if (existe == false) {
			// si no existe se avisa
			System.out.println("El usuario no existe.");
			System.out.println();
		}

		else {

			for (int i = 0; i < lista.size(); i++) {

				Usuario user = lista.get(i);

				if (user.getNombre().equalsIgnoreCase(nuevo.getNombre())) {

					if (user.isBloqueado() == false) {
						System.out.println("El usuario no esta bloqueado.");
						System.out.println();

					}

					else {
						user.setBloqueado(false);
						System.out.println("Se ha  desbloqueado el usuario.");
						System.out.println();
						escribirUsuarios2(lista); // pisamos el fichero con la nueva lista modificada

					}
				}
			}

		}

	}

}
