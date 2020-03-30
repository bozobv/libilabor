package libilabor;

public class Whiskey extends Instant 
{

	public Whiskey(){
		
	}
	
	// A Whiskey kettovel noveli a THP-t.    
	public void pickedUpBy(Player p) {
		p.setThp(p.getThp()+2);
		
	}

}