package libilabor;
import java.util.Scanner;

public class Scientist extends Player 
{
	public Scientist(IceTable currentTable) {
		super("Scientist"+Player.id++,4,5,currentTable);
	}
	
	public void useSkill() 
	{
		System.out.println("Irja be melyik szomszedjat akarja megvizsgalni");
		int answer= Integer.valueOf(scanner.nextLine());
		getCurrentTable().getNeighbours().getCapacity();
	}
}