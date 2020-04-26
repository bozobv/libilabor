package libilabor;

public abstract class Character {
	protected IceTable currentTable;
	public abstract void step();
	public abstract void move();
	
	public IceTable getCurrentTable() {
		return currentTable;
	}

	public void setCurrentTable(IceTable currentTable) {
		this.currentTable.removeCharacter(this);
		this.currentTable = currentTable;
	}
}
