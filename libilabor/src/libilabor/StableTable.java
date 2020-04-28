package libilabor;


public class StableTable extends IceTable 
{
	/*public int getCapacity() {
		return this.getIceField().getPlayers().size();
	}*/
	public StableTable()
	{
		super();
		this.setCapacity(-1);
	}
	
	public void writeOut() 
	{
		System.out.print("ST(" + this.getCapacity() + "," + this.getSnowHeight() + ",");
		if(this.getFrozenItem() == null)
			System.out.print("null");
		else
			this.getFrozenItem().writeOut();
		System.out.print(",");
		if(this.getConstruction() == null)
			System.out.print("null");
		else
			this.getConstruction().writeOut();
		System.out.print(",");
		if(this.getPlayersOnTable() == null)
			System.out.print("null");
		else
			for(int i = 0; i < this.getPlayersOnTable().size(); i++)
			{
				this.getPlayersOnTable().get(i).writeOut();
				System.out.print(",");
			}
		System.out.print(")");		
	}

}
