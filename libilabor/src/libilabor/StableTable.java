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
		String tmp = "";
		tmp = tmp.concat("ST(" + Integer.toString(this.getCapacity()) + "," + Integer.toString(this.getSnowHeight()) + ",");
		System.out.print(tmp);
		if(this.getFrozenItem() == null) {
			tmp.concat("null");
			System.out.print("null");
		}
		else {
			tmp =tmp.concat(this.getFrozenItem().writeOut());
			tmp =tmp.concat(",");
			System.out.print(",");
		}
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
