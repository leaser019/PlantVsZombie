package model.Object;

import java.awt.Image;

public class Tile {
    private Image Obj;

    public Tile(Image Obj){
        this.Obj = Obj;
    }
    
    public Image getObj(){
        return Obj;
    }

}
