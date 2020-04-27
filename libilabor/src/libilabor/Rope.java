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
		}
	}
	
	public void writeOut() 
	{
		System.out.print("r");
	}

}

