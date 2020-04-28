package libilabor;

public abstract class Item implements java.io.Serializable
{
	/**
	 * a targy azonositoja
	 */
	private int id;

	/**
	 * konstruktor az id-t 0-ra allitja
	 */
	public Item() {
		id = 0;
	}
	/**
	 * a tagy felvetlekor a hivodik meg es tipusanak megfeleloen mukodik
	 * absztrakt mert minden leszarmozatnak peldanyositani kell
	 * @param p a targyat felvevo jatekos
	 */
	public abstract void  pickedUpBy(Player p);
	//SETTERS AND GETTERS . 
	
	/**
	 * getter az id-hez
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter az id-hez
	 * @param id az id uj erteke
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * kiirja az item adatait
	 * absztrakt mert minden leszarmozatnak peldanyositani kell
	 */
	public void writeOut() {}

}

