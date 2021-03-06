package Modell;

public class Eskimo extends Player implements java.io.Serializable
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
		if (this.getWork() < 1)
		{
			System.out.println("nincs eleg munkaja");
			return;
		}
		this.setWork(this.getWork()-1 );
		Igloo Igl = new Igloo();
		t.setConstruction(Igl);
	}
	/**
	 * kiirja az eszkimo adatait
	 */
	public String writeOut() 
	{
		String str="";
		str=str.concat(",es(" + this.getName() + ", " + this.getThp() + ", " + this.getWork());
		System.out.print(str);
		Storable[] inv = this.getInventory();

		for (int i = 0; i < 5 ; i++)
		{
			if (inv[i] != null)
			{
				str=str.concat(", ");
				System.out.print(", ");
				str=str.concat(inv[i].writeOut());			
			}
		}
		str=str.concat(")");
		System.out.print(")");		
		return str;
	}

}