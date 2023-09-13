package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		this.array = (T[]) new Object[size];
		this.top = -1;
	}

	@Override
	public T top() {
		if (this.top != -1)
			return array[top];
		return null;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
		} 
		array[++this.top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		return array[this.top--];
	}

}
