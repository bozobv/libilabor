package libilabor;

public abstract class Character {
	private IceTable currentTable;

	public Character(IceTable it) {
		currentTable = it;
	}
	
	//public abstract void step();
	public abstract void move(IceTable it);
	public abstract  void attacked();
	
	public IceTable getCurrentTable() {
		return currentTable;
	}
	public void setCurrentTable(IceTable inCurrentTable)
	{
		currentTable = inCurrentTable;
	}

	public void writeOut() {}

}
