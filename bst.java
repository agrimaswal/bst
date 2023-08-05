class Solution {
//     class Node
// {
//     int data;
//     Node left, right;
//    Node(int item)
//    {
//         data = item;
//         left = right = null;
//     }
// }
    // Helper class to keep track of the previously visited node
    class PrevNode {
        int value;
        boolean initialized;
        
        public PrevNode() {
            initialized = false;
        }
    }
    
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        PrevNode prev = new PrevNode();
        return isBSTUtil(root, prev);
    }
    
    // Helper function to perform inorder traversal and check for BST property
    boolean isBSTUtil(Node node, PrevNode prev) {
        if (node == null) {
            return true;
        }
        
        // Check left subtree
        if (!isBSTUtil(node.left, prev)) {
            return false;
        }
        
        // Check current node
        if (prev.initialized && node.data <= prev.value) {
            return false;
        }
        prev.value = node.data;
        prev.initialized = true;
        
        // Check right subtree
        return isBSTUtil(node.right, prev);
    }
}
