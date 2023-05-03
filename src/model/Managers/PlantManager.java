package model.Managers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.HelperMethod.Constant.Plants;
import model.Plant.Plant;
import model.Plant.SunFlower;
import model.Plant.PeaShooter;
import model.Plant.FreezePea;
import view.Scenes.Game.GamePanel;
import static model.HelperMethod.Constant.Plants.*;

public class PlantManager {
    private GamePanel gamePanel;
    private Image[] plantImg;
    private ArrayList<Plant> plants = new ArrayList<>();

    public PlantManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        plantImg = new Image[3];
        this.addPlant(1100,200, freezePea);

        this.loadPlantImg();
    }

    private void loadPlantImg() {
        plantImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\sunFlower.gif");
        plantImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\peaShooter.gif");
        plantImg[2] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\freezePeaShooter.gif");
    }

    public void draw(Graphics g) {
        for (Plant plant : plants) {
            this.drawPlant(plant, g);
        }
    }

    private void drawPlant(Plant plant, Graphics g) {
        g.drawImage(plantImg[plant.getPlantType()], (int) plant.getX(), (int) plant.getY(), null);
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

    public void update() {
        for (Plant plant : plants) {
            plant.move(-0.2f, 0f);
        }
    }
}
