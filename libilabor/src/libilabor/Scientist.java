package libilabor;

public class Scientist extends Player 
{
	public Scientist(IceTable currentTable) {
		super("Scientist"+Player.id++,4,5,currentTable);
	}
	
	public void UseSkill() {}
}