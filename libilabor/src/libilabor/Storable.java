package libilabor;

public abstract class Storable extends Item
{
	abstract void pickedUpBy(Player p);
	
	void used(Player p){
		System.out.println("Ezt az eszkozt nem lehet hasznalni");
	}
}