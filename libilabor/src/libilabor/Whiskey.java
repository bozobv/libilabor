package libilabor;

public class Whiskey extends Instant implements java.io.Serializable 
{



	public Whiskey(){
		
	}
	
	/**
	 * A whiskey-t egy adott jatekos felvette. A whiskey 2-vel noveli a thp-t. 
	 *
	 * @param p  
	 */  
	public void pickedUpBy(Player p) {
		p.setThp(p.getThp()+2);
		p.getCurrentTable().setFrozenItem(null);
		
	}
	/**
	 * Kiirja a whiskey azonositojat.
	 */  
	public String writeOut() 
	{
		System.out.print("wh");
		return "wh";
	}

}