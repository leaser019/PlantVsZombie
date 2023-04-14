package view.Game;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import controller.Input.MyMouseListener;
import controller.Input.MyKeyBoardListener;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.awt.BorderLayout;
import java.awt.Font;

public class Game extends JFrame implements Runnable {
    private double setFPS = 80;
    private double setUPS = 60;
    private Thread gameTheard;

    public static void main(String[] args) {
        Game window = new Game(new GamePanel());
    }

    private GamePanel gamePanel;
    private MyMouseListener myMouseListener;
    private MyKeyBoardListener myKeyBoardListener;
    private BufferedImage img;

    public Game(GamePanel gamePanel) {
        this.init();
        this.start();
        this.initInput();
    }

    public void init() {
        gamePanel = new GamePanel();
        this.setSize(995, 750);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(gamePanel, BorderLayout.CENTER);
        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\icon.png"));
        setTitle("Plants Vs Zombie");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        gameTheard = new Thread(this) {
        };
        gameTheard.start();
    }

    public void updateGame() {
    }

    @Override
    public void run() {
        double lastTimeCheck = System.currentTimeMillis();
        double timePerFrame = Math.pow(10, 9) / setFPS;
        double timePerUpdate = Math.pow(10, 9) / setUPS;
        double lastTimeFPS = System.nanoTime();
        double lastTimeUPS = System.nanoTime();
        int updateGame = 0;
        int frame = 0;
        double now;

        while (true) {

            now = System.nanoTime();

            // Render
            if (now - lastTimeFPS >= timePerFrame) {
                frame++;
                lastTimeFPS = System.nanoTime();
                repaint();
            }
            // Update
            if (now - lastTimeUPS >= timePerUpdate) {
                updateGame++;
                updateGame();
                lastTimeUPS = System.nanoTime();
            }
            // FPS Counter & UPS Counter
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frame + "| UPS: " + updateGame);
                updateGame = 0;
                frame = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }

    private void initInput() {
        myMouseListener = new MyMouseListener();
        myKeyBoardListener = new MyKeyBoardListener();
        this.addMouseListener(myMouseListener);
        this.addMouseMotionListener(myMouseListener);
        this.addKeyListener(myKeyBoardListener);

        requestFocus();
    }
}
