package view.Game;

import javax.swing.JFrame;

import controller.InputForGame.MyKeyBoardListener;
import controller.InputForGame.MyMouseListener;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Font;

public class Game extends JFrame implements Runnable {
    private double setFPS = 80;
    private double setUPS = 60;
    private int widthSize = 999;
    private int heightSize = 750;
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
        this.setSize(widthSize, heightSize);//995=111*9,750=150*5
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

    public GamePanel getGamePanel(){
        return gamePanel;
    }

    public double getSetFPS() {
        return setFPS;
    }

    public void setSetFPS(double setFPS) {
        this.setFPS = setFPS;
    }

    public double getSetUPS() {
        return setUPS;
    }

    public void setSetUPS(double setUPS) {
        this.setUPS = setUPS;
    }

    public int getWidthSize() {
        return widthSize;
    }

    public void setWidthSize(int widthSize) {
        this.widthSize = widthSize;
    }

    public int getHeightSize() {
        return heightSize;
    }

    public void setHeightSize(int heightSize) {
        this.heightSize = heightSize;
    }

    public Thread getGameTheard() {
        return gameTheard;
    }

    public void setGameTheard(Thread gameTheard) {
        this.gameTheard = gameTheard;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public MyMouseListener getMyMouseListener() {
        return myMouseListener;
    }

    public void setMyMouseListener(MyMouseListener myMouseListener) {
        this.myMouseListener = myMouseListener;
    }

    public MyKeyBoardListener getMyKeyBoardListener() {
        return myKeyBoardListener;
    }

    public void setMyKeyBoardListener(MyKeyBoardListener myKeyBoardListener) {
        this.myKeyBoardListener = myKeyBoardListener;
    }
    
}
