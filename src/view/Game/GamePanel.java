package view.Game;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.Input.MyKeyBoardListener;
import controller.Input.MyMouseListener;
import model.Managers.PlantManager;
import model.Managers.ZombieManager;
import view.UI.CardBar;

import java.awt.Graphics;
import java.awt.Image;

public class GamePanel extends JPanel {
    private Game game;
    private ZombieManager zombieManager;
    private PlantManager plantManager;
    private Image backGround;
    private MyKeyBoardListener keyBoardListener;
    private MyMouseListener mouseListener;
    private CardBar cardBar;

    public GamePanel() {
        this.init();
    }

    public void init() {
        cardBar = new CardBar(116, 15, 450, 80,this);
        zombieManager = new ZombieManager(this);
        plantManager = new PlantManager(this);

    }

    public void setBackGround(Graphics g) {
        backGround = new ImageIcon("lib\\image\\GameBackground.png").getImage();
        g.drawImage(backGround, 0, 0, null);
    }

    public void render(Graphics g) {
        this.setBackGround(g);
        cardBar.draw(g);
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
        keyBoardListener = new MyKeyBoardListener(game);
        mouseListener = new MyMouseListener(game);
        this.addKeyListener(keyBoardListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
    }
    public PlantManager getPlantManager(){
        return this.plantManager;
    }
}
