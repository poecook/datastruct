package linear.queue;

public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E gerFront();
    int getSize();
    boolean isEmpty();
}
