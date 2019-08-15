public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e){
        if ((tail + 1 ) % data.length == front) {
            resize(getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1 ) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // because data not start with 0 but front
            newData[i] = data[(i + front) % data.length];
        }
        data = newData; // 保证get correct capacity
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue(){
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == data.length / 4 && getCapacity() / 2 != 0) {
            resize(data.length / 2 );
        }
        return res;
    }

    @Override
    public E getFront(){
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }
        return data[front];
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d \n", size, getCapacity()));
        res.append("Queue: Front [");
        //                             be careful about updating the index in the loop
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            // not reaching the tail
            if ((i + 1) % data.length != tail ) {
                res.append(", ");
            }
        }
        res.append("] end");
        return res.toString();
    }

    public static void main(String[] args) {
        // write your code here
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
