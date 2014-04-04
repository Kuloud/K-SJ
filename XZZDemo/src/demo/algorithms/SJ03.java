/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.algorithms;

/**
 *  带记录表动态规划求集合划分
 * @author Kuloud
 */
public class SJ03 {

    public static int[][] nDivM(int n) {
        int[][] intM = new int[n + 1][n + 1];
        intM[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            intM[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            intM[i][i + 1] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                intM[i][j] = (j * intM[i - 1][j] + intM[i - 1][j - 1]);
            }
        }
        return intM;
    }

    public static int[] compute(int n) {
        int[][] intM = nDivM(n);
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count[i] += intM[i][j];
            }
        }
        return count;
    }
}
