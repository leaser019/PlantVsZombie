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

package model.Plant;

import static model.Helper.Constant.Plants.freezePea;

import model.Object.Plant;

public class FreezePea extends Plant {

    public FreezePea(int x, int y, int id) {
        super(x, y, id, freezePea);
    }

}
