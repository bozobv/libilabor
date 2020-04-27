package libilabor;

public class Tent extends Item implements Construction {


	public Tent(){
		this.setId(4);
	}
	public void pickedUpBy(Player p) {

	}
	public void used(Player p){}

	public void writeOut() {}

	public void attacked(Player p) {
        p.attacked();
	}
}
