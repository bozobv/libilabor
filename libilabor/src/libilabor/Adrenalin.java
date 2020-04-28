package libilabor;

public class Adrenalin extends Instant 
{

	public Adrenalin(){
		
	}
	
	/**
	 * Az adrenalin-t egy adott jatekos felvette. Az Adrenalin megnoveli a munkat eggyel.
	 *
	 * @param p  
	 */  
	public void pickedUpBy(Player p) {
		p.setWork(p.getWork()+1);
	}
	/**
	 * Kiirja az adrenalin azonositojat.
	 */  
	public void writeOut() 
	{
		System.out.print("adr");
	}



}