package libilabor;

public class PolarBear extends Character {

	@Override
	public void setCurrentTable(IceTable currenttable) {
		this.getCurrentTable().removeAnimal(this);
		this.setCurrentTable(currenttable);
		this.getCurrentTable().getAnimalsOnTable().add(this);
	}
    public void attack(){
    	this.getCurrentTable().attacked();
	}
    public void step() {

    }

    public void move(IceTable it) {

    }
    public void attacked(){}
	public void writeOut() 
	{
		System.out.print("pb");
	}

}
