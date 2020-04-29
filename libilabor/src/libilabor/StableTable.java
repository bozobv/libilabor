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
		tmp.concat("ST(" + this.getCapacity() + "," + this.getSnowHeight() + ",");
		System.out.print(tmp);
		if(this.getFrozenItem() == null) {
			tmp.concat("null");
			System.out.print("null");
		}
		else {
			tmp.concat(this.getFrozenItem().writeOut());
			tmp.concat(",");
			System.out.print(",");
		}
		if(this.getConstruction() == null) {
			tmp.concat("null");
			System.out.print("null");
		}
		else {
			tmp.concat(this.getConstruction().writeOut());
		}
		if(this.getPlayersOnTable() == null) {
			System.out.print(",null");
			tmp.concat(",null");
		}
		else
			for(int i = 0; i < this.getPlayersOnTable().size(); i++)
			{
				tmp.concat(this.getPlayersOnTable().get(i).writeOut());
			}
		if(this.getAnimalsOnTable() != null)
			for(int i = 0; i < this.getAnimalsOnTable().size(); i++)
			{
				tmp.concat(this.getAnimalsOnTable().get(i).writeOut());
			}
		System.out.print(")");
		tmp.concat(")");
		return tmp;
	}

}
