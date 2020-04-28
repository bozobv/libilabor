package libilabor;

public abstract class Character {
	protected IceTable currentTable;

	public abstract void step();
	public abstract void move();
	public abstract  void attacked();
	
	public IceTable getCurrentTable() {
		return currentTable;
	}
	public abstract void setCurrentTable(IceTable currentTable);

	public void writeOut() {}

}
