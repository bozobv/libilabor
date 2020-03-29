package libilabor;

public class Shovel extends Storable 
{

    void pickedUpBy(Player p) {
        p.AddToInventory(this,3);
    }

}
