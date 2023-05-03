package view.Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Input.MyKeyBoardListener;
import controller.Input.MyMouseListener;
import model.Managers.PlantManager;
import model.Managers.ZombieManager;
import java.awt.Graphics;
import java.awt.Image;

public class GamePanel extends JPanel {
    private Game game;
    private ZombieManager zombieManager;
    private PlantManager plantManager;
    private Image backGround;
    private MyKeyBoardListener keyBoardListener;
    private MyMouseListener mouseListener;

    public GamePanel() {
        this.init();
        // this.initInput();
    }

    public void init() {
        zombieManager = new ZombieManager(this);
        plantManager = new PlantManager(this);

    }

    public void setBackGround(Graphics g) {
        backGround = new ImageIcon("lib\\image\\GameBackground.png").getImage();
        g.drawImage(backGround, 0, 0, null);
    }

    public void render(Graphics g) {
        this.setBackGround(g);
        zombieManager.draw(g);
        plantManager.draw(g);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.render(g);

    }

    public void updateGame() {
        zombieManager.update();
        plantManager.update();
    }

    public void initInput() {
        keyBoardListener = new MyKeyBoardListener();
        mouseListener = new MyMouseListener();
        this.addKeyListener(keyBoardListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
    }
}
