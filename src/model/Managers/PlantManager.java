package model.Managers;

import static model.Helper.Constant.Plants.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;

import model.Plant.Plant;
import model.Plant.SunFlower;
import view.Game.GamePanel;
import model.Plant.PeaShooter;
import model.Helper.Constant.Plants;
import model.Plant.FreezePea;

public class PlantManager {
    private GamePanel gamePanel;
    private Image[] plantImg;
    private ArrayList<Plant> plants = new ArrayList<>();
    private Image[] plantCardImg;
    private int plantAmount=0;

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

    public void addPlant(Plant selectedPlant, int x,int y){
        plants.add(new Plant(x, y, plantAmount++, selectedPlant.getPlantType()));
        System.out.println("Add Plant !");
    }

    public void update() {
        for (Plant plant : plants) {
            // empty
        }
    }
    public Image[] getPlantCardImg(){
        return plantCardImg;
    }
}
