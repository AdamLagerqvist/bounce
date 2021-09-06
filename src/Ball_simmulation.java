import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Ball_simmulation extends Canvas implements Runnable, KeyListener{

    private int fps = 60;
    private BufferStrategy bs;
    private Thread thread;
    public double deltaT = 1.0/fps;

    private ArrayList<Ball> Balls = new ArrayList();
    private ArrayList<Ball> Balls_to_remove = new ArrayList();

    public static void main(String[] args) {
        Ball_simmulation simmulation = new Ball_simmulation();
        simmulation.start();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
    }

    public Ball_simmulation() {
        Balls.add(new Ball(800, 30,0,20));
        JFrame frame = new JFrame("A simmulasiton of my balls bouncing");
        this.setSize(900,900);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void update() {
        Balls.stream().forEach(ball -> {
            ball.hight_calc(deltaT);
            ball.Y_Velocity_calc(deltaT);
            ball.X_Clac(deltaT);
            if (ball.Y_velocity < 0.1 && ball.Y_velocity > -0 && ball.hight < 1){
                Balls_to_remove.add(ball);
            }
        });
        Balls.removeAll(Balls_to_remove);
        if(Balls.size() < 50){
            Balls.add(new Ball((Math.random() * 850) + 20, (Math.random() * 850) + 20,(Math.random() * 40) - 30,(Math.random() * 40) + 10));
        }
    }

    private void draw(){
        bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.white);

        g.fillRect(0,0,900,900);

        g.setColor(new Color(76, 31, 8));
        Balls.stream().forEach(ball -> {
            g.fillOval( (int) (Math.round(ball.X_local - 5)), (int) (880-(Math.round(ball.hight - 10))),10,10);
        });

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while(true){
        long now = System.currentTimeMillis();
        if (now - lastTime >= deltaT) {
            update();
            draw();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if(keyEvent.getKeyChar() == ' '){

        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
