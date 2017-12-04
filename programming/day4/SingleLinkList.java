public class SingleLinkList<T> implements IList<T> {
    ISLink<T> head = null;
    ISLink<T> tail = null;
    ISLink<T> current = null;
    int curcount = 0;
    int size = 0;
    boolean firsttime = true;

    public void insert(int idx, T v) {
        boolean appendcheck = false;
        if (firsttime) {
            ISLink<T> first = new SingleNode(v, null);
            first.setNext(first);
            head = first;
            tail = first;
            current = first;
            firsttime = false;
        }
        else{
            if (idx == size) {
                append(v);
                appendcheck = true;
            }
            else {
                ISLink<T> head = this.head;
                if (idx == 0) {
                    head.setNext(head);
                    ISLink<T> tc = new SingleNode(v, head);
                    this.head = tc;
                }
                else if (idx == 1){
                    ISLink<T> tc = new SingleNode(v,this.head.getNext());
                    tc.setNext(this.head.getNext());
                    this.head.setNext(tc);
                }
                else {
                    for (int i = 0; i < idx-1; i++) {
                        head = head.getNext();
                    }
                    ISLink<T> tc = new SingleNode(v,head.getNext());
                    head.setNext(tc);


                }
            }
        }
        if (!appendcheck){
            size++;}
    }

    public void append(T v) {
        ISLink<T> first = new SingleNode(v,null);
        if (firsttime) {
            first.setNext(first);
            head = first;
            tail = head;
            current = head;
            firsttime = false;
        }
        else{

            first.setValue(v);
            tail.setNext(first);
            tail = first;
        }
        size++;

    }


    public void remove() {
        prev();
        remove(curcount);
    }

    public void remove(int idx) {
        ISLink<T> tc = head;
        if(idx == 0) {
            this.head = head.getNext();
        }
        else {
            for (int i = 0; i < idx-1; i++) {
                tc = tc.getNext();
                }


            tc.setNext(tc.getNext().getNext());
        }
        size--;
    }

    public void move(int sidx, int didx) {
        T temp = fetch(sidx);
        remove(sidx);
        insert(didx, temp);
    }

    public T fetch() {
        return current.getValue();
    }


    public T fetch(int idx) {
        ISLink<T> tc = head;
        for (int i = 0; i< idx; i++){
            tc = tc.getNext();
        }
        return tc.getValue();
    }



    public void next() {

        current = current.getNext();
        if (curcount == size){

        }
        else {
            curcount++;
        }
    }

    public void prev() {
        if (current == head){

        }
        else{
            ISLink<T> tc = head;
            for(int i = 0; tc.getNext() != current; i++){
                    tc = tc.getNext();
                }
                current = tc;
            curcount--;
            }
        }


    public void jumpToTail() {
        current = tail;
        curcount = size-1;
    }

    public void jumpToHead() {
        current = head;
        curcount = 0;
    }

    public int size() {
        return size;
    }
}
