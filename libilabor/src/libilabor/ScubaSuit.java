package libilabor;

/**
 * a buvarruhat megvalosito osztaly
 */
public class ScubaSuit extends Storable implements java.io.Serializable
{
	/**
	 * konstruktor, ami beallitja az id-t a megfelelo ertekre
	 */
	public ScubaSuit() {
		this.setId(2);
	}

	/**
	 * ez a fv hivodik meg, mikor egy jatekos felveszi ezt a targyat
	 * @param p a jatekos akinel a targy eltarolodik
	 */
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }

	/**
	 * kiir dolgokat
	 */
	public void writeOut() 
	{
		System.out.print("sc");
	}

}
