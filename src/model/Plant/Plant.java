package model.Plant;

public class Plant {
    private int x;
    private int y;
    private int id;
    private int plantType;

    public Plant(int x, int y, int id, int plantType) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.plantType = plantType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlantType() {
        return plantType;
    }

    public void setPlantType(int plantType) {
        this.plantType = plantType;
    }

    public void move(float x, float y) {
        this.x+=x;
        this.y+=y;
    }

}
