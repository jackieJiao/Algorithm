package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasHeight=canvasHeight;
        this.canvasWidth=canvasWidth;
        AlgoCanvas canvas=new AlgoCanvas();
        //canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        setContentPane(canvas);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles=circles;
        this.repaint();
    }




    private class AlgoCanvas extends JPanel{
        public AlgoCanvas(){
            super(true);
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.blue);


            //抗锯齿
            RenderingHints hints=new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            AlgoVisHelper.setStrokeWidth(g2d,1);
            g2d.setColor(Color.RED);
            for (Circle circle : circles) {
                if (circle.isfilled){
                    AlgoVisHelper.fillCircle(g2d,circle.x,circle.y,circle.getR());
                }else
                AlgoVisHelper.strokeCircle(g2d,circle.x,circle.y,circle.getR());
            }
 }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
