package libilabor;


public class StableTable extends IceTable implements java.io.Serializable
{
	/*public int getCapacity() {
		return this.getIceField().getPlayers().size();
	}*/
	/**
	 * konstruktorban beallitjuk a capacityt -1-r hogy egyszeruen meg tudjuk kulonboztetni a tobbitol
	 */
	public StableTable()
	{
		super();
		this.setCapacity(-1);
	}
	
	/**
	 * kiirja a tabla adatait a kimenetre
	 */
	public String writeOut() 
	{
		String tmp ="";
		tmp.concat("ST(" + this.getCapacity() + "," + this.getSnowHeight() + ",");
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
