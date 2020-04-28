package libilabor;


import java.util.*;
public class UnstableTable extends IceTable implements java.io.Serializable
{
	/**konstruktor
	 * @param cap megadja hogy a kapacitas max mekkora lehet
	 * */
	public UnstableTable(int cap) 
	{
		super();
		Random rand = new Random();
		int c = rand.nextInt(cap) + 1; //+1, hogy ne legyen nulla
		this.setCapacity(c);
	}
	/**felboritja a tablat*/
	void flip() {

		for(Character p: this.getPlayersOnTable()) {
			((Player)p).setThp(0);
		}
	}
	/**atveszi a jatekost es megvizsgalja hogy fel kell e borulni vagy sem
	 * @param p az atvett jatekos
	 * */
	public void playerVisit(Player p) {
		
		this.getPlayersOnTable().add(p);
		
		if(this.getPlayersOnTable().size() > this.getCapacity())
			this.flip();
	}
	
	/**kiirja a tabla adatait*/
	public void writeOut() 
	{
		System.out.print("UT(" + this.getCapacity() + "," + this.getSnowHeight() + ",");
		if(this.getFrozenItem() == null)
			System.out.print("null");
		else
			this.getFrozenItem().writeOut();
		System.out.print(",");
		if(this.getConstruction() == null)
			System.out.print("null");
		else
			this.getConstruction().writeOut();
		if(this.getPlayersOnTable() == null)
			System.out.print(",null");
		else
			for(int i = 0; i < this.getPlayersOnTable().size(); i++)
			{
				this.getPlayersOnTable().get(i).writeOut();
			}
		if(this.getAnimalsOnTable() != null)
			for(int i = 0; i < this.getAnimalsOnTable().size(); i++)
			{
				this.getAnimalsOnTable().get(i).writeOut();
			}
		System.out.print(")");			
	}

}
