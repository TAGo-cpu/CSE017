/**
 * Implementation of a binary search tree using linked nodes
*/
public class BST<E extends Comparable<E>> {
    // Data members
    private TreeNode root;
    private int size;
    // public static variables to hold the number of iterations of the methods contains, add, and remove
    public static int containsIterations, addIterations, removeIterations;
    /**
     * Inner class to represent one node of the tree
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
    /*
     * Default constructor
    */
    public BST(){
        root = null;
        size = 0;
    }
    /**
     * Method size
     * @return the number of nodes in the tree
     * Time complexity: O(1)
     */
    public int size() {
        return size;
    }
    /**
     * Method isEmpty
     * @return if the tree is empty
     * Time complexity: O(1)
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * Method clear
     * Time complexity: O(1)
     */
    public void clear() {
        root = null;
        size = 0;
    }
    /**
     * Search method
     * @param the value being searched
     * @return true is value was found in the tree, false otherwise
     * Time complexity: O(logn) on average, O(n) worst case
     */
    public boolean contains(E value){
        if(root == null){
            return false;
        }
        containsIterations = 0;
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
    /**
     * Method to add a new node to the tree
     * @param value of the new node
     * @return true if a node with value was added, false if there is already a node with value
     * Time complexity: O(logn) on average, O(n) worst case
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
    /**
     * Method to remove a node from the tree
     * @param value of the node to remove
     * @return true if a node with value is found and removed, false if value was not found
     * Time complexity: O(logn) on average, O(n) worst case
     */
    public boolean remove(E value) {
        TreeNode parent, node;
        parent = null; node = root;
        removeIterations = 0;
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

    /**
     * Method to print the values of the tree nodes using inorder traversal
     */
    public void inorder() {
        inorder(root);
    }
    /**
     * Recursive helper for the inorder traversal
     * @param node the current node to be visited
     */
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
    /**
     * Method to print the values of the tree nodes using preorder traversal
     */
    public void preorder() {
        preorder(root);
    }
    /**
     * Recursive helper for the preorder traversal
     * @param node the current node to be visited
     */
    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    /**
     * Method to print the values of the tree nodes using postorder traversal
     */
    public void postorder() {
        postorder(root);
    }
    /**
     * Recursive helper for the postorder traversal
     * @param node the current node to be visited
     */
    private void postorder(TreeNode node)  {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
}
