package libilabor;

public class Food extends Instant 
{



	public Food(){
	}

	
	//  A food eggyel noveli a THP-t 
	public void pickedUpBy(Player p) {
		p.setThp(p.getThp()+1);
		
	}
	
	public void writeOut() {}


}
