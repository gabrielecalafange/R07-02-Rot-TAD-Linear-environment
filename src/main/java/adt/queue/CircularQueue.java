package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		this.array = (T[]) new Object[size];
		this.head = -1;
		this.tail = -1;
		this.elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();
		} else if (isEmpty()) {
			this.head = 0;
			this.tail = 0;
			this.array[head] = element;
		} else {
			tail = (tail + 1) % array.length;
			this.array[tail] = element;
		} elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} 

		T element = array[head];

		if (head == tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (head + 1) % array.length;
		}
		
		return element;
	}

	@Override
	public T head() {
		if (this.head != -1)
			return array[head];
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (this.elements == 0);
	}

	@Override
	public boolean isFull() {
		return (this.elements == array.length);
	}

}
