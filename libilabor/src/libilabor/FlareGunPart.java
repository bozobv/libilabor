package libilabor;

public class FlareGunPart extends Storable 
{
	void pickedUpBy(Player p) {
		p.AddToInventory(this,0);
	}

	void used(Player p) {
		p.RepairFlareGun();
	}
}
