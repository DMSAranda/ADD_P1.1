/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.add.p11;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author David
 */
public class MenuAdministrador {

	public void arrancar(Usuario activo) throws IOException {

		Library lib = new Library();

		Scanner teclado = new Scanner(System.in);
		int eleccion;

		do {
			do {

				System.out.println("Que opción eliges"); /* opciones del admin en un menu */
				System.out.println();
				System.out.println("1 - Desbloquear usuario");
				System.out.println("2 - Salir");
				System.out.println();
				System.out.print("Opcion elegida: "); /* pasamos a su opcion */

				String eleccion2 = teclado.nextLine();
				
				try {
				eleccion = Integer.parseInt(eleccion2);
				
				} catch (NumberFormatException excepcion) {
					
					System.out.println();
					System.out.println("Introduce un valor numérico.");
					System.out.println();
					eleccion=0;
				}
				System.out.println();

			} while (eleccion < 1 || eleccion > 2);

			switch (eleccion) {

			case 1:

				lib.mostrarUsuariosBloqueados(); // mostramos listado de usuarios
				System.out.println();
				lib.desbloquearUsuario(); // elegimos uno para desbloquearle
				break;

			case 2:
				
				System.out.println("Saliendo del menu de administrador.");
				System.out.println();
				break;

			}

		} while (eleccion != 2);

	}

}
