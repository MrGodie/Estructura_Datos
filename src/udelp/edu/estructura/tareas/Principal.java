package udelp.edu.estructura.tareas;
import udelp.edu.estructura.funciones.Funciones;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
        String expresion;
        System.out.println("Proporcione una expresion");
        expresion = leer.nextLine();
        String polacaInversa = Funciones.convertirMetodoPolaca(expresion);
        System.out.println("Reescrita en notacion polaca inversa: " + polacaInversa );
        System.out.println("Resultado: " + Funciones.evaluarPolaca(polacaInversa));
        
        
        

	}

}