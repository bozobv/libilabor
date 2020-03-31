package libilabor;
import java.util.Scanner;

public class Scientist extends Player 
{
	public Scientist(IceTable currentTable) {
		super("Scientist"+Player.id++,4,4,currentTable);
	}
	
	public void useSkill() 
	{
		System.out.println("Irja be melyik szomszedjat akarja megvizsgalni");
		Scanner scanner = new Scanner(System.in);
		int answer = Integer.valueOf(scanner.nextLine());
		if (answer >= getCurrentTable().getNeighbours().size())
		{
			System.out.println("nincs ilyen szomszed");
			return;
		}
		System.out.println("a tabla kapacitasa:" + getCurrentTable().getNeighbours().get(answer).getCapacity());
		//scanner.close();
	}
}