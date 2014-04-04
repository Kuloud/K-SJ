/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.algorithms;

import java.math.BigInteger;

/**
 *  分治法进行两大整数乘法，并控制输出格式
 * @author Kuloud
 */
public class SJ02 {

    public static StringBuffer strProcess = new StringBuffer();

    public static String BigIntMultDif(String a, String b, int intLevel) {
        int k1 = a.length();
        int k2 = b.length();
        StringBuffer strLevel = new StringBuffer("\n");
        for (int i = 0; i < intLevel; i++) {
            strLevel.append("  ");
        }
        if (k1 < 4 && k2 < 4) {
            int intA = Integer.parseInt(a);
            int intB = Integer.parseInt(b);
            int intR = intA * intB;
            strProcess.append(strLevel).append(a).append(" * ").append(b).append(" = ").append(intR);
            return String.valueOf(intR);
        }
        if (k1 > k2) {
            return BigIntMultDif(b, a, intLevel);
        } else if (k1 == k2) {
            return BigIntMultSame(a, b, intLevel);
        }
        BigInteger p = BigInteger.ZERO;
        BigInteger r = p;
        int i = 0;
        strProcess.append(strLevel).append(a).append(" * ").append(b).append(" = ");
        for (; i < k2 - k1; i += k1) {
            String bi = b.substring(i, i + k1);
            strProcess.append(a).append("*").append(bi).append("*10^").append(k2 - k1 - i).append("+");
        }
        String bi = b.substring(i);
        strProcess.append(a).append("*").append(bi);

        for (i=0; i < k2 - k1; i += k1) {
            String bt = b.substring(i, i + k1);
            r = p.add(new BigInteger(BigIntMultSame(a, bt, intLevel+1) + cover(k2 - k1 - i)));
            p = r;
        }
        
        r = p.add(new BigInteger(BigIntMultDif(a, bi, intLevel+1)));
        strProcess.append(strLevel).append("  =").append(r);

        return r.toString();
    }

    public static String BigIntMultSame(String a, String b, int intLevel) {
        StringBuffer strLevel = new StringBuffer("\n");
        for (int i = 0; i < intLevel; i++) {
            strLevel.append("  ");
        }
        int intSubLen = a.length() / 2;
        if (intSubLen < 2) {
            int intA = Integer.parseInt(a);
            int intB = Integer.parseInt(b);
            int intR = intA * intB;
            strProcess.append(strLevel).append(a).append(" * ").append(b).append(" = ").append(intR);
            return String.valueOf(intR);
        }

        int intL = a.length() - intSubLen;
        String t = cover(intL);
        String a1 = a.substring(0, intSubLen);
        String a2 = a.substring(intSubLen);
        String b1 = b.substring(0, intSubLen);
        String b2 = b.substring(intSubLen);

        strProcess.append(strLevel).append(a).append(" 分解为 ").append(a1).append(" 和 ").append(a2);
        strProcess.append(strLevel).append(b).append(" 分解为 ").append(b1).append(" 和 ").append(b2);
        strProcess.append(strLevel).append(a).append(" * ").append(b).append(" = ").append(a1).append(" * ").append(b1).append("*10^").append(intL + intL).append(" + (").append(a1).append(" * ").append(b2).append(" + ").append(a2).append(" * ").append(b1).append(" )*10^").append(intL).append(" + ").append(a2).append(" * ").append(b2);

        int intLevelNext = intLevel + 1;
        BigInteger p1 = new BigInteger(BigIntMultSame(a1, b1, intLevelNext) + t + t);
        BigInteger p2 = new BigInteger(BigIntMultDif(a1, b2, intLevelNext));
        BigInteger p3 = new BigInteger(BigIntMultDif(a2, b1, intLevelNext));
        BigInteger p4 = new BigInteger(BigIntMultSame(a2, b2, intLevelNext));
        BigInteger p5 = new BigInteger(p2.add(p3).toString() + t);
        BigInteger p = p1.add(p5).add(p4);
        strProcess.append(strLevel).append("  =").append(p);

        return p.toString();
    }

    public static String cover(int len) {
        String t = "";
        for (int i = 0; i < len; i++) {
            t += "0";
        }
        return t;
    }
}
