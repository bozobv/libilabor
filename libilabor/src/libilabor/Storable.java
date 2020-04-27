package libilabor;

public abstract class Storable extends Item
{
	public Storable() {
	}
	public abstract void pickedUpBy(Player p);
	
	public void used(Player p){
		System.out.println("Ezt az eszkozt nem lehet hasznalni");
	}
	
	public void writeOut() {}

}