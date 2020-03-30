package libilabor;

public class Food extends Instant 
{


	
	//  A food eggyel noveli a THP-t 
	void PickedUpBy(Player p) {
		p.setThp(p.getThp()+1);
		
	}


	void pickedUpBy(Player p) {}
}
