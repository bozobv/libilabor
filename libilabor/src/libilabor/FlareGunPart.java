package libilabor;

public class FlareGunPart extends Storable 
{
	private static int FLAREGUNPART_ID = 0;
	
	public FlareGunPart() {
		this.setId(FLAREGUNPART_ID);
		
	}
	public void pickedUpBy(Player p) {
		p.addToInventory(this);
	}

	public void used(Player p) {
		p.repairFlareGun();
	}
}
