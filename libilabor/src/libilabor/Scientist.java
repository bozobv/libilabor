package libilabor;
import java.util.Scanner;

public class Scientist extends Player 
{
	/**
	 * 
	 * @param currentTable
	 */
	public Scientist(IceTable currentTable) 
	{
		super("Scientist"+Player.id++,4,4,currentTable);
	}
	
	public void useSkill(IceTable t) 
	{
		boolean tmp = false;
		for(IceTable i : this.getCurrentTable().getNeighbours() ){
			if(i.equals(t)) tmp = true;
		}
		if(!tmp) {
			int capacity = t.getCapacity();
			if(capacity < 0) {
				System.out.println("A vizsgalalt tabla kapacitasa: vegetelen");
			}
			else
				System.out.println("A vizsgalalt tabla kapacitasa: " + Integer.toString(capacity));
		}
	}
	
	public void writeOut() 
	{
		System.out.print("sc(" + this.getName() + ", " + this.getThp() + ", " + this.getWork());
		Storable[] inv = this.getInventory();
		for (int i = 0; i < 5 ; i++)
		{
			if (inv[i] != null)
			{
				System.out.print(", ");
				inv[i].writeOut();
				
			}
		}
		System.out.print(")");
	}

}