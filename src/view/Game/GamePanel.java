package view.Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    private Game game;
    private ArrayList<BufferedImage> listImg = new ArrayList<>();
    private Random random;
    

    public GamePanel() {
        random = new Random();
        JLabel lblNewLabel = new JLabel("Graph");
        // lblNewLabel.setBounds(0, 0, 776, 531);
        lblNewLabel.setIcon(new ImageIcon("lib\\image\\GameBackground.png"));
        add(lblNewLabel);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
}
