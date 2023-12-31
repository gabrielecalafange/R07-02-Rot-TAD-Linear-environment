package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail + 1 == array.length;
	}

	private void shiftLeft() {
		for (int i = 1; i < array.length; i++) {
			this.array[i-1] = this.array[i];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (isFull()) {
			throw new QueueOverflowException();
		} 
		else {
			array[++tail] = element;}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T out = array[0];
			shiftLeft();
			return out;
		}
	}

}
