package libilabor;

public abstract class Player 
{
	private String Name;
	private int thp;
	private int work;
	private IceTable currentTable;
	private Storable inventory;
	
	void Step() {}		//ha meghal valaki, akkor az IceField EndGame függvényét kell meghivni, bár most nézem, hogy nem ismeri az icefieldet, so vanbaj
	
	void Move(){}
	
	void UseItem(){}
	
	void UseSkill(){}
	
	void Dig(){}
	
	void PickUp(){}
	
	void SetThp(int thp){}
	
	void AddToInventory(Storable s){}
	
	void SetWork(int i){}
	
	void SetCurrantTable(IceTable i){}
	
	void RepairFlareGun() {}
	
	void FallInHole () {}
	
	
}
