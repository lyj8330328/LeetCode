/**
 * @Author: 98050
 * @Time: 2018-11-23 22:53
 * @Feature:
 */



import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Test extends JFrame {
    MyPanel mp = null;

    public Test() {
        mp = new MyPanel();
        Thread tMyPanel = new Thread(mp);
        tMyPanel.start();

        this.setTitle("电子相册");
        this.setSize(1600, 1200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(mp);
    }

    public static void main(String[] args) {
        Test test = new Test();

    }

}
//我的画板类
class MyPanel extends JPanel implements Runnable{
    private LeftUp lu = null;
    private LeftDown ld = null;
    private RightUp ru = null;
    private RightDown rd = null;
    public MyPanel() {
        lu = new LeftUp();
        Thread tLeftUp = new Thread(lu);
        tLeftUp.start();

        ld = new LeftDown();
        Thread tLeftDown = new Thread(ld);
        tLeftDown.start();

        ru = new RightUp();
        Thread tRightUp = new Thread(ru);
        tRightUp.start();

        rd = new RightDown();
        Thread tRightDown = new Thread(rd);
        tRightDown.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(lu.getP1().getBi1(), 0, 0, 480, 300, this);
        g.drawImage(ld.getP1().getBi1(), 0, 300, 480, 300, this);
        g.drawImage(ru.getP1().getBi1(), 480, 0, 480, 300, this);
        g.drawImage(rd.getP1().getBi1(), 480, 300, 480, 300, this);

    }
    @Override
    public void run() {
        while(true) {
            this.repaint();//重新执行paint方法
            if(lu.isFlag()& ld.isFlag()& ru.isFlag()&rd.isFlag()) {//其他处理图片的线程结束，该线程结束
                break;
            }
        }
    }
}

//照片类
class Photo{
    private BufferedImage bi1 = new BufferedImage(960, 600, BufferedImage.TYPE_INT_RGB);

    private double[][] alpha = new double[600][960];
    private double[][] red = new double[600][960];
    private double[][] green = new double[600][960];
    private double[][] blue = new double[600][960];


    public BufferedImage getBi1() {
        return bi1;
    }
    public void setBi1(BufferedImage bi1) {
        this.bi1 = bi1;
    }
    public double[][] getAlpha() {
        return alpha;
    }
    public void setAlpha(double[][] alpha) {
        this.alpha = alpha;
    }
    public double[][] getRed() {
        return red;
    }
    public void setRed(double[][] red) {
        this.red = red;
    }
    public double[][] getGreen() {
        return green;
    }
    public void setGreen(double[][] green) {
        this.green = green;
    }
    public double[][] getBlue() {
        return blue;
    }
    public void setBlue(double[][] blue) {
        this.blue = blue;
    }


    /*
     * 提取像素
     * filePath--文件的路径
     * initialI,endI--图片高度的起始值，结束值
     * initialJ,endJ--图片宽度的起始值，结束值
     */
    public void readFile(String filePath, int initialI, int endI, int initialJ, int endJ) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File(filePath));//读取图片
        }catch(Exception e) {
            e.printStackTrace();
        }
        //提取像素分量
        for(int i = initialI; i<endI; i++) {
            int iI = i-initialI;
            for(int j = initialJ; j<endJ; j++) {
                int jJ = j-initialJ;
                red[iI][jJ] = (bi.getRGB(j, i) & 0xff0000)>>16;
                green[iI][jJ] = (bi.getRGB(j, i) & 0xff00)>>8;
                blue[iI][jJ] = (bi.getRGB(j, i) & 0xff);
            }
        }
    }
    public void pixelMerge(Photo p1, Photo p2, int initialI, int endI, int initialJ, int endJ, double factor) {
        for(int i = initialI; i<endI; i++) {
            int iI = i-initialI;
            for(int j = initialJ; j<endJ; j++) {
                int jJ = j-initialJ;
                red[iI][jJ] = (p1.getRed()[iI][jJ] - p2.getRed()[iI][jJ])*factor+p2.getRed()[iI][jJ];
                green[iI][jJ] = (p1.getGreen()[iI][jJ] - p2.getGreen()[iI][jJ])*factor+p2.getGreen()[iI][jJ];
                blue[iI][jJ] = (p1.getBlue()[iI][jJ] - p2.getBlue()[iI][jJ])*factor+p2.getBlue()[iI][jJ];
                bi1.setRGB(jJ, iI,(((int)(red[iI][jJ]) & 0xff)<<16)|(((int)(green[iI][jJ]) &0xff)<<8)|(int)(blue[iI][jJ]) & 0xff);
            }
        }
    }
}

/*将图片分成4部分
 * 左上角的图片
 */
class LeftUp implements Runnable {
    private boolean flag = false;//线程是否结束的标志

