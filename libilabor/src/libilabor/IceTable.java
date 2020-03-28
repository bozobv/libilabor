package libilabor;

import java.util.List;

public abstract class IceTable 
{
	private int snowHeight;			//max 4
	private int capacity;
	private IceField iceField;
	private Player playersOnTable;
	private IceTable neighbours;
	private Igloo igloo;
	private Item frozenItem;

<<<<<<< HEAD
	public IceTable(int newsnow){} 					  //még ebbe bele kell pakolni, hogy milyen tárgyak vannak belefagyasztva
=======
	public IceTable(int newsnow){} 			      //még ebbe bele kell pakolni, hogy milyen tárgyak vannak belefagyasztva
>>>>>>> branch 'master' of https://github.com/bozobv/libilabor.git
	
	void setNeighbours(List<IceTable> newNeighbours)
	{
		neighbours = (IceTable) newNeighbours;        //nemtom, hogy jó-e oda az átcastolás
	}
	
	void PlayerVisit(Player p) {}
	
	void BlizzardComing() {}
	
	int GetCapacity()
	
	{
		return capacity;
	}
	
	IceTable GetNeighbours() {
		IceTable it = null; //TODO nyilván nem null csak zavart hogy piros xd
		return it;
	}
	
	void SetIgloo() {}
	
	void SetSnowHeight() {}
	
	Item GetFrozenItem() 
	{
		return frozenItem;
	}
	
	void CheckFlareGunPart() {}
	
	Player GetPlayers() 
	{
		return playersOnTable;
	}
	
	void RemovePlayer(Player p) {}
}

