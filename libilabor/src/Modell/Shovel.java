package Modell;

/**
 * lapat osztaly
 */
public class Shovel extends Storable implements java.io.Serializable
{
	/**
	 * konstruktor, ami beallitja az id-t a megfelelo ertekre
	 */
	public Shovel() {
		this.setId(3);
	}

	/**
	 * ez a fv hivodik meg, mikor hasznaljak a targyat
	 * @param p a jatekos aki a targyat hasznalja
	 */
	public void used(Player p,int idx){
		p.getCurrentTable().setSnowHeight(p.getCurrentTable().getSnowHeight()-2);
		if(p.getCurrentTable().getSnowHeight()<=0)p.getCurrentTable().setSnowHeight(0);
	}

	/**
	 * ez a fv hivodik meg, mikor felveszik a targyat
	 * @param p a jatekos akinel a targy eltarolodik
	 */
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }

	/**
	 * kiir dolgokat
	 */
	public String writeOut() 
	{
		System.out.print("sh");
		return "sh";
	}

}
