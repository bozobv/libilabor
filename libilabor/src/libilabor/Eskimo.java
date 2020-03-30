package libilabor;

public class Eskimo extends Player 
{
	
	public Eskimo(IceTable currentTable) {
		super("Eskimo"+ Player.id++, 4, 5, currentTable);
	}
	public void useSkill() {}
}