package libilabor;

public class ScubaSuit extends Storable 
{
	private static int SCUBASUIT = 2;

	public ScubaSuit() {
		this.setId(SCUBASUIT);
		
	}
	
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }



}
