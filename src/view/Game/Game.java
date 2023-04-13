package view.Game;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.awt.BorderLayout;
import java.awt.Font;

public class Game extends JFrame implements Runnable {

    private Thread gameTheard;

    public static void main(String[] args) {
        Game window = new Game(new GamePanel());
    }

    private GamePanel gamePanel;
    private BufferedImage img;

    public Game(GamePanel gamePanel) {
        this.init();
        this.start();
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
        setTitle("Plants Vs Zombie Clone");
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
        double timePerFrame = Math.pow(10, 9) / 60;
        double timePerUpdate = Math.pow(10, 9) / 30;
        double lastTimeFPS = System.nanoTime();
        double lastTimeUPS = System.nanoTime();
        int updateGame = 1;
        int frame = 1;

        while (true) {
           
            // Render
            if (System.nanoTime() - lastTimeFPS >= timePerFrame) {
                frame++;
                lastTimeFPS = System.nanoTime();
                repaint();
            }
             // Update
             if (System.nanoTime() - lastTimeUPS >= timePerUpdate) {
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
}
