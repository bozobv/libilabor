package libilabor;

public class Adrenalin extends Instant 
{


	

	public Adrenalin(){
		
	}

	
	// Az Adrenalin megnoveli a munkat eggyel.
	public void pickedUpBy(Player p) {
		p.setWork(p.getWork()+1);
	}



}