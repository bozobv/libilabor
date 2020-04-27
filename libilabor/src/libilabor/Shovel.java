package libilabor;

public class Shovel extends Storable 
{
	private static int SHOVEL=3;
	private int durability=3;
	public Shovel() {
		this.setId(SHOVEL);
	}

    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }
    public void broken(Player p){
	}

}
