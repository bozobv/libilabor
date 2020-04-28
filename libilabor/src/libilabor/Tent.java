package libilabor;

/**
 * satort megvalosito osztaly
 */
public class Tent extends Storable implements Construction, java.io.Serializable {

	/**
	 * konstruktor, beallitja az id-t a megfelelo ertekre
	 */
	public Tent(){
		this.setId(4);
	}

	/**
	 * ez a fv hivodik meg, mikor a targyat felveszik
	 * @param p a jatekos akinel a targy eltarolodik
	 */
	public void pickedUpBy(Player p) {
		p.addToInventory(this);
	}

	/**
	 * ez a fv hivodik meg, mikor hasznaljak a targyat
	 * @param p a jatekos aki a targyat hasznalja
	 */

	public void used(Player p,int idx){
		p.getCurrentTable().setConstruction(this);
		p.removeFromInventory(4);
	}

	/**
	 * ez a fv hivodik meg, mikor megtamadjak a jegtablat, amin a sator van
	 * @param p egy jatekos aki a jegtablan tartozkodik
	 */
	public void attacked(Player p) {
        p.attacked();
	}
	/**
	 * kiir dolgokat
	 */
	public void writeOut()
	{
		System.out.print("tent");
	}

}
