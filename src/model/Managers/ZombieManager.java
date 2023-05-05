package model.Managers;

import static model.Helper.Constant.Zombies.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.Zombie.Zombie;
import model.Zombie.bossZombie;
import model.Zombie.coneZombie;
import model.Zombie.finalZombie;
import model.Zombie.normalZombie;
import view.Game.GamePanel;


public class ZombieManager {
    private GamePanel gamePanel;
    private Image[] zombieImg;
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public ZombieManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        zombieImg = new Image[4];
        // size 9*110,5*150
        this.addZombie(1000, 100, normalZombie);
        this.addZombie(1000, 2 * 100, coneZombie);
        this.addZombie(1000, 3 * 100, coneZombie);
        this.addZombie(1000, 4 * 100, bossZombie);
        this.addZombie(1000, 5 * 100, finalZombie);

        this.loadZombieImg();
    }

    public void loadZombieImg() {
        zombieImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie1.png");
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
            case bossZombie:
                zombies.add(new bossZombie(x, y, 0));
                break;
            case finalZombie:
                zombies.add(new finalZombie(x, y, 0));
                break;
        }
    }

    public void update() {
        for (Zombie zombie : zombies) {
            zombie.move(getSpeed(zombie.getZombieType()), 0f);
        }
    }
}
