package linear.queue;


import java.util.LinkedList;

/**
 * 线性队列
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
   private LinkedList<E> linkedList ;
   public ArrayQueue(){
       linkedList = new LinkedList<E>();
   }

    @Override
    public void enqueue(E e) {
        linkedList.addLast(e);
    }
    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public E gerFront() {
        return linkedList.getLast();
    }

    @Override
    public int getSize() {
        return linkedList.size();
    }
    @Override
    public boolean isEmpty() {
       return linkedList.isEmpty();
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder("ArrayQueue:frount[");
       for(E e: linkedList){
           builder.append(e);
           builder.append(",");
       }
        builder.append("]tail");
        return builder.toString();
    }
}
