package model.Helper;

public class Constant {
    public static class Zombies {
        public static final int normalZombie = 0;
        public static final int coneZombie = 1;
        public static final int finalZombie = 2;
        public static final int bossZombie = 3;

        public static float getSpeed(int zombieType) {
            switch (zombieType) {
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

        public static String getName(int zombieType) {
            switch (zombieType) {
                case normalZombie:
                    return "Normal Zombie";
                case coneZombie:
                    return "Cone Zombie";
                case finalZombie:
                    return "Final Zombie";
                case bossZombie:
                    return "Boss Zombie";
            }
            return "Unknown";
        }

        public static int getStartHealth(int zombieType) {
            switch (zombieType) {
                case normalZombie:
                    return 100;
                case coneZombie:
                    return 150;
                case finalZombie:
                    return 160;
                case bossZombie:
                    return 300;
            }
            return 0;
        }
    }

    public static class Plants {
        public static final int sunFlower = 0;
        public static final int peaShooter = 1;
        public static final int freezePea = 2;
        
        public static int getCost(int plantType) {
            switch (plantType) {
                case sunFlower:
                    return 50;
                case peaShooter:
                    return 100;
                case freezePea:
                    return 150;
            }
            return 0;
        }
        public static float getStartDmg(int plantType) {
            switch (plantType) {
                case sunFlower:
                    return 0f;
                case peaShooter:
                    return 10f;
                case freezePea:
                    return 15f;
            }
            return 0;
        }
        public static float getStartRange(int plantType) {
            switch (plantType) {
                case sunFlower:
                    return 0f;
                case peaShooter:
                    return 1000f;
                case freezePea:
                    return 1000f;
            }
            return 0;
        }
        public static float getStartCoolDown(int plantType){
            switch (plantType) {
                case sunFlower:
                    return 0f;
                case peaShooter:
                    return 10f;
                case freezePea:
                    return 10f;
            }
            return 0;
        }
    }
}
