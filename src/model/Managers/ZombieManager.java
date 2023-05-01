package model.Managers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import model.Zombie.Zombie;
import view.Scenes.Game.GamePanel;

public class ZombieManager {
    private GamePanel gamePanel;
    private Image[] zombieImg;
    private Zombie testZombie;

    public ZombieManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        zombieImg = new Image[2];
        testZombie = new Zombie(200, 200, 0, 0);
        this.loadZombieImg();
    }

    public void loadZombieImg() {
        zombieImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie1.png");
        zombieImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie2.png");
    }

    public void draw(Graphics g) {
        this.drawZombie(testZombie, g);
    }

    private void drawZombie(Zombie zombie, Graphics g) {
        g.drawImage(zombieImg[0], (int) zombie.getX(), (int) zombie.getY(), null);
    }

    public void update() {
        testZombie.move(0.2f,0f);
        System.out.println("X = "+testZombie.getX());

    }
}
