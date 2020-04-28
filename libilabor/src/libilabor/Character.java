package libilabor;

public abstract class Character {
	private IceTable currentTable;

	//public abstract void step();
	public abstract void move(IceTable it);
	public abstract  void attacked();
	
	public IceTable getCurrentTable() {
		return currentTable;
	}
	public abstract void setCurrentTable(IceTable currentTable);

	public void writeOut() {}

}
