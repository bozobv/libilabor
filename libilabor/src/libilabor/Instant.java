package libilabor;

public abstract class Instant extends Item 
{
	private static int  INSTANT=4;



	public Instant(){
		this.setId(INSTANT);
	}

	
	public abstract void  pickedUpBy(Player p); 

} 