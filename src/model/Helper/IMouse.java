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

package model.Helper;

public interface IMouse {
    public void mouseClicked(int x, int y);

    public void mousePressed(int x, int y);

    public void mouseOver(int x, int y);

    public void mouseReleased(int x, int y);

    public void mouseEntered(int x, int y);

    public void mouseExited(int x, int y);

    public void mouseDragged(int x, int y);

    public void mouseMoved(int x, int y);
}
