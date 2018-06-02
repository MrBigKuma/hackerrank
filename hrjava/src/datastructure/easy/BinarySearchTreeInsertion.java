package datastructure.easy;

public class BinarySearchTreeInsertion {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node Insert(Node root, int value) {
        if (root == null)
            return createNode(value);

        if (root.data >= value) {
            if (root.left == null)
                root.left = createNode(value);
            else
                Insert(root.left, value);
        } else {
            if (root.right == null)
                root.right = createNode(value);
            else
                Insert(root.right, value);
        }

        return root;
    }

    private static Node createNode(int value) {
        final Node newNode = new Node();
        newNode.data = value;
        return newNode;
    }
}
