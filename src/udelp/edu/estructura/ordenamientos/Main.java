package udelp.edu.estructura.ordenamientos;
import udelp.edu.estructura.listas.DoubleLinkedList;
import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Random aleatorio = new Random();	
	Scanner leer = new Scanner(System.in);
	DoubleLinkedList lista = new DoubleLinkedList();	
	String elegir;
	int buscar;
	
	for(int i = 0; i < 20; i++) {
		lista.add(i, aleatorio.nextInt(0, 101));
	}
	System.out.println("Lista sin ordenar: ");
	System.out.println(lista.toString());
	System.out.println("Elige por que metodo se va a ordenar\n"+
	"1: Quick Sort\n"+
	"2: Shell Sort");
	elegir = leer.nextLine();
	switch (elegir) {
	case "1":
		Funciones.ordenamientoQuickSort(lista, (lista.size()));
		System.out.println("Lista ordenada");
		System.out.println("Que numero quiere buscar?");
		buscar = leer.nextInt();
		System.out.println("Indice: "+Funciones.busquedaBinaria(lista, lista.size(), buscar));
		System.out.println(lista.toString());
		
		break;
	case "2":
		Funciones.ordenamientoShellSort(lista, (lista.size()));
		System.out.println("Lista ordenada");
		System.out.println("Que numero quiere buscar?");
		buscar = leer.nextInt();
		System.out.println("Indice: "+Funciones.busquedaBinaria(lista, lista.size(), buscar));
		System.out.println(lista.toString());
		
		break;
	default:
		System.out.println("Seleccion invalida");
		break;
	}
	}

}
