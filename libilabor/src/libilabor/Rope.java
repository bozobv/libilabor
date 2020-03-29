package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

public class Rope extends Storable
{
	void pickedUpBy(Player p) {
		p.AddToInventory(this,1);
	}

	void used(Player user) {
		ArrayList<IceTable> neighbours = user.getCurrentTable().getNeighbours();
		boolean done=false;
		while(!done){
			ArrayList<Player> players;
			System.out.println("Melyik szomszedot szeretned kimenteni?( (j)obb,(b)al,(f)enti,(l)enti),(m)egse ");
			Scanner s=new Scanner(System.in);
			String input = s.nextLine();
			if(input.equals("m")){
				break;
			}
			else if(input.equals("j")){
				players=neighbours.get(0).getPlayers();
				if (players.size()==0){
					System.out.println("Nincs senki ezen a mezőn");
				}
				else{
					Player p = players.get(0);
					p.setCurrentTable(user.getCurrentTable());
				}
			}
			else if(input.equals("b")){
				players=neighbours.get(1).getPlayers();
			}
			else if(input.equals("f")){
				players=neighbours.get(2).getPlayers();
			}
			else if(input.equals("l")){
				players=neighbours.get(3).getPlayers();
			}
			else{
				System.out.println("Helytelen input");
			}
		}

	}
}

