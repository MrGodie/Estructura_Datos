package udelp.edu.estructura.ordenamientos;
import udelp.edu.estructura.listas.DoubleLinkedList;
public class Funciones {
	
	public static void ordenamientoQuickSort(DoubleLinkedList lista, int n) {
	    int[] arreglo = new int[n];
	    for (int i = 0; i < n; i++) {
	        arreglo[i] = (int) lista.get(i);
	    }
	    quickSort(arreglo, 0, n - 1);
	    for (int i = 0; i < n; i++) {
	        lista.set(i, arreglo[i]);
	    }
	}

	private static void quickSort(int[] arreglo, int inicio, int fin) {
	    if (inicio < fin) {
	        int indiceParticion = particion(arreglo, inicio, fin);
	        quickSort(arreglo, inicio, indiceParticion - 1);
	        quickSort(arreglo, indiceParticion + 1, fin);
	    }
	}

	private static int particion(int[] arreglo, int inicio, int fin) {
	    int pivote = arreglo[fin]; 
	    int i = inicio - 1; 

	    for (int j = inicio; j < fin; j++) {
	        if (arreglo[j] <= pivote) {
	            i++;
	            int temp = arreglo[i];
	            arreglo[i] = arreglo[j];
	            arreglo[j] = temp;
	        }
	    }
	    int temp = arreglo[i + 1];
	    arreglo[i + 1] = arreglo[fin];
	    arreglo[fin] = temp;

	    return i + 1; 
	}
	
	public static void ordenamientoShellSort(DoubleLinkedList lista, int n) {
	    int[] arreglo = new int[n];
	    for (int i = 0; i < n; i++) {
	        arreglo[i] = (int) lista.get(i);
	    }
	    int gap = n / 2;
	    while (gap > 0) {
	        for (int i = gap; i < n; i++) {
	            int temp = arreglo[i];
	            int j = i;
	            while (j >= gap && arreglo[j - gap] > temp) {
	                arreglo[j] = arreglo[j - gap];
	                j -= gap;
	            }
	            arreglo[j] = temp;
	        }
	        gap /= 2; 
	    }


	    for (int i = 0; i < n; i++) {
	        lista.set(i, arreglo[i]);
	    }
	}
	
	public static int busquedaBinaria(DoubleLinkedList lista, int n, int objetivo) {
	    int[] arreglo = new int[n];
	    for (int i = 0; i < n; i++) {
	        arreglo[i] = (int) lista.get(i);
	    }
	    return busquedaBinaria(arreglo, 0, n - 1, objetivo);
	}

	private static int busquedaBinaria(int[] arreglo, int inicio, int fin, int objetivo) {
	    int indice = -1;
		while (inicio <= fin) {
	        int medio = inicio + (fin - inicio) / 2;


	        if (arreglo[medio] == objetivo) {
	            indice = medio; 
	            break;
	        }

	        
	        if (arreglo[medio] < objetivo) {
	            inicio = medio + 1;
	        }
	        
	        else {
	            fin = medio - 1;
	        }
	    }
	    return indice; 
	}
	 
}


