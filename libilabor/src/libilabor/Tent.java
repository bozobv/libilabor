package libilabor;

public class Tent extends Storable implements Construction {

	private static int TENT_ID=4;
	public Tent(){
		this.setId(TENT_ID);
	}
	public void pickedUpBy(Player p) {

	}
	public void used(Player p){}

	public void writeOut() 
	{
		System.out.print("t");
	}

	public void attacked(Player p) {
        p.attacked();
	}
}
