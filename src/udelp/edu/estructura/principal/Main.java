package udelp.edu.estructura.principal;
import java.util.Scanner;
import udelp.edu.estructura.funciones.Funciones;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ejemplo1 = "(5 - 6)";
        Funciones funcion = new Funciones();
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una ecuacion sencilla, la ecuacion debde de usar solo digitos "
        		+ "y debe de contener parentesis");
        ejemplo1 = leer.nextLine();
        if(funcion.validarParentesis(ejemplo1)) {	
        	System.out.println("El resultado es: " + funcion.revisarEcuacion(ejemplo1));
        }else {
        	System.out.println("Los parentesis no son correctos");
        }
        
        

	}

}