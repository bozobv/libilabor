package libilabor;

public class Eskimo extends Player 
{
	/**
	 * konstruktor
	 * @param currentTable ezen a tablan hozza letre az eszkimot
	 */
	public Eskimo(IceTable currentTable) {
		super("Eskimo"+ Player.id++, 5, 4, currentTable);
	}
	/**
	 * itt hasznalja a az eszkimo a kepesseget
	 *  @param t ezena jegtablan hasznalja
	 */
	public void useSkill(IceTable t) 
	{
		Igloo Igl = new Igloo();
		t.setConstruction(Igl);
	}
	/**
	 * kiirja az eszkimo adatait
	 */
	public void writeOut() 
	{
		System.out.print("es(" + this.getName() + ", " + this.getThp() + ", " + this.getWork());
		Storable[] inv = this.getInventory();

		for (int i = 0; i < 5 ; i++)
		{
			if (inv[i] != null)
			{
				System.out.print(", ");
				inv[i].writeOut();
				
			}
		}
		System.out.print("),");		
		System.out.print(")");
		

	}

}