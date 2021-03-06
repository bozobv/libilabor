package Modell;


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
		getIceField().endGame();
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
		tmp =tmp.concat("UT(" + this.getCapacity() + "," + this.getSnowHeight() + ",");
		System.out.print(tmp);
		if(this.getFrozenItem() == null) {
			tmp =tmp.concat("null");
			System.out.print("null");
		}
		else {
			tmp =tmp.concat(this.getFrozenItem().writeOut());}
		tmp =tmp.concat(",");
		System.out.print(",");
		if(this.getConstruction() == null) {
			tmp =tmp.concat("null");
			System.out.print("null");
		}
		else {
			tmp =tmp.concat(this.getConstruction().writeOut());
		}
		if(this.getPlayersOnTable() == null) {
			System.out.print(",null");
			tmp =tmp.concat(",null");
		}
		else
			for(int i = 0; i < this.getPlayersOnTable().size(); i++)
			{
				tmp =tmp.concat(this.getPlayersOnTable().get(i).writeOut());
			}
		if(this.getAnimalsOnTable() != null)
			for(int i = 0; i < this.getAnimalsOnTable().size(); i++)
			{
				tmp =tmp.concat(this.getAnimalsOnTable().get(i).writeOut());
			}
		System.out.print(")");
		tmp =tmp.concat(")");
		return tmp;
	}

}
