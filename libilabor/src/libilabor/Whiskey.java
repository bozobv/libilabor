package libilabor;

public class Whiskey extends Instant 
{



	public Whiskey(){
		
	}
	
	/**
	 * A whiskey-t egy adott jatekos felvette. A whiskey 2-vel noveli a thp-t. 
	 *
	 * @param p  a targyat felvevo jatekos
	 */  
	public void pickedUpBy(Player p) {
		p.setThp(p.getThp()+2);
		
	}
	/**
	 * Kiirja a whiskey azonositojat.
	 */  
	public void writeOut() 
	{
		System.out.print("wh");
	}

}