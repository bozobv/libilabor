package Modell;

public class Adrenalin extends Instant implements java.io.Serializable
{

	public Adrenalin(){
		this.setId(5);
	}
	
	/**
	 * Az adrenalin-t egy adott jatekos felvette. Az Adrenalin megnoveli a munkat eggyel.
	 *
	 * @param p  
	 */  
	public void pickedUpBy(Player p) {
		p.setWork(p.getWork()+1);
		p.getCurrentTable().setFrozenItem(null);
	}
	/**
	 * Kiirja az adrenalin azonositojat.
	 */  
	public String writeOut() 
	{
		
		return "adr";
	}



}