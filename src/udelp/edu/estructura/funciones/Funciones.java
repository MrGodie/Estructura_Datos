package udelp.edu.estructura.funciones;
import udelp.edu.estructura.queue.CircularQueue;
public class Funciones {
	CircularQueue productos = new CircularQueue(10);
	CircularQueue monedasDe10 = new CircularQueue(15);
	CircularQueue monedasDe5 = new CircularQueue(15);
	CircularQueue monedasDe2 = new CircularQueue(15);
	CircularQueue monedasDe1 = new CircularQueue(15);
	CircularQueue monedasDe50Centavos = new CircularQueue(15);
	
	public void agregarProducto(String codigo, String descripcion, double precio) {
		if(!productos.isFull()) {
			productos.enqueue(codigo + "," + descripcion + "," + precio);
		}else {
			System.out.println("Ya no hay espacio para productos");
		}
	}
	
	public void agregarMoneda(double denominacion) {
        switch ((int) (denominacion * 10)) {
            case 100:
                if (!monedasDe10.isFull()) {
                    monedasDe10.enqueue(denominacion);
                } else {
                    System.out.println("No se pueden agregar más monedas de 10.");
                }
                break;
            case 50:
                if (!monedasDe50Centavos.isFull()) {
                    monedasDe50Centavos.enqueue(denominacion);
                } else {
                    System.out.println("No se pueden agregar más monedas de 0.50.");
                }
                break;
            case 5:
                if (!monedasDe5.isFull()) {
                    monedasDe5.enqueue(denominacion);
                } else {
                    System.out.println("No se pueden agregar más monedas de 5.");
                }
                break;
            case 2:
                if (!monedasDe2.isFull()) {
                    monedasDe2.enqueue(denominacion);
                } else {
                    System.out.println("No se pueden agregar más monedas de 2.");
                }
                break;
            case 1:
                if (!monedasDe1.isFull()) {
                    monedasDe1.enqueue(denominacion);
                } else {
                    System.out.println("No se pueden agregar más monedas de 1.");
                }
                break;
            default:
                System.out.println("Denominación inválida.");
                break;
        }
    }
	
	public void comprarProducto(String codigo, double dinero) { 
	    String productoDeCompra = "";
	    double cambio;
	    if (!productos.isEmpty()) {
	        int n = productos.size();
	        for (int i = 0; i < n; i++) {
	            String producto = (String) productos.dequeue();
	            productos.enqueue(producto);
	            String[] datosProducto = producto.split(",");
	            if (codigo.equals(datosProducto[0])) {
	                productoDeCompra = producto;
	                break;
	            }
	        }
	    }
	    
	    if (productoDeCompra.isEmpty()) {
	        System.out.println("El producto ingresado no existe");
	    } else {
	        String[] datosCompra = productoDeCompra.split(",");
	        double precioProducto = Double.parseDouble(datosCompra[2]);
	        
	        if (dinero < precioProducto) {
	            System.out.println("Dinero ingresado insuficiente");
	        } else {
	            cambio = dinero - precioProducto;
	            int cambioRestante = darCambio(cambio);
	            if (cambioRestante == 0) {
	                System.out.println("Venta exitosa:\n" +
	                    "Descripcion: " + datosCompra[1] + "\n" +
	                    "Codigo: " + datosCompra[0] + "\n" +
	                    "Precio: " + datosCompra[2] + "\n" +
	                    "Cambio: " + cambio
	                );
	            } else {
	            	System.out.println(cambio);
	                System.out.println("Cambio insuficiente");
	            }
	        }
	    }
	}

	private int darCambio(double dinero) {
	    int cambio = (int) Math.round(dinero * 10); 
	    
	    while (cambio != 0) {
	        if (cambio >= 100 && !monedasDe10.isEmpty()) {
	            monedasDe10.dequeue();
	            cambio -= 100;
	        } else if (cambio >= 50 && !monedasDe5.isEmpty()) {
	            monedasDe5.dequeue();
	            cambio -= 50;
	        } else if (cambio >= 20 && !monedasDe2.isEmpty()) {
	            monedasDe2.dequeue();
	            cambio -= 20;
	        } else if (cambio >= 10 && !monedasDe1.isEmpty()) {
	            monedasDe1.dequeue();
	            cambio -= 10;
	        } else if (cambio >= 5 && !monedasDe50Centavos.isEmpty()) {
	            monedasDe50Centavos.dequeue();
	            cambio -= 5;
	        } else {
	            break;
	        }
	    }
	    
	    return cambio;
	}
	
	public void imprimirEstado() {
        System.out.println("Productos en la máquina:");
        for (int i = 0; i < productos.size(); i++) {
        	String p = (String) productos.dequeue();
            productos.enqueue(p);
            String partes[] = p.split(",");
            System.out.println("Codigo: " + partes[0]);
            System.out.println("Descripcion: " + partes[1]);
            System.out.println("Precio: " + partes[2]);
        }
        System.out.println();
        System.out.println("Estado de las monedas:");
        System.out.println("Monedas de 10: " + monedasDe10.size());
        System.out.println("Monedas de 5: " + monedasDe5.size());
        System.out.println("Monedas de 2: " + monedasDe2.size());
        System.out.println("Monedas de 1: " + monedasDe1.size());
        System.out.println("Monedas de 0.50: " + monedasDe50Centavos.size());
    }
}




