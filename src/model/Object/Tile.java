package model.Object;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage Obj;

    public Tile(BufferedImage Obj){
        this.Obj = Obj;
    }
    
    public BufferedImage getObj(){
        return Obj;
    }

}
