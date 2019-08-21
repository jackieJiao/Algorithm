package swing;

import java.awt.*;
import java.awt.event.*;

public class AlgoController {
    private Circle[] circles;
    private AlgoFrame fram;
    private boolean isAnimated=true;


    public AlgoController(int sceneWidth,int sceneHeight,int N){
        //data layer
        circles=new Circle[N];
        int R=50;
        for (int i = 0; i < N; i++) {
            int x= (int) (Math.random()*(sceneWidth-2*R)+R);
            int y= (int) (Math.random()*(sceneHeight-2*R)+R);
            int vx=(int) (Math.random()*11-5);

            int vy=(int) (Math.random()*11-5);
            circles[i]=new Circle(x,y,R,vx,vy);
        }

        //view layer
        EventQueue.invokeLater(()->{
            fram =new AlgoFrame("Welcome Jiao",sceneWidth,sceneHeight);
            fram.addKeyListener(new AlgoKeyListener());
            fram.addMouseListener(new AlgoMouseListener());

            new Thread(()->{
                run();
            }).start();

        });

    }

    private void run(){
        while (true){
            //绘制
            fram.render(circles);
            AlgoVisHelper.pause(10);
            //更新
            if (isAnimated==true) {
                for (Circle circle : circles)
                    circle.move(0,0,fram.getCanvasWidth(),fram.getHeight());
            }
        }
    }
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            System.out.println(event.getPoint());

            for (Circle circle : circles) {
                if(circle.contain(event.getPoint()))
                    circle.isfilled=!circle.isfilled;

            }
        }

    }

    private class AlgoKeyListener extends KeyAdapter {
         @Override
        public void keyReleased(KeyEvent event){
            if (event.getKeyChar()==' ')
                isAnimated=!isAnimated;
        }

    }

    public static void main(String[] args) {


    }
}
