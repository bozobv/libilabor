package libilabor;

public class Tent extends Item implements Construction {

	private static int TENT_ID=4;
	public Tent(){
		this.setId(TENT_ID);
	}
	public void pickedUpBy(Player p) {

	}
	public void used(Player p){}

	public void writeOut() 
	{
		System.out.print("tent");
	}

	public void attacked(Player p) {
        p.attacked();
	}
}
