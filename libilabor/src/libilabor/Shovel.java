package libilabor;

public class Shovel extends Storable 
{

    void pickedUpBy(Player p) {
        p.addToInventory(this);
    }

}
