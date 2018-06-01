package datastructure.easy;

import java.util.LinkedList;

public class TreeLeveTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void levelOrder(Node root) {
        final LinkedList<LinkedList<Node>> allList = new LinkedList<>();
        travelOrder(root, allList, 0);
        allList.forEach(list ->
                list.forEach(node -> {
                    System.out.print(node.data + " ");
                })
        );
    }

    void travelOrder(Node node, LinkedList<LinkedList<Node>> allList, int height) {
        if (node == null)
            return;

        if (allList.size() < height + 1)
            allList.add(new LinkedList<>());

        allList.get(height).add(node);
        travelOrder(node.left, allList, height + 1);
        travelOrder(node.right, allList, height + 1);
    }
}
