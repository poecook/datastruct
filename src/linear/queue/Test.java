package linear.queue;

public class Test {

    public static void main(String[] args){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
    }
}
