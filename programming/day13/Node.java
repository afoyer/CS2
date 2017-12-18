public class Node<T> implements IDLink<T>  {
    T value;
    IDLink prev;
    IDLink next;

    public Node(T v, IDLink<T> prev, IDLink<T> next){
        value = v;
        this.prev = prev;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T v) {
        value = v;

    }

    public IDLink<T> getNext() {
        return next;
    }

    public IDLink<T> getPrev() {
        return prev;
    }

    public void setNext(IDLink<T> c) {
        next = c;
    }

    public void setPrev(IDLink<T> c) {
        prev = c;
    }
}
