package model.Helper;

public class Constant {
    public static class Zombies {
        public static final int normalZombie = 0;
        public static final int coneZombie = 1;
        public static final int finalZombie = 2;
        public static final int bossZombie = 3;
        public static float getSpeed(int zombieType){
            switch(zombieType){
                case normalZombie:
                return -0.2f;
                case coneZombie:
                return -0.18f;
                case finalZombie:
                return -0.22f;
                case bossZombie:
                return -0.14f;
            }
            return 0;
        }
    }

    public static class Plants {
        public static final int sunFlower = 0;
        public static final int peaShooter = 1;
        public static final int freezePea = 2;
    }
}
