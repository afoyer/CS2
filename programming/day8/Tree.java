

public class Tree<K extends Comparable<K>, V> {
    TreeNode<K,V> root;
    TreeNode<K,V> curr;

    /**
     * Makes a new empty tree
     */
    public Tree() {
        root = null;
        curr = null;
    }

    /**
     * Places a new node in the tree
     * @param k key for the new node
     * @param v value for new node
     */
    public void insert(K k, V v) {
      //look at the root first
        curr = root;
        if(curr==null) {
            root=new TreeNode<K,V>(k,v);
            return;
        }
        //what to do if we arent inserting the root
        helper(k,v);
    }
    public void helper(K k, V v) {
        // Does the new node fit as a direct child
        if((k.compareTo(curr.getKey()) <0 && curr.getLeft()==null) || (k.compareTo(curr.getKey()) >0 && curr.getRight()==null) ){
            if(k.compareTo(curr.getKey())< 0) {
              //insert left child
                curr.setLeft(new TreeNode<K,V>(k,v));
            } else {
              //insert right child
                curr.setRight(new TreeNode<K,V>(k,v));
            }
            //work done for easy case
            return;
        }
        // Place the node with one of the children, based on if the key goes to the left or right
        if(k.compareTo(curr.getKey())< 0) { //moves down the tree to the left
            curr = curr.getLeft();
        } else { //moves down the tree to the right
            curr = curr.getRight();
        }
        helper(k,v);
    }

    //gets the value associated with a key
    //parameter: key to search for in Tree
    //return: value of the key
    public V fetch(K k) {
      //start at the root
        curr = root;
        //while we havent found the key
        while(k.compareTo(curr.getKey())!= 0) {
            if(k.compareTo(curr.getKey())> 0) { //go right
                curr = curr.getRight();
            } else { // go left
                curr = curr.getLeft();
            }
        }
        // We have found the key or ran out of children
        return curr.getValue();
    }
    public boolean fetchkey(K k) {
        //start at the root
        curr = root;
        //while we havent found the key

        while(k.compareTo(curr.getKey())!= 0) {
            if(k.compareTo(curr.getKey())> 0) { //go right
                if (curr.getRight() == null){
                    return true;
                }
                curr = curr.getRight();
            } else { // go left
                if (curr.getLeft() == null){
                    return true;
                }
                curr = curr.getLeft();

            }
        }
        // We have found the key or ran out of children
        return false;
    }

    // removes a ndode from the tree based on the key
    //k = key to remove
    public void remove(K k){
      //Find the node to remove and its parent
      TreeNode<K,V> parent = null;
      //start at the root
        curr = root;

        //while we havent found the key
        while(curr.getKey().compareTo(k) !=0) {
            if(k.compareTo(curr.getKey())> 0) {
                if(curr.getLeft() == null){
                    return;
                }
                parent = curr;
                curr = curr.getLeft();
            }
            else { // go left
                if(curr.getRight() == null){return;}
              parent = curr;
              curr = curr.getRight();

            }
        }
        // We have the node and its parent

      //Case 1: no children, remove the node
      if(curr.isLeaf()){
        if(parent.getRight() == curr){
          parent.setRight(null);
        }
        if(parent.getLeft() == curr){
          parent.setLeft(null);
        }
        curr = root;
        return;
      }
      //Case 2: one child, replace node with child
      if(curr.getRight() == null || curr.getLeft() == null){
        //Set parent to the point at the child
        if(curr.getRight()==null){
          if(parent.getRight() == curr){
            parent.setRight(curr.getLeft());
          }
          else{
            parent.setLeft(curr.getLeft());
          }
        }
        else{
          if(parent.getRight() == curr){
            parent.setRight(curr.getRight());
          }
          else{
            parent.setLeft(curr.getRight());
          }
        }
        curr = root;
        return;
      }
      //Case 3: two children, go right once, go left until you can't,
      //        remove that left most node, replace the node you wanted to remove
      //        with the left most node, move up grandchildren
      TreeNode<K,V> swapparent = curr;
      TreeNode<K,V> swapnode = curr.getRight(); //trying to find the one to swap into curr's place in the tree
      while(swapnode.getLeft() != null){
        swapparent = swapnode;
        swapnode = swapnode.getLeft();
      }
      // We have the left most node, set the left most parent to the right child
      swapparent.setLeft(swapnode.getRight());
      swapnode.setLeft(curr.getLeft());
      swapnode.setRight(curr.getRight());
      if(parent.getRight() == curr){
        parent.setRight(swapnode);
      }
      if(parent.getLeft() == curr){
        parent.setLeft(swapnode);
      }
      curr = root;
    }



}
