package libilabor;

public class ScubaSuit extends Storable 
{

    void pickedUpBy(Player p) {

        p.AddToInventory(this,2);
    }



}
