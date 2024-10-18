package udelp.edu.estructura.nodos;
public class DoubleNodo {
	private Object valor;
	private DoubleNodo izquierda;
	private DoubleNodo derecha;
	
	public Object getValor() {
		return valor;
	}
	
	public DoubleNodo getIzquierda(){
		return izquierda;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public void setIzquierda(DoubleNodo enlace) {
		this.izquierda = enlace;
	}
	
	public void setDerecha(DoubleNodo enlace) {
		this.derecha = enlace;
	}
	
	public DoubleNodo getDerecha(){
		return derecha;
	}

}
