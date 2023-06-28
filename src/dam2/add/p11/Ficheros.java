/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.add.p11;

import java.io.File;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Ficheros {

	static File acceso = new File("acceso.txt");
	// static File auxiliar = new File("auxiliar.txt"); //se crean ficheros

	public void crearFicheros() throws IOException {

		if (acceso.exists()) {

		}

		else {
			try {

				acceso.createNewFile();

				Library lib = new Library();

				Usuario admin = new Usuario(); // se meten por defecto dos usuario con sus claves
				Usuario pepe = new Usuario();

				admin.setNombre("admin");
				admin.setPassword("admin");
				// admin.setBloqueado(false); por defecto se crean en false

				pepe.setNombre("pepe");
				pepe.setPassword("12345");
				// pepe.setBloqueado(false);

				lib.escribirUsuarios(admin);
				lib.escribirUsuarios(pepe);

			} catch (IOException ex) {
				Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

	}

	void borraFicheros() throws IOException {

		acceso.delete();

	}

}
