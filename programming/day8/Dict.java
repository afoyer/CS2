public class Dict<K extends Comparable<K>, V> implements IDict<K, V>{
    DLink<K, V> list = new DLink<>();
    public V add(K k, V v) {
        for (int i = 0; i <list.size; i++){
            if (list.fetchkey(i).compareTo(k) == 0){
                list.remove(i);
                list.insert(i,v,k);
                return list.fetch(i);
            }
        }
        list.append(k, v);
        return list.fetch(list.size-1);
    }

    public V remove(K k) {
        for (int i = 0; i <list.size; i++){
            if (list.fetchkey(i).compareTo(k) == 0){
                V value = list.fetch(i);
                list.remove(i);
                return value;
            }
        }
        return null;
    }

    public int size() {
        return list.size;
    }

    public V fetch(K k) {
        return list.fetch(k);
    }

    public K[] keys() {
        K[] keys = (K[]) new Object[list.size];
        for (int i = 0; i<keys.length; i++){
            keys[i] = list.fetchkey(i);
        }
        return keys;
    }
}
