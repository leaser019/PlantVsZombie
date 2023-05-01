package model.Managers;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Object.Tile;

public class TileManager {
    private Tile GREEN_BALL,ZOMBIE_01,PEA_SHOOTER;
    private BufferedImage atlas;
    private ArrayList<Tile> tiles= new ArrayList<>(); 
    public TileManager(){
        loadAtlas();
        createTile();
    }
    private void loadAtlas() {
    
    }
    private void createTile() {
        tiles.add(GREEN_BALL = new Tile(getImage("lib\\image\\GreenBall.png")));
        tiles.add(ZOMBIE_01 = new Tile(getImage("lib\\image\\zombie1.png")));
        tiles.add(PEA_SHOOTER = new Tile(getImage("lib\\image\\peaShooter.png")));
    }
    private Image getImage(String url){
        atlas = (BufferedImage) Toolkit.getDefaultToolkit().getImage(url);
        int h = atlas.getHeight();
        int w = atlas.getWidth();
        return atlas.getSubimage(0, 0, w, h);
    }
    public Image getImage(int id){
        return tiles.get(id).getObj();
    }
}
