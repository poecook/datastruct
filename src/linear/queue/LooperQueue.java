package linear.queue;


public class LooperQueue<E> implements Queue<E> {
    private E[] data;
    private int front,taill;
    private int size;
       public  LooperQueue(int capacity){
           data = (E[]) new Object[capacity];
        }
        public LooperQueue(){
           this(16);
        }
        @Override
        public void enqueue(E e) {
            if(taill+1/data.length == front)//这个时候队列就是满的了
                reSize(getCapacity()*2);//扩容
            data[taill] = e;
            taill = (taill+1)%data.length;
            size++;
        }
        private void reSize(int newSize){
           E[] newData = (E[]) new Object[newSize];
           for(int i = 0;i<data.length;i++){
               newData[i] = data[(i+front)%data.length];
           }
           data = newData;
           front = 0;
           taill = size;
        }
        @Override
        public E dequeue() {
           if(isEmpty())
               return null;
           E ret = data[front];
           data[front] = null;
           front = (front+1)%data.length;
           size -- ;

           if(size == getCapacity()/4)
               reSize(getCapacity()/2);
           return ret;
        }
        @Override
        public E gerFront() {
           if(isEmpty())
               throw new IllegalArgumentException("Queue is null");
            return data[front];
        }
        @Override
        public int getSize() {
            return size;
        }
        @Override
        public boolean isEmpty() {
            return front == taill;
        }
        public int getCapacity(){
           return data.length -1;
        }
}
