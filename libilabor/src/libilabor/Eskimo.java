package libilabor;

public class Eskimo extends Player 
{
	
	public Eskimo(IceTable currentTable) {
		super("Eskimo"+ Player.id++, 5, 4, currentTable);
	}
	
	public void useSkill(IceTable t) 
	{
		Igloo Igl = new Igloo();
		t.setConstruction(Igl);
	}
	
	public void writeOut() 
	{
		System.out.print("es(" + this.getName() + ", " + this.getThp() + ", " + this.getWork());
		Storable[] inv = this.getInventory();
		for (int i = 0; i < 5 ; i++)
		{
			if (inv[i] != null)
			{
				inv[i].writeOut();
				System.out.print(", ");
			}
		}
		System.out.print("),");

		
	}

}