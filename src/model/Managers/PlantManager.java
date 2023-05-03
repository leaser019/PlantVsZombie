package model.Managers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.HelperMethod.Constant.Plants;
import model.Plant.Plant;
import model.Plant.SunFlower;
import model.Plant.PeaShooter;
import model.Plant.FreezePeaShooter;
import view.Scenes.Game.GamePanel;
import static model.HelperMethod.Constant.Plants.*;

public class PlantManager {
    private GamePanel gamePanel;
    private Image[] plantImg;
    private Plant plant;
    private ArrayList<Plant> plants = new ArrayList<>();

    public PlantManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        plantImg = new Image[3];
        this.loadPlantImg();
    }

    private void loadPlantImg() {
        plantImg[0] = Toolkit.getDefaultToolkit().getImage(
            "lib\\image\\sunFlower.png");
    plantImg[1] = Toolkit.getDefaultToolkit().getImage(
            "lib\\image\\peaShooter.png");
    plantImg[2] = Toolkit.getDefaultToolkit().getImage(
            "lib\\image\\freezePeaShooter.png");
    }

    public void draw(Graphics g){
        for (Plant plant : plants) {
            this.drawPlant(plant,g);
        }
    }

    private void drawPlant(Plant plant, Graphics g) {
        g.drawImage(plantImg[plant.getPlantType()], peaShooter, freezePeaShooter, gamePanel);
    }
    private void addPlant(int x, int y,int plantType){
        switch(plantType){
            case sunFlower:
            plants.add(new SunFlower(x, y, 0));
            break;
            case peaShooter:
            plants.add(new PeaShooter(x,y,0));
            break;
            case freezePeaShooter:
            plants.add(new FreezePeaShooter(x, y,0));
            break;
        }
    }
}
