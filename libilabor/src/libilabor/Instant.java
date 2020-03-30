package libilabor;

public abstract class Instant extends Item 
{
	private static int  INSTANT_ID=4;



	public Instant(){
		this.setId(INSTANT_ID);
	}

	
	public abstract void  pickedUpBy(Player p); 

} 