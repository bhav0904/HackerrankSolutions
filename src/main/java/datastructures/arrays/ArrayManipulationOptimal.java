package datastructures.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 * Generate a difference array, in which every element a[i] = k means that it is k greater than a[i-1]
 */
public class ArrayManipulationOptimal {

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

            array[a - 1] += k;

            if (b < n) {
                array[b] -= k;
            }
        }

        long temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp += array[i];

            if (temp > max) {
                max = temp;
            }

        }

        in.close();



        System.out.print(max);
    }
}
