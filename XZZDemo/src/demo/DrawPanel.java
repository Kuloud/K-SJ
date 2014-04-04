/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *  欢迎界面，显示动画，是用的别人的代码，稍微改了下
 * @author Kuloud
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawPanel extends JPanel implements ActionListener {

    int recY = 80;
    int x1 = 0;
    int y1 = 0;
    int length = 50;
    int rColor = 0;
    int gColor = 0;
    int bColor = 0;
    int xReverseFlag = 0;
    int yReverseFlag = 0;
    int width = 640;
    int heigth = 30;
    Timer t = new Timer(5, this);

    public DrawPanel() {
        setPreferredSize(new Dimension(640, 429));
        setToolTipText("欢迎您的使用！");

        rColor = (int) (Math.random() * 256);
        gColor = (int) (Math.random() * 256);
        bColor = (int) (Math.random() * 256);

        xReverseFlag = 2;
        yReverseFlag = 2;

        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        Rectangle2D rec = new Rectangle2D.Double(0.0, 0.0, (double) this.getWidth(), (double) this.getHeight());
        g2.fill(rec);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(recY, recY, Color.WHITE,
                recY + 80, recY + 80, Color.DARK_GRAY, true);
        g2.setPaint(gp);

        Rectangle2D rrec = new Rectangle2D.Double(0, 0,
                this.getWidth(), this.getHeight());
        g2.fill(rrec);
        g2.setColor(getColor());

        Ellipse2D ellipse2D = getEllipse();
        g2.fill(ellipse2D);

        Graphics gt = g;
        gt.setFont(new Font("楷体", Font.ITALIC, 28));
        String strText = "最终的幻想，最终的自我！";
        int sWidth = this.getWidth();
        int sHeigth = this.getHeight();

        FontMetrics metrics = g.getFontMetrics();
        int strWidth = metrics.stringWidth(strText);
        if (width < -strWidth) {
            width = sWidth;
            heigth = (int) (Math.random() * (sHeigth - 50)) + 30;
        }
        gt.drawString(strText, width--, heigth);
        
        // 设置字体
        g.setFont(new Font("微软雅黑", Font.ITALIC, 24));
        g.setColor(Color.darkGray);
        // 设置时钟数字的格式，两位数字，自动补零
        java.text.DecimalFormat df = new java.text.DecimalFormat("00");
        // 获取当前时间
        Calendar rightNow = Calendar.getInstance();
        String timeStr = df.format(rightNow.get(Calendar.YEAR)) + "/" 
                + df.format(rightNow.get(Calendar.MONTH)+1) + "/" 
                + df.format(rightNow.get(Calendar.DATE)) + " " 
                + df.format(rightNow.get(Calendar.HOUR_OF_DAY)) + ":"
                + df.format(rightNow.get(Calendar.MINUTE)) + ":"
                + df.format(rightNow.get(Calendar.SECOND));
        // 右下角绘制数字时钟
        g.drawString(timeStr, this.getWidth() - 240, this.getHeight() - 10);
    }

    Color getColor() {
        Color color = null;

        try {
            int rFlag = (int) (Math.random() * 2);
            if (rFlag == 0) {
                rColor -= 5;
                rColor = (rColor < 0) ? (rColor + 10) : rColor;
            } else {
                rColor += 5;
                rColor = (rColor > 255) ? (rColor - 10) : rColor;
            }
            int gFlag = (int) (Math.random() * 2);
            if (gFlag == 0) {
                gColor -= 5;
                gColor = (gColor < 0) ? (gColor + 10) : gColor;
            } else {
                gColor += 5;
                gColor = (gColor > 255) ? (gColor - 10) : gColor;
            }
            int bFlag = (int) (Math.random() * 2);
            if (bFlag == 0) {
                bColor -= 5;
                bColor = (bColor < 0) ? (bColor + 10) : bColor;
            } else {
                bColor += 5;
                bColor = (bColor > 255) ? (bColor - 10) : bColor;
            }

            color = new Color(rColor, gColor, bColor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return color;
    }

    public Ellipse2D getEllipse() {
        if (x1 > this.getWidth() - length) {
            xReverseFlag = -(int) (Math.random() * 5) - 1;
        }
        if (y1 > this.getHeight() - length) {
            yReverseFlag = -(int) (Math.random() * 5) - 1;
        }
        if (x1 < 0) {
            xReverseFlag = (int) (Math.random() * 5) + 1;
        }
        if (y1 < 0) {
            yReverseFlag = (int) (Math.random() * 5) + 1;
        }

        x1 += xReverseFlag;
        y1 += yReverseFlag;

        return new Ellipse2D.Double(x1, y1, length, length);
    }

    public void actionPerformed(ActionEvent e) {
        recY += 2;
        this.repaint();
    }
}
