package udelp.edu.estructura.funcionesBanco;
import udelp.edu.estructura.queue.BooleanPriorityQueue;
import udelp.edu.estructura.queue.CircularQueue;
public class Metodos {
	BooleanPriorityQueue clientes = new BooleanPriorityQueue();
	CircularQueue billetesDe1000 = new CircularQueue(50);
	CircularQueue billetesDe500 = new CircularQueue(50);
	CircularQueue billetesDe200 = new CircularQueue(50);
	CircularQueue billetesDe100 = new CircularQueue(50);
	CircularQueue billetesDe50 = new CircularQueue(50);
	CircularQueue billetesDe20 = new CircularQueue(50);
	CircularQueue monedasDe10 = new CircularQueue(50);
	CircularQueue monedasDe5 = new CircularQueue(50);
	CircularQueue monedasDe2 = new CircularQueue(50);
	CircularQueue monedasDe1 = new CircularQueue(50);
	CircularQueue monedasDe50Centavos = new CircularQueue(50);
	
	public void clienteNuevo(String cliente, boolean tarjeta) {
		clientes.enqueue(cliente, tarjeta);
	}
	
	public int cantidadDeClientes() {
		return clientes.size();
	}
	
	public void agregarDinero(double denominacion) {
        switch ((int) (denominacion * 10)) {
        case 10000:
        	if(!billetesDe1000.isFull()) {
        		billetesDe1000.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas billetes de 1000");
        	}
        	break;
        case 5000:
        	if(!billetesDe500.isFull()) {
        		billetesDe500.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas billetes de 500");
        	}
        	break;
        case 2000:
        	if(!billetesDe200.isFull()) {
        		billetesDe200.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas billetes de 200");
        	}
        	break;
        case 1000:
        	if(!billetesDe100.isFull()) {
        		billetesDe100.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas billetes de 100");
        	}
        	break;
        case 500:
        	if(!billetesDe50.isFull()) {
        		billetesDe50.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas billetes de 50");
        	}
        	break;
        case 200:
        	if(!billetesDe20.isFull()) {
        		billetesDe20.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas billetes de 20");
        	}
        	break;
        case 100:
        	if(!monedasDe10.isFull()) {
        		monedasDe10.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas monedas de 10");
        	}
        	break;
        case 50:
        	if(!monedasDe5.isFull()) {
        		monedasDe5.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas monedas de 5");
        	}
        	break;		
        case 20:
        	if(!monedasDe2.isFull()) {
        		monedasDe2.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas monedas de 2");
        	}
        	break;
        case 10:
        	if(!monedasDe1.isFull()) {
        		monedasDe1.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas monedas de 1");
        	}
        	break;	
        case 5:
        	if(!monedasDe50Centavos.isFull()) {
        		monedasDe50Centavos.enqueue(denominacion);
        	}else {
        		System.out.println("No hay espacio para mas monedas de 50 centavos");
        	}
        	break;	
        default:
            System.out.println("Denominación inválida.");
            break;
        }
    }
	

	public int depositarDinero(double dinero) {
	    int cambio = (int) (dinero * 10); 
	    while (cambio != 0) {
	        if(cambio >= 10000 && !billetesDe1000.isFull()) {
	        	cambio -= 10000;
	        	agregarDinero(1000);
	        }else if(cambio >= 5000 && !billetesDe500.isFull()){
	        	cambio -= 5000;
	        	agregarDinero(500);
	        }else if(cambio >= 2000 && !billetesDe200.isFull()){
	        	cambio -= 2000;
	        	agregarDinero(200);
	        }else if(cambio >= 1000 && !billetesDe100.isFull()){
	        	cambio -= 1000;
	        	agregarDinero(100);
	        }else if(cambio >= 500 && !billetesDe50.isFull()){
	        	cambio -= 500;
	        	agregarDinero(50);
	        }else if(cambio >= 200 && !billetesDe20.isFull()){
	        	cambio -= 200;
	        	agregarDinero(20);
	        }else if(cambio >= 100 && !monedasDe10.isFull()){
	        	cambio -= 100;
	        	agregarDinero(10);
	        }else if(cambio >= 50 && !monedasDe5.isFull()){
	        	cambio -= 50;
	        	agregarDinero(5);
	        }else if(cambio >= 20 && !monedasDe2.isFull()){
	        	cambio -= 20;
	        	agregarDinero(2);
	        }else if(cambio >= 10 && !monedasDe1.isFull()){
	        	cambio -= 10;
	        	agregarDinero(1);
	        }else if(cambio >= 5 && !monedasDe50Centavos.isFull()){
	        	cambio -= 5;
	        	agregarDinero(0.5);
	        }else if(cambio < 5){
	        	break;
	        }
	    }
	    return cambio;
	}
	
	public int retirarDinero(double dinero) {
	    int cambio = (int) (dinero * 10); 
	    while (cambio != 0) {
	        if(cambio >= 10000 && !billetesDe1000.isEmpty()) {
	        	cambio -= 10000;
	        	billetesDe1000.dequeue();
	        }else if(cambio >= 5000 && !billetesDe500.isEmpty()){
	        	cambio -= 5000;
	        	billetesDe500.dequeue();
	        }else if(cambio >= 2000 && !billetesDe200.isEmpty()){
	        	cambio -= 2000;
	        	billetesDe200.dequeue();
	        }else if(cambio >= 1000 && !billetesDe100.isEmpty()){
	        	cambio -= 1000;
	        	billetesDe100.dequeue();
	        }else if(cambio >= 500 && !billetesDe50.isEmpty()){
	        	cambio -= 500;
	        	billetesDe50.dequeue();
	        }else if(cambio >= 200 && !billetesDe20.isEmpty()){
	        	cambio -= 200;
	        	billetesDe20.dequeue();
	        }else if(cambio >= 100 && !monedasDe10.isEmpty()){
	        	cambio -= 100;
	        	monedasDe10.dequeue();
	        }else if(cambio >= 50 && !monedasDe5.isEmpty()){
	        	cambio -= 50;
	        	monedasDe5.dequeue();
	        }else if(cambio >= 20 && !monedasDe2.isEmpty()){
	        	cambio -= 20;
	        	monedasDe2.dequeue();
	        }else if(cambio >= 10 && !monedasDe1.isEmpty()){
	        	cambio -= 10;
	        	monedasDe1.dequeue();
	        }else if(cambio >= 5 && !monedasDe50Centavos.isEmpty()){
	        	cambio -= 5;
	        	monedasDe50Centavos.dequeue();
	        }else if(cambio < 5){
	        	break;
	        }
	    }
	    return cambio;
	}
	
	public void imprimirEstado() {
        System.out.println("Clientela:");
        clientes.toString();
        System.out.println();
        System.out.println("Estado de las monedas:");
        System.out.println("Billetes de 1000: " + billetesDe1000.size());
        System.out.println("Billetes de 500: " + billetesDe500.size());
        System.out.println("Billetes de 200: " + billetesDe200.size());
        System.out.println("Billetes de 100: " + billetesDe100.size());
        System.out.println("Billetes de 20: " + billetesDe20.size());
        System.out.println();
        System.out.println("Estado de las monedas:");
        System.out.println("Monedas de 10: " + monedasDe10.size());
        System.out.println("Monedas de 5: " + monedasDe5.size());
        System.out.println("Monedas de 2: " + monedasDe2.size());
        System.out.println("Monedas de 1: " + monedasDe1.size());
        System.out.println("Monedas de 0.50: " + monedasDe50Centavos.size());
    }

}
