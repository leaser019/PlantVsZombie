package view.Game;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Font;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;
    public GameWindow(GamePanel gamePanel){
        this.init();
    }
    public void init(){
        gamePanel = new GamePanel();
        this.setSize(805, 605);
        this.setLocationRelativeTo(null);
        this.add(gamePanel);
        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\icon.png"));
        setTitle("Plants Vs Zombie Clone");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        GameWindow window = new GameWindow(new GamePanel());
    }
}
