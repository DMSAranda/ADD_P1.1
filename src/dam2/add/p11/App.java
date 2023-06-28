 package dam2.add.p11;

import java.io.IOException;
import java.util.ArrayList;

import dam2.add.p11.Ficheros;
import dam2.add.p11.MenuPrincipal;
import dam2.add.p11.Usuario;

class App {

	public static ArrayList<Usuario> directorio = new ArrayList<Usuario>();

	public static void main(String... args) throws IOException, InterruptedException {

		Ficheros fichero = new Ficheros(); // objeto ficheros

		/*
		 * Library lib = new Library();
		 * 
		 * ArrayList<Usuario> directorio2 = new ArrayList<Usuario>();
		 * 
		 * try { directorio2 = lib.leerUsuarios();
		 * 
		 * for (int i = 0; i < directorio2.size(); i++) {
		 * System.out.println(directorio2.get(i).getNombre() + " " +
		 * directorio2.get(i).getPassword() + " " + directorio2.get(i).isBloqueado() );
		 * }
		 * 
		 * } catch (IOException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		Library lib = new Library();

		try {
			lib.mostrarUsuarios();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		MenuPrincipal menu = new MenuPrincipal(); // objeto menu

		try {
			fichero.crearFicheros();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // creamos ficheros

		menu.arrancar();

	}

}