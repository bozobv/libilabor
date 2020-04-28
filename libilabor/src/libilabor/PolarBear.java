package libilabor;

public class PolarBear extends Character {

	@Override
	public void setCurrentTable(IceTable currenttable) {
		this.currentTable.removeAnimal(this);
		this.currentTable=currenttable;
		this.currentTable.getAnimalsOnTable().add(this);
	}
    public void attack(){
		currentTable.attacked();
	}
    public void step() {

    }

    public void move() {

    }
    public void attacked(){}
	public void writeOut() 
	{
		System.out.print("pb");
	}

}
