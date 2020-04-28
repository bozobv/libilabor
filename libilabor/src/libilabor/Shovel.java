package libilabor;

public class Shovel extends Storable 
{
	private static int SHOVEL=3;
	public Shovel() {
		this.setId(SHOVEL);
	}
	public void used(Player p){
		p.getCurrentTable().setSnowHeight(p.getCurrentTable().getSnowHeight()-2);
		if(p.getCurrentTable().getSnowHeight()<=0)p.getCurrentTable().setSnowHeight(0);
	}
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }


	public void writeOut() 
	{
		System.out.print("sh");
	}

}
