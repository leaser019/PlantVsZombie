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

public class Game extends JFrame {
    private long timePerFrame ;
    private long lastTime = System.nanoTime();
    
    public static void main(String[] args) {
        Game window = new Game(new GamePanel());
    }

   

    private GamePanel gamePanel;
    private BufferedImage img;
    
    public Game(GamePanel gamePanel){
        // this.importImg();
        this.init();

    }

    public void init(){
        gamePanel = new GamePanel();
        this.setSize(995, 750);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(gamePanel,BorderLayout.CENTER);
        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\icon.png"));
        setTitle("Plants Vs Zombie Clone");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void gameLoop(){

    }
}
