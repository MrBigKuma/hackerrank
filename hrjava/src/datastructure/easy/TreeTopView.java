package datastructure.easy;

public class TreeTopView {
    class Node {
        int data;
        Node left;
        Node right;
    }

    void topView(Node root) {
        printLeft(root.left);
        System.out.print(root.data + " ");
        printRight(root.right);
    }

    void printLeft(Node node) {
        if (node == null)
            return;

        printLeft(node.left);
        System.out.print(node.data + " ");
    }

    void printRight(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printRight(node.right);
    }
}
