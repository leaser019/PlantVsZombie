/* Team Name: Chicken Team.
Group Number: G01 - L02.
Members:
    Võ Minh Khang - ITCSIU21136
    Nguyễn Hoàng Gia Ân - ITCSIU21161
    Nguyễn Trọng Nguyên - ITITIU21263
Choice of game: Plants and Zombies.
 Purpose: "Plants vs. Zombies" is a popular tower defense game 
where players use plants to defend their home from zombies. 
*/

package view.Game;

import static model.Helper.Constant.GameWindow.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.InputForGame.MyKeyBoardListener;
import controller.InputForGame.MyMouseListener;
import view.GUI.GameWin;

import java.awt.Toolkit;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Font;

public class Game extends JFrame implements Runnable {
    private double setFPS = fps;
    private double setUPS = ups;
    private int widthSize = widthGameWindow;
    private int heightSize = heightGameWindow;
    private Thread gameTheard;

    public static void main(String[] args) {
        Game window = new Game(new GamePanel());
    }

    private GamePanel gamePanel;
    private GameWin gameWin;
    private JLabel jLabel;
    private MyMouseListener myMouseListener;
    private MyKeyBoardListener myKeyBoardListener;

    public Game(GamePanel gamePanel) {
        this.init();
        this.start();
        this.initInput();
        this.musicBackground();
    }

    public void init() {
        gamePanel = new GamePanel();
        this.setSize(widthSize, heightSize);// 995=111*9,750=150*5
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        jLabel = new JLabel("FPS = 0| UPS = 0| Time On Game = 0");
        this.add(jLabel, BorderLayout.NORTH);
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

    public void musicBackground(){
        String filePath="lib\\sound\\Grasswalk.wav";
        try {
            File file = new File(filePath);
            if(file.exists()){
                AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            }
        } catch (Exception e) {
        }

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
        double startTime = System.currentTimeMillis();
        double countTime = reset;
        int updateGame = reset;
        int frame = reset;
        double now;

        while (true) {

            now = System.nanoTime();
            countTime = System.currentTimeMillis();
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
                String rs = "FPS: " + frame + "| UPS: " + updateGame + "| Time On Game: "
                        + (int) (countTime - startTime) / 1000 + " s";
                jLabel.setText(rs);
                updateGame = reset;
                frame = reset;
                gamePanel.setCheckTime(1);
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

    public GamePanel getGamePanel() {
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

    public void winGame() {
        this.gameWin = new GameWin();
        gameWin.setVisible(true);
    }
}
