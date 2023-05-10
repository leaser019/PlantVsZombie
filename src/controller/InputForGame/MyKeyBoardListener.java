/* Team Name: Chicken Team.
Group Number: G01 - L02.
Members:
    Võ Minh Khang - ITCSIU21136
    Nguyễn Hoàng Gia Ân - ITCSIU21161
    Nguyễn Trọng Nguyên - ITITIU21263
Choice of game: Plants and Zombies.
 Purpose: "Plants vs. Zombies" is a popular tower defense game 
where players use plants to defend their home from zombies. 
*/

package controller.InputForGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.Game.Game;

public class MyKeyBoardListener implements KeyListener {
    private Game game;

    public MyKeyBoardListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ALT && e.getKeyCode() == KeyEvent.VK_F4) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
