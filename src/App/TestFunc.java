package App;

import java.util.Random;

public class TestFunc {
    public static void main(String[] args) {
        int b =100;
        int a =1;
        Random rand = new Random();
        int ranNum = rand.nextInt(b)+a;
        System.out.println(ranNum);
    }
}
