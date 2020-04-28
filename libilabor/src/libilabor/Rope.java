package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

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
		IceTable it=user.getCurrentTable().getIceField().getIceTables().get(idx);
		ArrayList<IceTable> neighbours = user.getCurrentTable().getNeighbours();
		if(neighbours.contains(it)){
			if(it.getPlayersOnTable().size()>0){
				it.getPlayersOnTable().get(0).setCurrentTable(user.getCurrentTable());
			}
			else{
				System.out.println("nincs jatekos a kivalasztott tablan");
			}
		}
		else{
			System.out.println("a kivalasztott tabla tul messze van");
		}
		user.removeFromInventory(1);
		/*boolean done=false;
		while(!done){
			ArrayList<Character> characters = null;
			System.out.println("Melyik szomszedot szeretned kimenteni?( (j)obb,(b)al,(f)enti,(l)enti),(m)egse ");
			Scanner s=new Scanner(System.in);
			String input = s.nextLine();
			if(input.equals("m")){
				done=true;
			}
			else if(input.equals("j")){
				characters = new ArrayList<>();
				characters.addAll(neighbours.get(0).getPlayersOnTable());			
			}
			else if(input.equals("b")){
				characters = new ArrayList<>();
				characters.addAll(neighbours.get(1).getPlayersOnTable());	
			}
			else if(input.equals("l")){
				characters = new ArrayList<>();
				characters.addAll(neighbours.get(2).getPlayersOnTable());
			}
			else if(input.equals("f")){
				characters = new ArrayList<>();
				characters.addAll(neighbours.get(3).getPlayersOnTable());
			}
			else{
				System.out.println("Helytelen input");
			}
			if(characters!=null){
				if (characters.size()==0){
					System.out.println("Nincs senki ezen a mezon");
				}
				else{
					characters.get(0).setCurrentTable(user.getCurrentTable());
					done=true;
				}
			}
			s.close();
		}*/
	}


	/**
	 * kiir dolgokat
	 */
	public void writeOut() 
	{
		System.out.print("r");
	}

}

