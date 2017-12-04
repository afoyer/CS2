public class RingQueue<T> implements IQueue<T>{
    T[] queue;
    int header = 0;
    int back = 0;
    public RingQueue(int size){
        queue = (T[]) new Object[size];
    }

    public T dequeue() throws UnderFlowException {
        T val = queue[header];
        header++;
        return val;
    }

    public void enqueue(T v) throws OverFlowException {
        queue[back] = v;
        back++;
    }
}
