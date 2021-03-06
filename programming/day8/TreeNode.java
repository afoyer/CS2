public class TreeNode<K,V> {
    K key;
    V value;
    TreeNode<K, V> left;
    TreeNode<K, V> right;

    /**
     * Makes a shiny new Node
     * @param k the key
     * @param v the value
     */
    public TreeNode(K k, V v) {
        key = k;
        value = v;
    }

    /**
     * Sets the left child of this node
     * @param l the new left child
     */
    public void setLeft(TreeNode<K, V> l) {
        left = l;
    }

    /**
     * Sets the right child of this node
     * @param r the new left child
     */
    public void setRight(TreeNode<K, V> r) {
        right = r;
    }

    /**
     * Gets the left child
     * @return left child
     */
    public TreeNode<K, V> getLeft() {
        return left;
    }
    /**
     * Gets the right child
     * @return right child
     */
    public TreeNode<K ,V> getRight() {
        return right;
    }

    /**
     * Checks if the node is a leaf
     * @return true if the node is a leaf
     */
    public boolean isLeaf() {
        if(left==null && right==null) {
            return true;
        }
        return false;
    }

    /**
     * Gets the key for this node
     * @return the key value
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value for this node
     * @return the node value
     */
    public V getValue() {
        return value;
    }

    public int inorder(K[] keys, int nextpos){
        if(getLeft() != null && getRight() != null) {
            nextpos = getLeft().inorder(keys, nextpos);
            keys[nextpos] = getKey();
            nextpos++;
            return getRight().inorder(keys, nextpos);
        }
        else if (getLeft() != null && getRight() ==null){
            nextpos = getLeft().inorder(keys, nextpos);
            keys[nextpos] = getKey();
            nextpos++;
            return nextpos;
        }
        else if (getLeft() == null && getRight() != null){
            keys[nextpos] = getKey();
            nextpos++;
            return getRight().inorder(keys, nextpos) ;
        }
        else{
            keys[nextpos] = getKey();
            nextpos++;
            return nextpos;
        }

    }
}
