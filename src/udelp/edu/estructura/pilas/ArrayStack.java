package udelp.edu.estructura.pilas;

public class ArrayStack {
	private Object[]stack;
	private int a;
	
	public ArrayStack(int size) {
		this.stack=new Object[size];
		this.a=0;
	}
	public int size() {
		return a;
	}
	public boolean isEmpty(){
		return a == 0;
	}
	public boolean isFull() {
		return a == stack.length;
	}
	public Object peak() {
		Object val=null;
		if(!isEmpty()) {
			val=stack[a-1];
		}
		return val;
	}
	public void push (Object val) {
		if(!isFull()) {
			stack[a]=val;
			a++;
		}
	}
	public Object pop() {
		Object val=null;
		if(!isEmpty()) {
			a--;
			val=stack[a];
			stack[a]=null;
		}
		return val;
	}
	public String toString() {
		String s="";
		for(int i=0; i < a; i++) {
			s+=stack[i]+"-";
		}
		return s;
	}

}
