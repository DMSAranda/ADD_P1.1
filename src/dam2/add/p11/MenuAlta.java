/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.add.p11;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class MenuAlta {

	Scanner teclado = new Scanner(System.in);
	String nombre;
	String pass1;
	String pass2;

	public String estableceNombre() { // metodo que establece nombre

		boolean correcto = false;
		boolean existe = false;
		
		Library lib = new Library();

		do {
			System.out.print("Introduce nombre: ");
			nombre = teclado.nextLine();
			if (Library.isNumeric(nombre) == true) {
				correcto = false;
			} else {
				//nombre = Library.formatoNombre(nombre); EVITAMOS EL CAMBIO DE LAS INICIALES A MAYUSCULAS
				try {
					existe = lib.comprobarNombre(nombre);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(existe == true) {
					System.out.println();
					System.out.println("El usuario introducido ya existe.");
					System.out.println();
				correcto = false;
				}
				else correcto = true;
			}
		} while (correcto != true);

		return nombre;
	}

	public String estableceClave() { // metodo que establece clave

		boolean correcto = false;

		System.out.print("Introduce nueva contraseña: ");
		pass1 = teclado.nextLine();

		do {

			System.out.print("Vuelve a introducir tu nueva contraseña: ");
			pass2 = teclado.nextLine();

			if (pass1.equals(pass2)) {
				correcto = true;

			}

		} while (correcto != true);

		return pass1;

	}

}