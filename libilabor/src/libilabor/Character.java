package libilabor;

/**
 * a karaktereket osszefogo absztrakt osztaly
 */
public abstract class Character implements java.io.Serializable {
	/**
	 * az a tabla, amelyen a karakter jelenleg tartozkodik
	 */
	private IceTable currentTable;

	/**
	 * konstruktor, egy jegtablat kell neki atadni
	 * @param it az a jegtabla, amire a karaktert letre szeretnenk hozni
	 */
	public Character(IceTable it) {
		currentTable = it;
	}
	
	//public abstract void step();

	/**
	 * a karakter az adott tablara probal mozdulni
	 * @param it a tabla amire mozdulni szeretne
	 */
	public abstract void move(IceTable it);

	/**
	 * ez a fv hivodik meg, ha a karaktert tamadas eri
	 */
	public abstract  void attacked();

	/**
	 * visszaadja a tablat, amin a karakter tartozkodik
	 * @return a tabla amin a karakter tartozkodik
	 */
	public IceTable getCurrentTable() {
		return currentTable;
	}

	/**
	 * beallitja a tablat amin tartozkodik a jatekos
	 * @param inCurrentTable a tabla, amire a tartozkodast szeretnénk valtoztatni
	 */
	public void setCurrentTable(IceTable inCurrentTable)
	{
		currentTable = inCurrentTable;
	}

	/**
	 * kiir dolgokat
	 */
	public abstract String writeOut();

}
