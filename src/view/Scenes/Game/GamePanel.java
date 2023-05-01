package view.Scenes.Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Managers.ZombieManager;
import java.awt.Graphics;
import java.awt.Image;

public class GamePanel extends JPanel {
    private Game game;
    private ZombieManager zombieManager;  
    private Image backGround;  

    public GamePanel() {
        
        zombieManager = new ZombieManager(this); 

    }

    public void setBackGround(Graphics g){
        backGround = new ImageIcon("lib\\image\\GameBackground.png").getImage();
        g.drawImage(backGround, 0, 0, null);
    }

    public void render(Graphics g){
        this.setBackGround(g);
        zombieManager.draw(g);

    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.render(g);
    }
    

}
