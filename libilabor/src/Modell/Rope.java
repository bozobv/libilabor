package Modell;

import java.util.ArrayList;


/**
 * a kotelt megvalosito osztaly
 */
public class Rope extends Storable implements java.io.Serializable
{
	/**
	 * konstruktor, beallitja az id-t a megfelelo ertekre
	 */
	public Rope() {
		this.setId(1);
	}

	/**
	 * ez a fv hivodik meg, mikor felveszik a targyat
	 * @param p a jatekos akinel a targy eltarolodik
	 */
	public void pickedUpBy(Player p) {
		p.addToInventory(this);
	}

	/**
	 * ez a fv hivodik meg, mikor hasznaljak a targyat
	 * @param user a jatekos aki hasznalja a tarygat
	 */
	public void used(Player user,int idx) {
		IceTable it =user.getCurrentTable().getIceField().getIceTables().get(idx);
		ArrayList<IceTable> neighbours = user.getCurrentTable().getNeighbours();
		if(neighbours.contains(it)){
			if(it.getPlayersOnTable().size()>0){
				user.getCurrentTable().playerVisit(it.getPlayersOnTable().get(0));
			}
			else{
				System.out.println("nincs jatekos a kivalasztott tablan");
			}
		}
		else{
			System.out.println("a kivalasztott tabla tul messze van");
		}
		user.removeFromInventory(1);

	}


	/**
	 * kiir dolgokat
	 */
	public String writeOut() 
	{
		System.out.print("r");
		return "r";
	}

}

