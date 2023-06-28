
package dam2.add.p11;

import java.io.IOException;
import java.util.Scanner;

/**
 * hola
 * 
 * @author David
 */
public class MenuPrincipal {

	Scanner teclado = new Scanner(System.in);
	String opcion2;
	int opcion;

	public void arrancar() {

		do {
			do {

				System.out.println("Elige una opción");
				System.out.println();
				System.out.println("1 - Login");
				System.out.println("2 - Resetear ficheros"); // menu
				System.out.println("3 - Alta de usuario");
				System.out.println("4 - Salir");
				System.out.println();
				System.out.print("Opcion elegida: ");

				opcion2 = teclado.nextLine();

				try {
					opcion = Integer.parseInt(opcion2);

				} catch (NumberFormatException excepcion) {

					System.out.println();
					System.out.println("Introduce un valor numérico.");
					System.out.println();
					opcion = 0;
				}
				System.out.println();

			} while (opcion < 1 || opcion > 4);

			switch (opcion) {

			case 1:

				Usuario activo = new Usuario();
				// se crea un usuario activo y se pasa a login
				Login log = new Login();

				try {
					activo = log.hacerLoggin();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (activo != null) {

					if (activo.getNombre().equalsIgnoreCase("admin")) { // si es el admin se saluda y se pasa a su menu

						System.out.println();
						System.out.println("Hola " + activo.getNombre() + ", bienvenid@ al sistema.");
						MenuAdministrador menu = new MenuAdministrador();

						try {
							menu.arrancar(activo);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} // sino se saluda

					else
						System.out.println();
					System.out.println("Hola " + activo.getNombre() + ", bienvenid@ al sistema.");
					System.out.println();
				}
				
				break;

			case 2:

				Ficheros fichero2 = new Ficheros(); // borra ficheros y los crea nuevos
				try {
					fichero2.borraFicheros();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fichero2.crearFicheros();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 3:

				Library nuevo = new Library(); // se crea un objeto usuario y se pasa a menu de alta
				try {
					nuevo.altaUsuario();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Alta correcta.");
				System.out.println();

				break;

			case 4: // salimos

				System.out.print("Adiós, vuelva pronto.");
				break;
			}

		} while (opcion != 4);

	}

}
