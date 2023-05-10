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

package controller.GUI.Sense;

import java.awt.event.*;

import view.GUI.ComingSoon;

public class ComingSoonMouseListener implements MouseListener {
    private ComingSoon comingSoon;

    public ComingSoonMouseListener(ComingSoon comingSoon2) {
        this.comingSoon = comingSoon2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.comingSoon.backToMenu();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
