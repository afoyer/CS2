public class DLink<K extends Comparable<K>, V>{
    Node<K, V> head = null;
    Node<K, V> tail = null;
    Node<K, V> current = null;
    int size = 0;
    boolean firsttime = true;


    public void insert(int idx, V v, K k) {
        boolean appendcheck = false;
        if (size ==0) {
            Node<K, V> first = new Node(k, v,  null, null);
            first.setLeft(first);
            first.setRight(first);
            head = first;
            tail = first;
            current = first;
            firsttime = false;
        }
        else{
            if (idx == size) {
                append(k, v);
                appendcheck = true;
            }
            else {
                Node<K, V> head = this.head;
                if (idx == 0) {
                    head.setRight(head);
                    Node<K,V> tc = new Node(k, v, null, head);
                    tc.setLeft(tc);
                    head.setLeft(tc);
                    this.head = tc;
                }
                else if (idx == 1){
                    Node<K, V> tc = new Node(k, v, this.head, this.head.getRight());
                    this.head.setRight(tc);
                }
                else {
                    for (int i = 0; i < size; i++) {
                        if (i == idx) {
                            Node<K,V> tc = new Node(k, v, head.getLeft(), head);
                            tc.getLeft().setRight(tc);
                            tc.getRight().setLeft(tc);
                        } else {
                            head = head.getRight();
                        }
                    }

                }
            }
        }
        if (!appendcheck){
        size++;}


    }


    public void append(K k , V v) {
        Node<K,V> first = new Node(k, v, null, null);
        if (size == 0) {

            first.setLeft(first);
            first.setRight(first);
            head = first;
            tail = head;
            current = head;
            firsttime = false;
        }
        else{


            first.setLeft(tail);
            tail = first;
            first.setRight(first);
            first.getLeft().setRight(first);
        }
        size++;

    }

    public void remove() {
        if (current == head){
            head = current.getRight();
            head.setLeft(head);
            current = head;
        }
        else if (current == tail){
            current.getLeft().setRight(current.getLeft());
            current = current.getLeft();
            tail = current;
        }
        else {
            current.getLeft().setRight(current.getRight());
            current.getRight().setLeft(current.getLeft());
            current = current.getLeft();
        }
        size--;
    }

    public void remove(int idx) {
        Node<K, V> tc = head;
        if(idx == 0) {
            head.getRight().setLeft(head.getRight());
            head = head.getRight();
        }
        else{
            for (int i = 0; i< idx; i++){
                tc = tc.getRight();
            }
            tc.getLeft().setRight(tc.getLeft());
            tc.getRight().setLeft(tc.getLeft());
        }
        size--;

    }

    public void move(int sidx, int didx) {
        V temp = fetch(sidx);
        K tempkey = fetchkey(sidx);
        remove(sidx);
        insert(didx, temp, tempkey);

    }

    public V fetch() {
        return current.getValue();
    }
    public K fetchkey() {
        return current.getKey();
    }

    public V fetch(int idx) {
        Node<K,V> tc = head;
        for (int i = 0; i< idx; i++){
            tc = tc.getRight();
            }
        return tc.getValue();
    }
    public V fetch(K idx) {
        Node<K,V> tc = head;
        for (int i = 0; i< size; i++) {
            if (tc.getKey().compareTo(idx) == 0) {
                return tc.getValue();
            } else {
                tc = tc.getRight();
            }
        }
        return tc.getValue();}
    public K fetchkey(int idx) {
        Node<K,V> tc = head;
        for (int i = 0; i< idx; i++){
            tc = tc.getRight();
        }
        return tc.getKey();
    }




    public void next() {
        current = current.getRight();
    }

    public void prev() {
        current = current.getRight();
    }

    public void jumpToTail() {
        current = tail;
    }

    public void jumpToHead() {
        current = head;
    }

    public int size() {
        return size;
    }
}