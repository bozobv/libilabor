package libilabor;

/**
 * az iglut megvalósító osztály
 */
public class Igloo implements Construction {
	/**
	 * kiir dolgokat
	 */
	public void writeOut() 
	{
		System.out.print("iglo");
	}

	/**
	 * akkor hívódik meg, ha a jegtablat amin az iglu van megtamadjak
	 * @param p egy jatekos aki a jegtablan tartozkodik
	 */
    public void attacked(Player p) {

    }
}
