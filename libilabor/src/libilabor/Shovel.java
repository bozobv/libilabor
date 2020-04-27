package libilabor;

public class Shovel extends Storable 
{
	private static int SHOVEL=3;
	public Shovel() {
		this.setId(SHOVEL);
	}
	public void used(Player p){
		p.getCurrentTable().setSnowHeight(2);
	}
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }


	public void writeOut() {}

}
