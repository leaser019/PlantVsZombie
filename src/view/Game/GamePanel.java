package view.Game;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GamePanel extends JPanel {
    private Random random;
    public GamePanel (){
        random = new Random();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int x=0;x<20;x++){
            for(int y=0;y<20;y++){
            g.setColor(getRanColor());
            g.fillRect(x*40, y*30, 40, 30);
            }
        }
    }
    public Color getRanColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }
}
