public class LinkStack<T> implements IStack<T> {
    Cell<T> top= null;
    int size;

    public void push(T v) throws OverFlowException {
        Cell<T> n = new Cell<>(v, top);
        top = n;
        size++;
    }

    public T pop() throws UnderFlowException {
        if (size == 0){
            throw new UnderFlowException();
        }
        T temp = top.getValue();
        top = top.getPointer();
        size--;
        return temp;
    }
}
