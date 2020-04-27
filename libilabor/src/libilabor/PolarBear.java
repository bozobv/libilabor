package libilabor;

public class PolarBear extends Character {
    
	
	public void setCurrenttable(IceTable currenttable) {
		this.setTable(currenttable);
		currenttable.removeAnimal(this);
	}
    public void attack(){}
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
