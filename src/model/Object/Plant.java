package model.Object;

public class Plant {
    private int x;
    private int y;
    private int id;
    private int plantType;
    private float coolDown, range, dmg;

    public Plant(int x, int y, int id, int plantType) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.plantType = plantType;
        setDefaultDmg();
        setDefaultRange();
        setDefaultCoolDown();
    }

    private void setDefaultCoolDown() {
        this.coolDown = model.Helper.Constant.Plants.getStartCoolDown(this.plantType);
    }

    private void setDefaultRange() {
        this.range = model.Helper.Constant.Plants.getStartRange(this.plantType);
    }

    private void setDefaultDmg() {
        this.dmg = model.Helper.Constant.Plants.getStartDmg(this.plantType);
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
        this.x += x;
        this.y += y;
    }

    public float getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(float coolDown) {
        this.coolDown = coolDown;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getDmg() {
        return dmg;
    }

    public void setDmg(float dmg) {
        this.dmg = dmg;
    }

}
