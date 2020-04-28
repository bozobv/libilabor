package libilabor;

/**
 * a flaregundarabot megvalosito osztaly
 */
public class FlareGunPart extends Storable implements java.io.Serializable
{
	/**
	 * konstruktor, beallitja az id-t a megfelelo ertekre
	 */
	public FlareGunPart() {
		this.setId(0);
	}

	/**
	 * ez a fv hivodik meg, mikor felveszik a targyak
	 * @param p a jatekos akinel a targy eltarolodik
	 */
	public void pickedUpBy(Player p) {
		p.addToInventory(this);
	}

	/**
	 * ez a fv hivodik meg, mikor hasznaljak a targyat
	 * @param p a jatekos aki a targyat hasznalja
	 */
	public void used(Player p) {
		p.repairFlareGun();
	}

	/**
	 * kiir dolgokat
	 */
	public void writeOut() 
	{
		System.out.print("fg");
	}

}
