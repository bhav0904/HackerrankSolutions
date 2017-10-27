package datastructures.trees.stacks;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 * Brute force. Runtime: O(n^2)
 */
public class LargestRectangle {

    private static long largestRectangle(int[] h) {
        long maxArea = 0;
        for (int i = 0; i < h.length; i ++) {
            int minHeight = h[i];
            for (int j=i; j < h.length; j++) {
                int k = j - i + 1;
                minHeight = findMin(h, j, minHeight);
                long area = k * minHeight;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private static int findMin(int[] h, int end, int previousMin) {
        if (h[end] < previousMin) {
            return h[end];
        }
        return previousMin;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int h_i = 0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        long result = largestRectangle(h);
        System.out.println(result);
        in.close();
    }
}
