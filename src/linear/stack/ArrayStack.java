package linear.stack;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> array = null;
    public ArrayStack(int capacity){
        array = new ArrayList<>(capacity);
    }
    public ArrayStack(){
        array = new ArrayList<>();
    }
    @Override
    public void push(E e) {
        array.add(e);
    }

    @Override
    public E pop() {
       return array.remove(array.size() -1);
    }
    @Override
    public E peek() {
        return array.get(array.size()-1);
    }
    @Override
    public int getSIze() {
        return array.size();
    }
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for(E e:array){
          builder.append( e.toString()) ;
          builder.append( ",") ;
        }
        builder.append( "]top") ;
        return builder.toString();
    }
}
