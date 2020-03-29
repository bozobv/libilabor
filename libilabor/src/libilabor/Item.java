package libilabor;

public abstract class Item 
{
	private int id;
	
	public Item(int id ){
		this.id = id;
		
	}
	

	abstract void  pickedUpBy(Player p);


	//SETTERS AND GETTERS . 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

