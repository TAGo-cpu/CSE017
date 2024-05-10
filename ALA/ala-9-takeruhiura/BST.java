import java.util.Iterator;
import java.util.ArrayList;
/**
 * this is a modified class for BST
 * @author Takeru Hiura
 * @version Java 11 / VSCode
 * @since 2024-4/16
 */

public class BST<E extends Comparable<E>> {
    private TreeNode root;
    private int size;

    /**
     * this is a private class for a TreeNode in the BST used for a root
     */
    private class TreeNode{
        E value;
        TreeNode left;
        TreeNode right;
        TreeNode(E val){
            value = val;
            left = right = null;
        }
    }

    public static int removeIterations, containsIterations, addIterations;


    /**
     * this is a constructor for the BST
     */
    BST(){ 
        root = null;
        size = 0; 

    }

    /**
     * this is a method used to return the size of a BST
     * @return returns an integer
     */
    public int size() { 
        return size; 
    }
    /**
     * this is a method used to see if a BST is empty
     * @return returns a boolean
     */
    public boolean isEmpty() { 
        return (size == 0); 
    }

    /**
     * this is a method used to clear a BST
     */
    public void clear() { 
        root = null; 
        size = 0;
    }
    // Search Method
    //time complexity: O(n) when sorted, and O(log(n)) unsorted
    /**
     * this is a method used to see if a certain element in contained in the BST
     * @param value this is the value that is searched for in the element
     * @return returns true if found and false if not
     */
    public boolean contains(E value){
        containsIterations = 0;
        if(root == null){
            return false;
        }
        TreeNode node = root;
        while(node != null){
            containsIterations++;
            if(value.compareTo(node.value) < 0)
                node = node.left;
            else if (value.compareTo(node.value)> 0)
                node = node.right;
            else
                return true;
        }
        return false;
    }
    // Insertion Method
    //time complexity: O(n) sorted, and O(log(n)) when unsorted
    /**
     * this is a method used to add an element to the BST
     * @param value this is the element that is added
     * @return returns true if added and false otherwise 
     */
    public boolean add(E value) {
        addIterations = 0;
        if (root == null)
            root = new TreeNode(value);
        else {
            TreeNode parent, node;
            parent = null; node = root;
            while (node != null) {
                addIterations++;
                parent = node;
                if(value.compareTo(node.value) < 0) {
                    node = node.left; 
                }
                else if (value.compareTo(node.value) > 0) {
                    node = node.right;
                }
                else
                    return false;
            }
            if (value.compareTo(parent.value)< 0)
                parent.left = new TreeNode(value);
            else
                parent.right = new TreeNode(value);
        }
        size++;
        return true; 

    }
    // Removal Method
    //time complexity: O(n), and O(log(n)) on average
    /**
     * this is a method used to remove a certain element from the BST
     * @param value this is the element that is removed from the BST if found
     * @return true if the element is found and removed and false otherwise
     */
    public boolean remove(E value) {
        removeIterations = 0;
        TreeNode parent, node;
        parent = null; node = root;
        // Find value first
        while (node != null) {
            removeIterations++;
            if (value.compareTo(node.value) < 0) {
                parent = node;
                node = node.left;
            }
            else if (value.compareTo(node.value) > 0) {
                parent = node;
                node = node.right;
            }
            else
                break; // value found
        }
        if (node == null) // value not in the tree
            return false;
        // Case 1: node has no children
        if(node.left == null && node.right == null){
            if(parent == null){ // delete root
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
            // go right on the left subtree
            while (rightMost.right != null) {
                removeIterations++;
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            // copy the value of rigthMost to node
            node.value = rightMost.value;
            //delete rigthMost
            if(rightMostParent.left == rightMost)
                rightMostParent.left = rightMost.left;
            else
                rightMostParent.right = rightMost.left;
        }
        size--;
        return true;
    }
    
    // Recursive Inorder Traversal Method
    /**
     * this is a method used to traverse the left subtree then the root and the right subtree and print out the values
     */
    public void inorder() {
        inorder(root);
    }
    /**
     * helper method for inorder
     * @param node this is the node the method is currently on 
     */
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    // Recursive Preorder Traversal Method
    /**
     * this is a method used to traverse through the root then left subtree and then the right subtree and print out the values accordingly
     */
    public void preorder() {
        preorder(root);
    }
    /**
     * this is a helper method for preoder
     * @param node this is the node the method is currently on 
     */
    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    // Recursive Postorder Traversal Method
    /**
     * this is a method used to traverse the left subtree, then the right subtree, then the root
     */
    public void postorder() {
        postorder(root);
    }
    /**
     * this is the helper method for postorder
     * @param node this is the node which the method is currently on
     */
    private void postorder(TreeNode node)  {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " "); 
        }
    }

    //time complexity O(n)
    /**
     * this is a method used to return the height of a BST
     * @return
     */
    public int height(){
        return height(root);
    }
    /**
     * this is a helper method for height used to count each level in the BST to find the height
     * @param node this is the node the method is currently on
     * @return this returns an integer for each height of the BST
     */
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right==null){ //this means leaf node
            return 1;
        }

        int heightL = height(node.left); //height of left subtree
        int heightR = height(node.right); //height of right subtree

        return Math.max(heightL, heightR) + 1;

    }

    //time complexity O(n^2)
    /**
     * this is a method used to check if a BST is balanced
     * @return returns true or false depending on if it is balanced
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    //time complexity O(n^2)
    /**
     * this is a helper method for isBalanced used to find the height of the left and right subtree and compare the heights
     * @param node
     * @return
     */
    private boolean isBalanced(TreeNode node){
        if(node == null){
            return true;
        }
        int heightL = height(node.left);
        int heightR = height(node.right);
        if(Math.abs(heightL - heightR) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }


    public boolean equals(Object o){
        if(o instanceof BST){
            BST<E> l = (BST<E>)o;
            if(l.size() != this.size()){
                return false;
            }else{
                ArrayList<E> temp = new ArrayList<>();
                ArrayList<E> temp2 = new ArrayList<>();
        
                inCheck(temp);
                inCheck(temp2);

                for(int i = 0; i < temp.size(); i++){
                    if(!temp.get(i).equals(temp2.get(i))){
                        return false;
                    }
                }

                return true;
            }
        }
        return false;
    }
    public void inCheck(ArrayList<E> list) {
        inCheck(root, list);
    }
    /**
     * helper method for inorder
     * @param node this is the node the method is currently on 
     */
    private void inCheck(TreeNode node, ArrayList<E> list) {
        if (node != null) {
            inorder(node.left);
            list.add(node.value);
            inorder(node.right);
        }
    }
}    