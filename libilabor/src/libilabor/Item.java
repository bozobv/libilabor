package libilabor;

public abstract class Item 
{
	private int id;


	

	abstract void  pickedUpBy(Player p);


	
	public Item() {
		id = 0;
	}
	public abstract void  pickedUpBy(Player p);
	//SETTERS AND GETTERS . 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

