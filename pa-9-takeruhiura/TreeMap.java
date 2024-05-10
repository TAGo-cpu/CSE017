/**
 * this is a class that is an implementation of a BST to a TreeMap
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/17
 */
import java.util.Comparator;
/**
 * Generic Class to implement a Binary Search Tree
 */
public class TreeMap<K, V> {
    // data members
    private TreeNode root;
    private int size;
    private Comparator<K> comp;
    /**
     * Inner class TreeNode
     */
    private class TreeNode{
        public MapEntry<K, V> value;
        public TreeNode left;
        public TreeNode right;

        /**
         * this is a constructor used to make a TreeNode
         * @param key this is the K value for the key of the tree node
         * @param value this is the V value for the value of the tree node
         */
        TreeNode(K key, V value){
            this.value = new MapEntry<>(key, value);
        }
    }
    /**
     * Default Constructor
     */
    public TreeMap(){ 
        comp = null;
        root = null;
        size = 0; 

    }

    /**
     * this is a constructor for a TreeMap that takes in a comparator
     * @param c this is a comparator used in the tree map
     */
    public TreeMap(Comparator<K> c){ 
        comp = c;
        root = null;
        size = 0; 

    }
    /**
     * Method size
     * @return the number of nodes in the tree
     */
    public int size() { 
        return size; 
    }
    /**
     * Method isEmpty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() { 
        return (size == 0); 
    }
    /**
     * Method to clear the tree
     */
    public void clear() { 
        root = null; 
        size = 0;
    }

    /**
     * search method to see if a key is in the Tree Map
     * @param k the K value being searched
     * @return true if value is found in the tree, false otherwise
     */
    public boolean contains(K k){
        if(root == null){
            return false;
        }
        TreeNode node = root;
        if(comp == null){
            while(node != null){
                if(((Comparable)k).compareTo(node.value.getKey()) < 0)
                    node = node.left; // go left
                else if (((Comparable)k).compareTo(node.value.getKey())> 0)
                    node = node.right; // go right
                else
                    return true;
            }
            return false;
        } else{
            while(node != null){
                if(comp.compare(k, node.value.getKey()) < 0)
                    node = node.left; // go left
                else if (comp.compare(k, node.value.getKey())> 0)
                    node = node.right; // go right
                else
                    return true;
            }
            return false;
        }
        
    }

    /**
     *  Method add to add a new node to the tree
     * @param k the key value for the MapEntry being added
     * @param v the value for the MapEntry being added
     * @return true if value is not found in the tree and a new node added, false if value already exists in the tree
     */
    public boolean add(K k, V v) {
        if (root == null)
            root = new TreeNode(k, v);
        else {
            TreeNode parent, node;
            parent = null; node = root;
            while (node != null) {
                parent = node;
                if(comp == null){
                    if(((Comparable)k).compareTo(node.value.getKey()) < 0) {
                        node = node.left; 
                    }
                    else if (((Comparable)k).compareTo(node.value.getKey()) > 0) {
                        node = node.right;
                    }
                    else
                        return false;// duplicates are not allowed
                }else{
                    if(comp.compare(k, node.value.getKey()) < 0) {
                        node = node.left; 
                    }
                    else if (comp.compare(k, node.value.getKey()) > 0) {
                        node = node.right;
                    }
                    else
                        return false;// duplicates are not allowed
                }

            }
            if (((Comparable)k).compareTo(parent.value.getKey())< 0)
                parent.left = new TreeNode(k, v);
            else
                parent.right = new TreeNode(k, v);
        }
        size++;
        return true; 
    }

