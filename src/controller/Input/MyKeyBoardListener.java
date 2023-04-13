package controller.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyBoardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A");
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("s");
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("d");
        } else if (e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("w");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
