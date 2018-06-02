package datastructure.easy;

public class BinarySearchTreeLowestCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node lca(Node root, int v1, int v2) {
        if (root.data <= v1 && root.data >= v2)
            return root;
        if (root.data >= v1 && root.data <= v2)
            return root;

        if (root.data < v1)
            return lca(root.right, v1, v2);
        else
            return lca(root.left, v1, v2);
    }
}