    /**
     * Method remove to remove a value from the tree
     * @param k  k value to be removed if found in the tree
     * @return true is value was found and removed, false if value was not found
     */
    public boolean remove(K k) {
        TreeNode parent, node;
        parent = null; node = root;
        // Find value first
        while (node != null) {
            if(comp == null){
                if (((Comparable)k).compareTo(node.value.getKey()) < 0) {
                    parent = node;
                    node = node.left;
                }
                else if (((Comparable)k).compareTo(node.value.getKey()) > 0) {
                    parent = node;
                    node = node.right;
                }
                else
                    break; 
            }else{
                if (comp.compare(k, node.value.getKey()) <  0) {
                    parent = node;
                    node = node.left;
                }
                else if (comp.compare(k, node.value.getKey()) > 0) {
                    parent = node;
                    node = node.right;
                }
                else
                    break; 
            }

        }
        if (node == null) // value not in the tree
            return false;
        // Case 1: node has no children
        if(node.left == null && node.right == null){
            if(parent == null){
                root = null; size = 0;
            }
            else
                if(parent.left == node)
                    parent.left = null;
                else
                    parent.right = null;
        }
        else if(node.left == null){ 
        //case 2: node has one right child
            if (parent == null) 
                root = node.right;
            else
                if(parent.left == node)
                    parent.left = node.right;
                else
                    parent.right = node.right;
        }
        else if(node.right == null){ 
        //case 2: node has one left child
            if (parent == null)
                root = node.left;
            else
                if(parent.left == node)
                    parent.left = node.left;
                else
                    parent.right = node.left;
        } 

        else { 
        // case 3: node has two children
            TreeNode rightMostParent = node;
            TreeNode rightMost = node.left;
            while (rightMost.right != null) {
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            node.value = rightMost.value;
            if(rightMostParent.left == rightMost)
                rightMostParent.left = rightMost.left;
            else
                rightMostParent.right = rightMost.left;
        }
        size--;
        return true;
    }
    
    /**
     * Inorder Traversal Method
     * */
    public void inorder() {
        inorder(root);
    }
    /**
     * Inorder Traversal Recursive Helper Method
     * @param node where the recursive method starts
     * */
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
    /**
     * Preorder Traversal Method
     * */
    public void preorder() {
        preorder(root);
    }
    /**
     * Preorder Traversal Recursive Helper Method
     * @param node where the recursive method starts
     * */
    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    /**
     * Postorder Traversal Method
     * */
    public void postorder() {
        postorder(root);
    }
    /**
     * Postorder Traversal Recursive Helper Method
     * @param node where the recursive method starts
     * */
    private void postorder(TreeNode node)  {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " "); 
        }
    }

    //time complexity: O(log(n)) best case when unsorted and O(n) worst case when sorted
    /**
     * returns a MapEntry with the lowest key in the map and null if the map is empty
     * @return returns a MapEntry or null
     */
    public MapEntry<K,V> first(){
        if (root == null){
            return null;
        }
        TreeNode node = root;
        TreeNode parentNode = null;
        while(node != null){
            parentNode = node;
            node = node.left;
        }
        return parentNode.value;    
    }

    //time complexity: O(log(n)) best case when unsorted and O(n) worst case when sorted
    /**
     * returns the MapEntry with the highest key in the tree map and null if the map is empty
     * @return returns a MapEntry or null
     */
    public MapEntry<K,V> last(){
        if (root == null){
            return null;
        }
        TreeNode node = root;
        TreeNode parentNode = null;
        while(node != null){
            parentNode = node;
            node = node.right;
        }
        return parentNode.value;   
    }

    //time complexity: O(log(n)) best case when unsorted and O(n) worst case when sorted
    /**
     * returns the MapEntry with the least key that is greater than or equal to k and null if the tree is empty or k is greater than all keys in the tree
     * @param k this is the K value used in the method to find a key
     * @return returns a MapEntry or null
     */
    public MapEntry<K, V> ceiling(K k){
        if(root == null){
            return null;
        }
        TreeNode node = root;
        MapEntry<K,V> parentValue = null;
        if(comp == null){
            while(node != null){
                if(((Comparable)k).compareTo(node.value.getKey()) > 0){
                    node = node.right;
                }
                else if(((Comparable)k).compareTo(node.value.getKey()) < 0){
                    parentValue = node.value;
                    node = node.left;
                }
                else{
                    return node.value;
                }
            }
        } else{
            while(node != null){
                if(comp.compare(k, node.value.getKey()) > 0){
                    node = node.right;
                }
                else if(comp.compare(k, node.value.getKey()) < 0){
                    parentValue = node.value;
                    node = node.left; 
                }
                else{
                    return node.value;
                }
    
            }  
        }
        return parentValue;
    }

    
    //time complexity: O(log(n)) best case when unsorted and O(n) worst case when sorted
    /**
     * this is a method that returns a MapEntry with a key that is greatest and less than or equal to k and null if the map is empty or k is less than all keys in the tree
     * @param k this is the K value used in the method to find a MapEntry
     * @return returns a MapEntry or null
     */
    public MapEntry<K, V> floor(K k){
        if(root == null){
            return null;
        }
        TreeNode node = root;
        MapEntry<K,V> parentValue = null;
        if(comp == null){
            while(node != null){
                if(((Comparable)k).compareTo(node.value.getKey()) > 0){
                    parentValue = node.value;
                    node = node.right;
                }
                else if(((Comparable)k).compareTo(node.value.getKey()) < 0){
                    node = node.left;
                }
                else{
                    return node.value;
                }
            }
        } else{
            while(node != null){
                if(comp.compare(k, node.value.getKey()) > 0){
                    parentValue = node.value;
                    node = node.right;
                }
                else if(comp.compare(k, node.value.getKey()) < 0){
                    node = node.left; 
                }
                else{
                    return node.value;
                }
    
            }  
        }

        return parentValue;
    }

}