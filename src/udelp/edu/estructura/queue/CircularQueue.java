package udelp.edu.estructura.queue;
public class CircularQueue {
	private int f;
	private int r;
	private Object[]queue;
	private int size;
	
	public CircularQueue(int size) {
		f = 0;
		r = 0;
		queue = new Object[size];
		this.size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull() {
		return size == queue.length;
	}
	
	public void enqueue(Object value) {
		if(!isFull()) {
			queue[f]=value;
			f++;
			size++;
			if(f == queue.length) {
				f=0;
			}
		}
	}
	
	public Object dequeue() {
		Object value = null;
		if(!isEmpty()) {
			value=queue[r];
			queue[r]=null;
			r++;
			size--;
			if(r == queue.length) {
				r=0;
			}
		}
		return value;
	}
	
	public Object front() {
		Object value=null;
		if(!isEmpty()) {
			int tempF = f-1;
			tempF=tempF==-1?queue.length-1:tempF;
			value=queue[tempF];
		}
		return value;
	}
	
	public Object rear() {
		return queue[r];
	}
	
	public String toString() {
		String s="";
		for(int i=0; i < size; i++) {
			int tempI = i+r;
			tempI = tempI==queue.length-1?0:tempI;
			s+=queue[i]+">";
		}
		return s;
	}

}
