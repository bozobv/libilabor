package libilabor;

public class ScubaSuit extends Storable 
{
	private static int SCUBASUIT_ID = 2;

	public ScubaSuit() {
		this.setId(SCUBASUIT_ID);	
		
	}
	
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }


	public void writeOut() {}

}
