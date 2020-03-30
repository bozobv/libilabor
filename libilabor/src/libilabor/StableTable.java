package libilabor;


public class StableTable extends IceTable 
{
	public int getCapacity() {
		return this.getIceField().getPlayers().size();
	}
}
