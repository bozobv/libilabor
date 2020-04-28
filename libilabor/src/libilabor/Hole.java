package libilabor;

public class Hole extends IceTable implements java.io.Serializable
{	
	/**konstruktor*/
	public Hole() {
		super();
		this.setCapacity(0);
		
	}
	/**aztveszi az ide kivanni leo jatekost es megvizsgalj van e rajta buvarruha es aszrint cselekszik
	 * @param p az ide lepo jatekos
	 * */
	public void playerVisit(Player p) {
		
		this.getPlayersOnTable().add(p);
		p.getCurrentTable().removePlayer(p);
		if(p.getInventory()[2] == null) 
		{
			p.fallInHole();
			this.getIceField().setPlayerInWater(true);
		}
		p.setCurrentTable(this);	
	}
	/**eltavolitja a jatekost a tablarol es a playerInWater boolt falsera allitja
	 * @param p a torlendo jatekos
	 *  */
	public void removePlayer(Player p) {
		
		this.getPlayersOnTable().remove(this.getPlayersOnTable().indexOf(p));
		if (this.getPlayersOnTable() == null)
			this.getIceField().setPlayerInWater(false);
		
	}
	/**visszater a tablan levo targgyal
	 * @return null mert itt nem lehet targy
	 * */
	public Item getFrozenItem(){
		//System.out.println("ez egy luk, nincs benne semmi");
		//az icefield konstruktora ne tegyen ide item-et
		return null;
	}
	
	/**nem csinal semmit mert a lyuknak nem lehet targya
	 * @param it a beallitani kivant targy
	 * */
	public void setFrozenItem(Item it){
		//System.out.println("ez egy luk, ne rakj bele semmit");
	}
	
	/**Getter a kapacitashoz
	 * @return 0 mert a lyuknak nincs kapacitasa
	 * */
	public int getCapacity() {
		return 0;
	}
	/**kiirja a lyuk adatait*/
	public void writeOut() 
	{
		System.out.print("H(" + this.getCapacity() + "," + this.getSnowHeight() + ",");
		System.out.print("null,");
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
