package udelp.edu.estructura.tareas;
import udelp.edu.estructura.funcionesBanco.Metodos;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in); 
		String seleccion;
		String caja;
		String cuenta;
		String nombre;
		boolean tarjeta = false;
		double dinero;
		int fila = 0;
		Metodos operacion = new Metodos();
		
		do {
			System.out.println("Digite cualquiera de las siguiente opciones: \n" +
    		    	"1: Agregar dinero a la caja\n" +
    		    	"2: Cliente nuevo\n" + 
    		    	"3: Atender Cajas\n" + 
    		    	"0: Para cerrar servicios"
    		    	);
			seleccion = leer.nextLine();
			switch (seleccion) {
			case "1":
				System.out.println("¿Cuanto dinero desea agregar");
				dinero = leer.nextDouble();
				operacion.depositarDinero(dinero);
				break;
			case "2":
				System.out.println("¿Tiene cuenta en este banco?");
				System.out.println("Digite 1 si tiene cuenta en este banco");
				System.out.println("Digite 0 si no tiene cuenta en este banco");
				cuenta = leer.nextLine();
				System.out.println("Deme su nombre");
				nombre = leer.nextLine();
				if(cuenta.equalsIgnoreCase("1")) {
					tarjeta = true;
				}
				operacion.clienteNuevo(nombre, tarjeta);
				fila++;
				break;
			case "3":
				fila = operacion.cantidadDeClientes();
				while (fila != 0) {
				    for (int i = 1; i <= 4; i++) {
				        if (fila >= i) {
				            System.out.println("Bienvenido a caja " + i);
				            System.out.println("Digite cualquiera de las siguientes opciones: \n" +
				                               "1: Para depositar\n" +
				                               "2: Para retirar\n");
				            caja = leer.nextLine();
				            switch (caja) {
				                case "1":
				                    System.out.println("¿Cuánto dinero desea depositar?");
				                    dinero = leer.nextDouble();
				                    leer.nextLine();
				                    operacion.depositarDinero(dinero);
				                    break;
				                case "2":
				                    System.out.println("¿Cuánto dinero desea retirar?");
				                    dinero = leer.nextDouble();
				                    leer.nextLine(); 
				                    operacion.retirarDinero(dinero);
				                    break;
				                default:
				                    System.out.println("Selección no válida");
				                    break;
				            }
				        }
				    }
				    fila--;
				}
				break;
			case "0":
				System.out.println("Hora del cierre");
				break;
			default:	
				System.out.println("Seleccion no válida");
				break;
			}
		}while (!seleccion.equals("0"));
		
		
	}
}