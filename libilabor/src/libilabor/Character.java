package libilabor;

public abstract class Character {
	protected IceTable currentTable;
	public abstract void step();
	public abstract void move();
	public abstract  void attacked();
	
	public IceTable getCurrentTable() {
		return currentTable;
	}

	public void setCurrentTable(IceTable currentTable) {
		this.currentTable.removeCharacter(this);
		this.currentTable = currentTable;
	}
	public void writeOut() {}

}
