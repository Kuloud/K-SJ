/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.algorithms;

/**
 *  非递归求两整数最大公因子，并控制输出格式
 * @author Kuloud
 */
public class SJ01 {

    public static StringBuffer strProcess;

    public static long getMaxDivisor(long a, long b) {
        strProcess = new StringBuffer();
        strProcess.append("计算过程为：");

        long c = Math.abs(a);
        long d = Math.abs(b);

        if (a < 0 || b < 0) {
            strProcess.append("(").append(a).append(", ").append(b).append(") = (").append(c).append(", ").append(d).append(")");
        }

        while (d != 0) {
            long r = c % d;
            strProcess.append("\n").append(c).append(" % ").append(d).append(" = ").append(r);
            c = d;
            d = r;
        }

        strProcess.append("\n运算完成。");
        return c;
    }
}
