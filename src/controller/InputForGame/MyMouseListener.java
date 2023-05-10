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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.Game.Game;

public class MyMouseListener implements MouseListener, MouseMotionListener {
    private Game game;

    public MyMouseListener(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            game.getGamePanel().mouseClicked(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game.getGamePanel().mousePressed(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.getGamePanel().mouseReleased(e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        game.getGamePanel().mouseDragged(e.getX(), e.getY());

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        game.getGamePanel().mouseMoved(e.getX(), e.getY());

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        game.getGamePanel().mouseEntered(e.getX(), e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
