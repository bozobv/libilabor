package libilabor;

public class WeakShovel extends Shovel 
{
	public void writeOut() {}
    private int durability=3;
    public WeakShovel(){
        this.setId(3);
    }
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }
    public void used(Player p){
        p.getCurrentTable().setSnowHeight(2);
        durability--;
        if(durability==0){broken(p);}
    }
    public void broken(Player p){
        p.removeFromInventory(this);
    }
}
