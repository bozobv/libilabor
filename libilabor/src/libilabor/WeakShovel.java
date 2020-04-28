package libilabor;

public class WeakShovel extends Shovel 
{
    private int durability=3;
    public WeakShovel(){
        this.setId(3);
    }
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }
    public void used(Player p){
        p.getCurrentTable().setSnowHeight(p.getCurrentTable().getSnowHeight()-2);
        if(p.getCurrentTable().getSnowHeight()<=0)p.getCurrentTable().setSnowHeight(0);
        durability--;
        if(durability==0){broken(p);}
    }
    public void broken(Player p){
        p.removeFromInventory(this.getId());
    }
    
    public void writeOut()
    {
    	System.out.print("wsh");
    }
}
