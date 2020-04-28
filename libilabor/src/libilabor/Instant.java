package libilabor;

public abstract class Instant extends Item implements java.io.Serializable
{
	private static int  INSTANT_ID=4;



	public Instant(){
		this.setId(INSTANT_ID);
	}

	/**
	 * Az instan item-et egy adott jatekos felvette.
	 *
	 * @param p 
	 */  
	
	public abstract void  pickedUpBy(Player p); 
	/**
	 * Kiirja az instant item azonositojat.
	 */ 
	public abstract void writeOut();

} 