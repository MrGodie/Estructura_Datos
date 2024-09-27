package udelp.edu.estructura.tareas;
import udelp.edu.estructura.funciones.Funciones;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in); 
		String seleccion;
		String descripcion;
		String codigo;
		double dinero;
		Funciones operacion = new Funciones();
		do {
    		System.out.println();
    		System.out.println("Seleccion la operacion:\n" +
    		    	"1: Agregar producto\n" +
    		    	"2: Agregar dinero\n" +
    		    	"3: Comprar producto\n" +
    		    	"4: Imprimir estado\n" +
    		    	"0: Finalizar" 
    		    	);
    		seleccion = leer.nextLine();
    		System.out.println();
    		switch(seleccion) {
    		case "1":
    			System.out.print("Dame el codigo del producto: ");
    			codigo = leer.nextLine();
    			System.out.print("Dame la descripcion del producto: ");
    			descripcion = leer.nextLine();
    			System.out.print("Dame el precio del producto: ");
    			dinero = leer.nextDouble();
    			operacion.agregarProducto(codigo, descripcion, dinero);
    			break;
    		case "2":
    			System.out.print("Dame el precio del producto: ");
    			dinero = leer.nextDouble();
    			operacion.agregarMoneda(dinero);
    			break;
    		case "3":
    			System.out.print("Dame el codigo del producto que quiere comprar: ");
    			codigo = leer.nextLine();
    			System.out.print("Inserte el dinero: ");
    			dinero = leer.nextDouble();
    			operacion.comprarProducto(codigo, dinero);
    			break;
    		case "4":
    			operacion.imprimirEstado();
    			break;	
    		case "0":
    			System.out.println("Fin de operaciones...");
    			break;	
    		default:
    			System.out.println("Seleccion invalida");
    			break;
    		}
    	}while(!seleccion.equals("0"));
     

	}

}