package libilabor;

public abstract class Item 
{
	private int id;

	void pickedUpBy(Player p) {}

	
	//SETTERS AND GETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
