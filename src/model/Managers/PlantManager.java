/* Team Name: Chicken Team.
Group Number: G01 - L02.
Members:
    Võ Minh Khang - ITCSIU21136
    Nguyễn Hoàng Gia Ân - ITCSIU21161
    Nguyễn Trọng Nguyên - ITITIU21263
Choice of game: Plants and Zombies.
 Purpose: "Plants vs. Zombies" is a popular tower defense game 
where players use plants to defend their home from zombies. 
*/

package model.Managers;

import static model.Helper.Constant.Plants.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.Plant.SunFlower;
import view.Game.GamePanel;
import model.Plant.PeaShooter;
import model.Object.Plant;
import model.Object.Zombie;
import model.Plant.FreezePea;

public class PlantManager {
    private GamePanel gamePanel;
    private Image[] plantImg;
    private ArrayList<Plant> plants = new ArrayList<>();
    private Image[] plantCardImg;
    private int plantAmount = 0;

    public PlantManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.initPlant();
        this.loadImg();
    }

    private void initPlant() {
        plantImg = new Image[3];
        plantCardImg = new Image[3];
    }

    private void loadImg() {
        this.loadPlantImg();
        this.loadPlantCardImg();
    }

    private void loadPlantImg() {
        plantImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\sunFlower.gif");
        plantImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\peaShooter.gif");
        plantImg[2] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\freezePeaShooter.gif");
    }

    private void loadPlantCardImg() {
        plantCardImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\cardSunFlower.png");
        plantCardImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\cardPeaShooter.png");
        plantCardImg[2] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\cardFreezePea.png");
    }

    public void draw(Graphics g) {
        for (Plant plant : plants) {
            this.drawPlant(plant, g);
        }
    }

    private void drawPlant(Plant plant, Graphics g) {
        for (Plant p : plants) {
            g.drawImage(plantImg[p.getPlantType()], p.getX(), p.getY(), null);
        }
    }

    private void addPlant(int x, int y, int plantType) {
        switch (plantType) {
            case sunFlower:
                plants.add(new SunFlower(x, y, 0));
                break;
            case peaShooter:
                plants.add(new PeaShooter(x, y, 0));
                break;
            case freezePea:
                plants.add(new FreezePea(x, y, 0));
                break;
        }
    }

    public void addPlant(Plant selectedPlant, int x, int y) {
        plants.add(new Plant(x, y, plantAmount++, selectedPlant.getPlantType()));
    }

    public void update() {
        for (Plant plant : plants) {
            this.attackByPlant(plant);
            plant.updateCoolDown();
        }
    }

    public Image[] getPlantCardImg() {
        return plantCardImg;
    }

    public Image[] getPlantImg() {
        return plantImg;
    }

    public Plant checkPlantAt(int x, int y) {
        for (Plant p : plants) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    public void attackByPlant(Plant plant) {
        for (Zombie zombie : gamePanel.getZombieManager().getZombies()) {
            if (plant.getPlantType() != 0) {
                this.attack(plant, zombie);
            }
        }
    }

    public void attack(Plant plant, Zombie zombie) {
        if (zombie.getAlive()) {
            if (plant.isCoolDownOver()) {
                if (checkX(plant, zombie) && checkY(plant, zombie)) {
                    gamePanel.shootZombie(plant, zombie);
                    zombie.setHealth((int) (zombie.getHealth() - plant.getDmg()));
                    int affectZombieSpeed = (int) model.Helper.Constant.Plants.getAffectOnZombie(plant.getPlantType());
                    zombie.setSpeed(zombie.getSpeed() - affectZombieSpeed);
                    System.out.println(zombie.getHealth());
                    zombie.checkAlive();
                    plant.resetCoolDown();
                }
            }
        }
    }

    public boolean checkX(Plant plant, Zombie zombie) {
        int range = 800;
        return plant.getX() + range >= zombie.getX();
    }

    public boolean checkY(Plant plant, Zombie zombie) {
        int limit = 50;
        return (plant.getY() - limit <= zombie.getY())
                && (zombie.getY() <= (plant.getY() + limit));
    }

}
