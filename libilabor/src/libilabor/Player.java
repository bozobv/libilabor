public abstract class Player 
{
	private String Name;
	private int thp;
	private int work;
	private IceTable currentTable;
	private Storable inventory;
	
	void Step() {}
	
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
