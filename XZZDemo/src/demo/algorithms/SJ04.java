/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.algorithms;

/**
 *  带记录表动态规划求最长公共子串，并控制输出格式
 * @author Kuloud
 */
public class SJ04 {

    private static int[][] intC;
    private static int[][] intB;

    private static void maxComSubStrLen(int m, int n, String strA, String strB, int[][] intC, int[][] intB) {
        int i, j;
        for (i = 0; i <= m; i++) {
            intC[i][0] = 0;
        }
        for (i = 1; i <= n; i++) {
            intC[0][i] = 0;
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (strA.charAt(i-1) == strB.charAt(j-1)) {
                    intC[i][j] = intC[i - 1][j - 1] + 1;
                    intB[i][j] = 1;
                } else if (intC[i - 1][j] >= intC[i][j - 1]) {
                    intC[i][j] = intC[i - 1][j];
                    intB[i][j] = 2;
                } else {
                    intC[i][j] = intC[i][j - 1];
                    intB[i][j] = 3;
                }
            }
        }
    }

    private static String maxComSubStr(int i, int j, String strA, int[][] intA) {
        if (i == 0 || j == 0) {
            return "";
        }
        if (intA[i][j] == 1) {
            return maxComSubStr(i - 1, j - 1, strA, intA) + strA.charAt(i-1);
        } else if (intA[i][j] == 2) {
            return maxComSubStr(i - 1, j, strA, intA);
        } else {
            return maxComSubStr(i, j - 1, strA, intA);
        }
    }

    public static String LCS(String strA, String strB) {
        int intALen = strA.length();
        int intBLen = strB.length();
        intC = new int[intALen+1][intBLen+1];
        intB = new int[intALen+1][intBLen+1];
        maxComSubStrLen(intALen, intBLen, strA, strB, intC, intB);
        return maxComSubStr(intALen, intBLen, strA, intB);
    }
}