    private Photo p1 = null;
    private Photo p2 = null;

    public Photo getP1() {
        return p1;
    }
    public void setP1(Photo p1) {
        this.p1 = p1;
    }
    public Photo getP2() {
        return p2;
    }
    public void setP2(Photo p2) {
        this.p2 = p2;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public LeftUp() {
        p1 = new Photo();
        p2 = new Photo();
    }

    public void run() {
        int i = 1;
        p1.readFile("/Users/sun_/DeskTop/rgb1.jpg", 0, 600, 0, 960);
        p2.readFile("/Users/sun_/DeskTop/rgb2.jpg", 0, 600, 0, 960);
        while(i>=0) {
            double factor = 1.0;
            while(factor>0.0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p1.pixelMerge(p1, p2, 0, 600, 0, 960, factor);
                factor-=0.05;
            }

            p1.readFile("/Users/sun_/DeskTop/rgb2.jpg", 0, 600, 0, 960);
            p2.readFile("/Users/sun_/DeskTop/rgb3.jpg", 0, 600, 0, 960);
            i--;
        }
        flag = true;
    }
}
/*
 * 左下角的图片
 */
class LeftDown implements Runnable{
    private boolean flag = false;
    private Photo p1 = null;
    private Photo p2 = null;

    public LeftDown() {
        p1 = new Photo();
        p2 = new Photo();
    }

    public Photo getP1() {
        return p1;
    }

    public void setP1(Photo p1) {
        this.p1 = p1;
    }

    public Photo getP2() {
        return p2;
    }

    public void setP2(Photo p2) {
        this.p2 = p2;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        int i = 1;
        p1.readFile("/Users/sun_/DeskTop/rgb1.jpg", 600, 1200, 0, 960);
        p2.readFile("/Users/sun_/DeskTop/rgb2.jpg", 600, 1200, 0, 960);
        while(i>=0) {
            double factor = 1.0;
            while(factor>0.0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p1.pixelMerge(p1, p2, 600, 1200, 0, 960, factor);
                factor-=0.05;
            }

            p1.readFile("/Users/sun_/DeskTop/rgb2.jpg", 600, 1200, 0, 960);
            p2.readFile("/Users/sun_/DeskTop/rgb3.jpg", 600, 1200, 0, 960);
            i--;
        }
        flag = true;
    }

}
/*
 * 右上角的图片
 */
class RightUp implements Runnable{
    private boolean flag = false;
    private Photo p1 = null;
    private Photo p2 = null;

    public RightUp() {
        p1 = new Photo();
        p2 = new Photo();
    }

    public Photo getP1() {
        return p1;
    }

    public void setP1(Photo p1) {
        this.p1 = p1;
    }

    public Photo getP2() {
        return p2;
    }

    public void setP2(Photo p2) {
        this.p2 = p2;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        int i = 1;
        p1.readFile("/Users/sun_/DeskTop/rgb1.jpg", 0, 600, 960, 1920);
        p2.readFile("/Users/sun_/DeskTop/rgb2.jpg", 0, 600, 960, 1920);
        while(i>=0) {
            double factor = 1.0;
            while(factor>0.0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p1.pixelMerge(p1, p2, 0, 600, 960, 1920, factor);
                factor-=0.05;
            }

            p1.readFile("/Users/sun_/DeskTop/rgb2.jpg", 0, 600, 960, 1920);
            p2.readFile("/Users/sun_/DeskTop/rgb3.jpg", 0, 600, 960, 1920);

            i--;
        }
        flag = true;
    }

}

class RightDown implements Runnable{
    private boolean flag = false;
    private Photo p1 = null;
    private Photo p2 = null;

    public RightDown() {
        p1 = new Photo();
        p2 = new Photo();
    }

    public Photo getP1() {
        return p1;
    }

    public void setP1(Photo p1) {
        this.p1 = p1;
    }

    public Photo getP2() {
        return p2;
    }

    public void setP2(Photo p2) {
        this.p2 = p2;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        int i = 1;
        p1.readFile("/Users/sun_/DeskTop/rgb1.jpg", 600, 1200, 960, 1920);
        p2.readFile("/Users/sun_/DeskTop/rgb2.jpg", 600, 1200, 960, 1920);
        while(i>=0) {
            double factor = 1.0;
            while(factor>0.0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p1.pixelMerge(p1, p2, 600, 1200, 960, 1920, factor);
                factor-=0.05;
            }

            p1.readFile("/Users/sun_/DeskTop/rgb2.jpg", 600, 1200, 960, 1920);
            p2.readFile("/Users/sun_/DeskTop/rgb3.jpg", 600, 1200, 960, 1920);

            i--;
        }
        flag = true;
    }

}
