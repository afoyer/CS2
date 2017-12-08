public class BSTree<K extends Comparable<K>, V> implements IDict<K,V> {
    Tree<K,V> tree = new Tree<>();
    int size = 0;
    public V add(K k, V v) {
        if (size == 0) {
            tree.insert(k,v);
        }
        else if(tree.fetchkey(k)){
            tree.remove(k);
            tree.insert(k,v);

        }else{
            tree.insert(k,v);
        }
        size++;
        return tree.fetch(k);
    }

    public V remove(K k) {
        V val = tree.fetch(k);
        tree.remove(k);
        size--;
        return val;
    }

    public int size() {
        return size;
    }

    public V fetch(K k) {
        return tree.fetch(k);
    }

    public K[] keys() {
        K[] keys = (K[]) new Object[size];
        tree.root.inorder(keys, 0);
        return keys;
    }
}
