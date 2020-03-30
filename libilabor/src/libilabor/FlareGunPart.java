package libilabor;

public class FlareGunPart extends Storable 
{
	void pickedUpBy(Player p) {
		p.addToInventory(this);
	}

	void used(Player p) {
		p.repairFlareGun();
	}
}
