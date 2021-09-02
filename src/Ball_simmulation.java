import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Ball_simmulation extends Canvas implements Runnable{

    private int fps = 60;
    private BufferStrategy bs;
    private Thread thread;

    private ArrayList<Ball> Balls = new ArrayList();

    public static void main(String[] args) {
        Ball_simmulation simmulation = new Ball_simmulation();
        simmulation.start();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
    }

    public Ball_simmulation() {
        Balls.add(new Ball(30, 30,0,1));
        JFrame frame = new JFrame("A simmulasiton of my balls bounsing");
        this.setSize(900,900);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void update(){

    }

    private void draw(){
        bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(new Color(76, 31, 8));

        g.fillOval( (int) (Math.round(Balls.get(1).X_local - 5)), (int) (Math.round(Balls.get(1).hight - 10)),10,10);

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        double deltaT = 1.0/fps;
        long lastTime = System.currentTimeMillis();

        long now = System.currentTimeMillis();
        if (now - lastTime >= deltaT) {
            update();
            draw();
        }
    }
}
