package dam2.add.p11;

import java.util.Scanner;


/**
 *
 * @author David
 */
 public class MenuNombre {
    
        
        Scanner teclado = new Scanner(System.in); 
        boolean correcto = false;
        String nombre;
        String pass1;
        String pass2;
       
        
     
    
    public String eligeNombre(){   
        
        do{																	//se escoge por el admin la persona que se va a adesbloquear con un mini menu
            System.out.print("Introduce nombre: ");
            nombre = teclado.nextLine();
            if (Library.isNumeric(nombre) == true){
                correcto = false;                
            }
            else{
               // nombre = Library.formatoNombre(nombre); EVITAMOS EL CAMBIO DE LAS INICIALES A MAYUSCULAS
                correcto = true;
            }
        }while(correcto != true);
        
        return nombre; 
    } 
    
    
   
   
    
    
 }