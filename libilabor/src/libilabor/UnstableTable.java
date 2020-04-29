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
		this.getPlayersOnTable().get(0).setThp(0);
	}
	/**atveszi a jatekost es megvizsgalja hogy fel kell e borulni vagy sem
	 * @param p az atvett jatekos
	 * */
	public void playerVisit(Player p) {
		
		this.getPlayersOnTable().add(p);
		p.getCurrentTable().removePlayer(p);
		p.setCurrentTable(this);
		if(this.getPlayersOnTable().size() > this.getCapacity())
			this.flip();
	}
	
	/**kiirja a tabla adatait*/
	public String writeOut() 
	{
		String tmp = "";
		tmp.concat("UT(" + this.getCapacity() + "," + this.getSnowHeight() + ",");
		if(this.getFrozenItem() == null)
			tmp.concat("null");
		else
			this.getFrozenItem().writeOut();
		tmp.concat(",");
		if(this.getConstruction() == null)
			tmp.concat("null");
		else
			this.getConstruction().writeOut();
		if(this.getPlayersOnTable() == null)
			tmp.concat(",null");
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
		tmp.concat(")");
		return tmp;
	}

}
