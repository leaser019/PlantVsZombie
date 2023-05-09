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
        this.attack();
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

    public void attack() {
        for (Plant plant : plants) {
            for (Zombie zombie : gamePanel.getZombieManager().getZombies()) {
                if (zombie.getAlive()) {
                    gamePanel.shootZombie(plant,zombie);
                    if (plant.getPlantType() == peaShooter) {
                        if (plant.getX() + 300 >= zombie.getX() && (plant.getY() - 50 <= zombie.getY())
                                && (zombie.getY() <= (plant.getY() + 50))) {
                            zombie.setHealth((int) (zombie.getHealth() - plant.getDmg()));
                            System.out.println(zombie.getHealth());
                            zombie.checkAlive();
                        }
                    }
                    if (plant.getPlantType() == freezePea) {
                        if (plant.getX() + 300 >= zombie.getX() && (plant.getY() - 50 <= zombie.getY())
                                && (zombie.getY() <= (plant.getY() + 50))) {
                            zombie.setHealth((int) (zombie.getHealth() - plant.getDmg()));
                            zombie.setSpeed(zombie.getSpeed() - 0.002f);
                            System.out.println(zombie.getHealth());
                            zombie.checkAlive();
                        }
                    }
                }
            }
        }
    }

}
