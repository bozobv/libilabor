package libilabor;

public class Whiskey extends Instant 
{


	
	// A Whiskey kettovel noveli a THP-t.    
	void PickedUpBy(Player p) {
		p.setThp(p.getThp()+2);
		
	}
	void pickedUpBy(Player p) {}

}