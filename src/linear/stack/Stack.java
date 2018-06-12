package linear.stack;

public interface Stack<E> {
    void push(E e);
    E pop();
    E peek();
   int getSIze();
   boolean isEmpty();

}
