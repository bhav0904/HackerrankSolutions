package datastructures.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 * Brute force solution.
 */
public class ArrayManipulationSubOptimal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] array = new long[n];
        long max = Integer.MIN_VALUE;
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            for(int i = a-1; i <= b-1; i++) {
                array[i] = array[i] + k;
                if (array[i] > max) {
                    max = array[i];
                }
            }
        }

        in.close();



        System.out.print(max);
    }
}
