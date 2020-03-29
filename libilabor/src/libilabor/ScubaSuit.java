package libilabor;

public class ScubaSuit extends Storable 
{

    void pickedUpBy(Player p) {
        p.addToInventory(this);
    }



}
