package libilabor;

public class Adrenalin extends Instant 
{

	public Adrenalin(int id){
		super(id);
		
	}
	
	// Az Adrenalin megnovel a munkat. . ...jjjjj dsdsd
	void PickedUpBy(Player p) {
		p.setWork(p.getWork()+1);
	}

	void pickedUpBy(Player p) {}

}