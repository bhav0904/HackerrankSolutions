package datastructures.trees.stacks;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 * Brute force. Runtime: O(n^3)
 */
public class LargestRectangle {

    private static long largestRectangle(int[] h) {
        long maxArea = 0;
        for (int i = 0; i < h.length; i ++) {
            for (int j=i; j < h.length; j++) {
                int k = j - i + 1;
                int minHeight = findMin(h, i, j);
                long area = k * minHeight;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private static int findMin(int[] h, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <=end; i++) {
            if (h[i] < min) {
                min = h[i];
            }
        }
        return min;
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
