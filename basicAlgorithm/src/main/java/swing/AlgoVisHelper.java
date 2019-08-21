package swing;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.EventListener;

public class AlgoVisHelper {
    private AlgoVisHelper(){}
    public static void setStrokeWidth(Graphics2D g2d,int w){
        g2d.setStroke(new BasicStroke(w,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
    }
    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle =new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }

    public static void fillCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle =new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.fill(circle);
    }
    public static void pause(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
