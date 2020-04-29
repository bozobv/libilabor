package libilabor;

public class Food extends Instant implements java.io.Serializable
{



	public Food(){
	}

	/**
	 * A food-t egy adott jatekos felvette. A food eggyel noveli a THP-t 
	 *
	 * @param p  
	 */  
	//  
	public void pickedUpBy(Player p) {
		p.setThp(p.getThp()+1);
		p.getCurrentTable().setFrozenItem(null);
		
	}
	/**
	 * Kiirja a food azonositojat.
	 */  
	public String writeOut() 
	{
		return "food";
	}


}
