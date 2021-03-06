package Modell;


public class Scientist extends Player implements java.io.Serializable
{
	/**
	 * konstruktor 
	 * @param currentTable ezen a tablan hozza letre a kutatot
	 */
	public Scientist(IceTable currentTable) 
	{
		super("Scientist"+Player.id++,4,4,currentTable);
	}
	/**
	 * itt hasznalja a kutato a kepesseget
	 * @param t ezen a tablan hasznalja
	 */
	public void useSkill(IceTable t) 
	{
		if (this.getWork() < 1)
		{
			System.out.println("nincs eleg munkaja");
			return;
		}
		boolean tmp = false;
		for(IceTable i : this.getCurrentTable().getNeighbours() ){
			if(i.equals(t)) tmp = true;
		}
		if(tmp) {
			int capacity = t.getCapacity();
			getCurrentTable().getIceField().getController().scientistSkillWindow(capacity);
			if(capacity < 0) {
				System.out.println("A vizsgalalt tabla kapacitasa: vegetelen");
			}
			else
				System.out.println("A vizsgalalt tabla kapacitasa: " + Integer.toString(capacity));
		}
		this.setWork(this.getWork()-1);
	}
	/**
	 * kiirja a kutato adatait
	 */
	public String writeOut() 
	{
		String str="";
		str=str.concat(",sc(" + this.getName() + ", " + this.getThp() + ", " + this.getWork());
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