package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 */
public class SwapNodes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfNodes = in.nextInt();

        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        //Create tree from input
        while (!queue.isEmpty()) {
            Node current = queue.remove();

            int nextLeft = in.nextInt();
            if (nextLeft != -1) {
                current.left = new Node(nextLeft);
                queue.add(current.left);
            }

            int nextRight = in.nextInt();
            if (nextRight != -1) {
                current.right = new Node(nextRight);
                queue.add(current.right);
            }
        }

        int numberOfSwaps = in.nextInt();
        for (int i = 0; i < numberOfSwaps; i++) {
            int k = in.nextInt();
            swap(root, k);
            inOrder(root);
            System.out.println();
        }
    }

    private static void swap(Node root, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            List<Node> currentList = new ArrayList<>();
            depth++;

            while(!queue.isEmpty()) {
                currentList.add(queue.remove());
            }

            if (depth % k == 0) {
                for (Node node : currentList) {
                    Node temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
            }

            for (Node node : currentList) {
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        System.out.print(root.data + " ");

        inOrder(root.right);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
