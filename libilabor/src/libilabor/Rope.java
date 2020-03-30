package libilabor;

import java.util.ArrayList;
import java.util.Scanner;


public class Rope extends Storable
{
	
	private static int ROPE_ID=1;
	
	public Rope() {
		this.setId(ROPE_ID);
		
	}
	public void pickedUpBy(Player p) {
		p.addToInventory(this);
	}

	public void used(Player user) {
		ArrayList<IceTable> neighbours = user.getCurrentTable().getNeighbours();
		boolean done=false;
		while(!done){
			ArrayList<Player> players = null;
			System.out.println("Melyik szomszedot szeretned kimenteni?( (j)obb,(b)al,(f)enti,(l)enti),(m)egse ");
			Scanner s=new Scanner(System.in);
			String input = s.nextLine();
			if(input.equals("m")){
				done=true;
			}
			else if(input.equals("j")){
				players=neighbours.get(0).getPlayers();			//ha ez így nem működne faszán, akkor az ifekben csak a számot(az indexet) határozzuk meg, aztán az utsó ifben deklaráljuk csak a playerst
			}
			else if(input.equals("b")){
				players=neighbours.get(1).getPlayers();			//TODO map szélein nincs minden irány xd
			}
			else if(input.equals("l")){
				players=neighbours.get(2).getPlayers();
			}
			else if(input.equals("f")){
				players=neighbours.get(3).getPlayers();
			}
			else{
				System.out.println("Helytelen input");
			}
			if(players!=null){
				if (players.size()==0){
					System.out.println("Nincs senki ezen a mezon");
				}
				else{
					players.get(0).setCurrentTable(user.getCurrentTable());
					done=true;
				}
			}
			s.close();
		}
	}
}

