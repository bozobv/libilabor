package libilabor;

/**
 * a jegesmedvet megvalosito osztaly
 */
public class PolarBear extends Character implements java.io.Serializable{
	/**
	 * konstruktor
	 * @param it a jegtabla amire a jegesmedvet letrehozzuk
	 */
	public PolarBear(IceTable it) {
		super(it);
	}

	/**
	 * ezzel a fv-nyel allitjuk be, hogy a jegesmedve melyik jegtablan all jelenleg
	 * @param currenttable a tabla amire be szeretnék allitani
	 */
	@Override
	public void setCurrentTable(IceTable currenttable) {
		this.getCurrentTable().removeAnimal(this);
		this.setCurrentTable(currenttable);
		this.getCurrentTable().getAnimalsOnTable().add(this);
	}

	/**
	 * ez a fv hivodik meg, mikor tamad a medve
	 */
    public void attack(){
    	this.getCurrentTable().attacked();
	}

	/**
	 * ez a fv hivodik meg, mikor a medve lep
	 */
    public void step() {

    }

	/**
	 * ez a fv hivodik meg, mikor  a medve mozogna
	 * @param it a tabla amire mozdulni szeretne
	 */
    public void move(IceTable it) {

    }

	/**
	 * ez a fv hivodik meg, mikor tamadas eri
	 */
	public void attacked(){}

	/**
	 * kiir infokat
	 */
	public void writeOut() 
	{
		System.out.print("pb");
	}

}
