package algorithms.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class EvenTree {

    private static final Scanner scanner = new Scanner(System.in);

    static int maxRemovableEdgeCount(int[] treeFrom, int[] treeTo) {
        final HashMap<Integer, Node> nodes = new HashMap<>();
        Node rootNode = null;
        for (int i = 0; i < treeFrom.length; i++) {
            final int child = treeFrom[i];
            final int parent = treeTo[i];

            final Node childNode = new Node(child);
            nodes.putIfAbsent(child, childNode);
            nodes.putIfAbsent(parent, new Node(parent));
            nodes.get(parent).children.add(childNode);

            if (parent == 1)
                rootNode = nodes.get(parent);
        }

        countTree(rootNode);

        return (int) nodes.values().stream()
                .filter(n -> n.subNodeCount % 2 == 0)
                .count() - 1; // exclude root
    }

    static int countTree(Node root) {
        if (root.children.size() == 0) {
            root.subNodeCount = 1;
            return 1;
        }

        root.subNodeCount = 1 + root.children.stream().mapToInt(EvenTree::countTree).sum();
        return root.subNodeCount;
    }

    static class Node {
        Integer value;
        Integer subNodeCount = 0;
        LinkedList<Node> children = new LinkedList<>();

        Node(Integer value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        String[] treeNodesEdges = scanner.nextLine().split(" ");
        int treeNodes = Integer.parseInt(treeNodesEdges[0].trim());
        int treeEdges = Integer.parseInt(treeNodesEdges[1].trim());

        int[] treeFrom = new int[treeEdges];
        int[] treeTo = new int[treeEdges];

        for (int i = 0; i < treeEdges; i++) {
            String[] treeFromTo = scanner.nextLine().split(" ");
            treeFrom[i] = Integer.parseInt(treeFromTo[0].trim());
            treeTo[i] = Integer.parseInt(treeFromTo[1].trim());
        }

        System.out.print(maxRemovableEdgeCount(treeFrom, treeTo));

        scanner.close();
    }

}

