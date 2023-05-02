package model.Managers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.Zombie.Zombie;
import model.Zombie.coneZombie;
import model.Zombie.normalZombie;
import view.Scenes.Game.GamePanel;

import static model.HelperMethod.Constant.Zombies.*;

public class ZombieManager {
    private GamePanel gamePanel;
    private Image[] zombieImg;
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public ZombieManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        zombieImg = new Image[4];
        this.addZombie(1000, 200, 0);
        this.addZombie(1100, 400, 1);
        this.loadZombieImg();
    }

    public void loadZombieImg() {
        zombieImg[0] = Toolkit.getDefaultToolkit().getImage("lib\\image\\zombie1.png");
        zombieImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie2.png");
        zombieImg[2] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\finalZombie.png");
        zombieImg[3] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\bossZombie.png");
    }

    public void draw(Graphics g) {
        for (Zombie zombie : zombies) {
            this.drawZombie(zombie, g);
        }
    }

    private void drawZombie(Zombie zombie, Graphics g) {

        g.drawImage(zombieImg[zombie.getZombieType()], (int) zombie.getX(), (int) zombie.getY(), null);

    }

    public void addZombie(int x, int y, int zombieType) {
        switch (zombieType) {
            case normalZombie:
                zombies.add(new normalZombie(x, y, 0));
                break;
            case coneZombie:
                zombies.add(new coneZombie(x, y, 0));
                break;
        }
    }

    public void update() {
        for (Zombie zombie : zombies) {
            zombie.move(-0.2f, 0f);
        }
    }
}
