package libilabor;

public abstract class Instant extends Item 
{

	public Instant(int id){
		super(id);
	}
	
	abstract void  PickedUpBy(Player p); 

	void pickedUpBy(Player p) {}
}