package libilabor;

public class Whiskey extends Instant 
{



	public Whiskey(){
		
	}
	
	//    
	public void pickedUpBy(Player p) {
		p.setThp(p.getThp()+2);
		
	}

	public void writeOut() {}

}