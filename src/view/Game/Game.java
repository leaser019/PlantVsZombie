package view.Game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Input.MyMouseListener;
import model.Managers.ZombieManager;
import controller.Input.MyKeyBoardListener;

import java.awt.Toolkit;
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
        gamePanel.updateGame();
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

    void initInput() {
        myMouseListener = new MyMouseListener(this);
        myKeyBoardListener = new MyKeyBoardListener(this);
        this.addMouseListener(myMouseListener);
        this.addMouseMotionListener(myMouseListener);
        this.addKeyListener(myKeyBoardListener);

        requestFocus();
    }
}
