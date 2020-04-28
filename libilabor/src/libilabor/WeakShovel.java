package libilabor;

/**
 * a torekeny asot megvalosito osztaly
 */
public class WeakShovel extends Shovel 
{
    /**
     * az aso tartossaga
     */
    private int durability=3;

    /**
     * konstruktor, ami beallitja az id-t a megfelelo ertekre
     */
    public WeakShovel(){
        this.setId(3);
    }


    /**
     * ez a fv hivodik meg, ha felveszik a targyat
     * @param p a jatekos aki felveszi a targyat
     */
    public void pickedUpBy(Player p) {
        p.addToInventory(this);
    }

    /**
     * ez a fv hivodik meg, mikor hasznaljak a targyat
     * @param p a jatekos aki hasznalja
     */
    public void used(Player p){
        p.getCurrentTable().setSnowHeight(2);
        durability--;
        if(durability==0){broken(p);}
    }

    /**
     * ez a fv hivodik meg, mikor eltorik az aso
     * @param p a jatekos akinek eltorik az asoja
     */
    public void broken(Player p){
        p.removeFromInventory(this.getId());
    }

    /**
     * kiir dolgokat
     */
    public void writeOut()
    {
    	System.out.print("wsh");
    }
}
