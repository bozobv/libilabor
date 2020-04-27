package libilabor;

public class PolarBear extends Character {
    
	private IceTable currenttable;
	
	public IceTable getCurrenttable() {
		return currenttable;
	}
	public void setCurrenttable(IceTable currenttable) {
		this.currenttable = currenttable;
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
