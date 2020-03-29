package libilabor;

public abstract class Item 
{
	private int id;
	
	public Item(int id ){
		this.id = id;
		
	}
	

	abstract void  PickedUpBy(Player p);
	void pickedUpBy(Player p) {}


	//SETTERS AND GETTERS .
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

