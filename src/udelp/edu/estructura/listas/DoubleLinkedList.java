package udelp.edu.estructura.listas;
import udelp.edu.estructura.nodos.DoubleNodo;

public class DoubleLinkedList {
	private int size;
	private DoubleNodo a;


	public DoubleLinkedList() {
		size=0;
		a=null;
	}

	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public Object get(int index) {
		Object value=null;
		if(index>=0&&index<size&&!isEmpty()) {
			DoubleNodo actual=a;
			for(int i=size-1;i>index;i--) {
				actual=actual.getDerecha();
			}
			value=actual.getValor();



		}
		return value;
	}
	
	public Object set(int index,Object value) {
		Object returnVal=null;
		if(index>=0&&index<size&&!isEmpty()) {
			DoubleNodo actual=a;
			for(int i=size-1;i>index;i--) {
				actual=actual.getDerecha();
			}
			returnVal=actual.getValor();
			actual.setValor(value);	
		}
		return returnVal;
	}
	public void add(Object value) {
		DoubleNodo n=new DoubleNodo();
		n.setValor(value);
		if(isEmpty()) {
			a=n;
		}else {
			DoubleNodo actual=a;
			while(null!= actual.getDerecha()) {
				actual=actual.getDerecha();
			}
			actual.setDerecha(n);
			n.setIzquierda(actual);
		}
		size++;


	}

	public void add(int index,Object value) {
		DoubleNodo n=new DoubleNodo();
		n.setValor(value);
		if(index==0&&!isEmpty()) {

			a.setIzquierda(n);
			n.setDerecha(a);
			a=n;
			size++;

		}else if(index>0&&index<size) {
			DoubleNodo actual=a;
			for(int i=0;i<=index;i++) {
				actual=actual.getDerecha();
			}
			DoubleNodo anterior=actual.getIzquierda();
			actual.setIzquierda(n);
			anterior.setDerecha(n);
			n.setDerecha(actual);
			n.setIzquierda(anterior);
			size++;

		}else if(index==size) {
			add(value);
		}
	}
	public Object remove(int index) {
		Object value= null;
		if(!isEmpty()) {
			size--;
			if (index==0) {
				value=a.getValor();
				DoubleNodo actual=a;
				
			
				a=a.getDerecha();
				actual.setDerecha(null);
				a.setIzquierda(null);
			} else if (index>0&&index<size) {
				DoubleNodo actual= a;
				for(int i =0;i<index;i++) {
					actual=actual.getDerecha();
				}
				value=actual.getValor();
				DoubleNodo anterior= actual.getIzquierda();
				DoubleNodo siguiente = actual.getDerecha();
				
				actual.setDerecha(null);
				actual.setIzquierda(null);
				anterior.setDerecha(siguiente);
				siguiente.setIzquierda(anterior);
				
			} else if (index==size) {
				DoubleNodo actual= a;
				while(null!= actual.getDerecha()) {
					actual=actual.getDerecha();
				}
				value=actual.getValor();
				DoubleNodo anterior = actual.getIzquierda();
				anterior.setDerecha(null);
				actual.setIzquierda(null);

			}
		
		}
		return value;
	}
	
	public String toString() {
		String s="";
		DoubleNodo temp=a;
		while(null!=temp) {
			s=s+temp.getValor()+" ";
			temp=temp.getDerecha();
		}
		return s;
	}



}

