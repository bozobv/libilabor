package libilabor;

public class Whiskey extends Instant 
{

	public Whiskey(int id){
		super(id);
		
	}
	
	// A Whiskey kettovel noveli a THP-t.    
	void PickedUpBy(Player p) {
		p.setThp(p.getThp()+2);
		
	}
	void pickedUpBy(Player p) {}

}