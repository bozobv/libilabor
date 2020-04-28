package libilabor;

public class Food extends Instant 
{



	public Food(){
	}

	/**
	 * A food-t egy adott jatekos felvette. A food eggyel noveli a THP-t 
	 *
	 * @param p  a targyat felvevo jatekos
	 */  
	//  
	public void pickedUpBy(Player p) {
		p.setThp(p.getThp()+1);
		
	}
	/**
	 * Kiirja a food azonositojat.
	 */  
	public void writeOut() 
	{
		System.out.print("food");
	}


}
