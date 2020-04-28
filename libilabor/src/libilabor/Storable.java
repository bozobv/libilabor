package libilabor;

/**
 * absztrakt osztaly, ami a jatekosok altal eltarolhato targyak kozos viselkedeset irja le
 */
public abstract class Storable extends Item implements java.io.Serializable
{
	/**
	 * absztrakt fv, akkor fog meghivodni a leszarmazottaknal, ha egy jatekos felveszi oket
	 * @param p a jatekos akinel a targy eltarolodik
	 */
	public abstract void pickedUpBy(Player p);

	/**
	 * akkor hivodik meg, ha az adott targyat hasznaljak
	 * @param p a jatekos aki a targyat hasznalja
	 */
	public void used(Player p){
		System.out.println("Ezt az eszkozt nem lehet hasznalni");
	}

	/**
	 * ezzel irja ki a dolgokat
	 */
	public abstract void writeOut();

}