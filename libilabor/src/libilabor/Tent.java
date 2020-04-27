package libilabor;

public class Tent extends Item implements Construction {


	public Tent(){
		this.setId(5);
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
