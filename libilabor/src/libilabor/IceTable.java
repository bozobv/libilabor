package libilabor;

public abstract class IceTable 
{
	private int snowHeight;
	private int capacity;
	private IceField iceField;
	private Player playersOnTable;
	private IceTable neighbours;
	private Igloo igloo;
	private Item frozenItem;

	public IceTable(){}
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

