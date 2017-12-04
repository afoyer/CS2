public class SingleNode<T> implements ISLink<T> {
    T value;
    ISLink next;

    public SingleNode(T v, ISLink<T> next){
        value = v;
        this.next = next;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T v) {value = v;
    }

    public ISLink<T> getNext() {
        return next;
    }

    public void setNext(ISLink<T> c) {
        next = c;
    }
}
