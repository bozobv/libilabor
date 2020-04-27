package libilabor;

public class Eskimo extends Player 
{
	
	public Eskimo(IceTable currentTable) {
		super("Eskimo"+ Player.id++, 5, 4, currentTable);
	}
	
	public void useSkill() 
	{
		Igloo Igl = new Igloo();
		getCurrentTable().setConstruction(Igl);
	}
	
	public void writeOut() {}

}