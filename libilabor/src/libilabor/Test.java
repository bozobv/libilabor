package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void ropeTest(){

        Eskimo p1,p2;
        Rope r=new Rope();
        Hole h=new Hole();
        StableTable s=new StableTable();
        IceField i= new IceField(3,3);
        ArrayList<IceTable> neighbours=i.getIceTables().get(5).getNeighbours();
        neighbours.set(0,h);
        s.setNeighbours(neighbours);
        i.getIceTables().set(5,s);
        i.getIceTables().set(6,h);
        p1=new Eskimo(s);
        p2=new Eskimo(h);
        s.playerVisit(p1);
        h.playerVisit(p2);
        s.setFrozenItem(r);
        p1.pickUp();
        p1.useItem();
    }

    public static void scubaSuitTest(){
    	
        StableTable t=new StableTable();
        Hole h=new Hole();
        Eskimo p = new Eskimo(t);
        ScubaSuit s = new ScubaSuit();
        IceField i= new IceField(3,3);
        ArrayList<IceTable> neighbours=i.getIceTables().get(5).getNeighbours();
        neighbours.set(0,h);
        t.setNeighbours(neighbours);
        i.getIceTables().set(5,t);
        i.getIceTables().set(6,h);
        t.playerVisit(p);
        t.setFrozenItem(s);
        p.pickUp();
        p.move();
    }
    public static void digTest(){
        StableTable s=new StableTable();
        Eskimo p=new Eskimo(s);
        s.playerVisit(p);
        s.setSnowHeight(4);
        p.dig();
    }
    public static void shovelDigTest(){
        StableTable s =new StableTable();
        Eskimo p=new Eskimo(s);
        Shovel shovel = new Shovel();
        p.addToInventory(shovel);
        s.playerVisit(p);
        p.dig();
    }
    public static void unstableTableTest() {
    	System.out.println("Stabil tábla peldanyostiva!");
		StableTable t1 = new StableTable();
		System.out.println("Instabil tábla peldanyostiva!");
		UnstableTable t2 = new UnstableTable(2);
		t2.setCapacity(1);
		System.out.println("p1 Eszkimo peldanyostiva!");
		Eskimo p1 = new Eskimo(t1);
		System.out.println("p2 Eszkimo peldanyostiva!");
		Eskimo p2 = new Eskimo(t1);
		IceField i = new IceField(3, 3);
		t2.setIceField(i);
		System.out.println("A jelenlegi ket jegtablabol all."
				+ "Egy stabilbol es egy instabilbol."
				+ "A jatékosok most a satbil jegtablan vannak"
				+ "\n \"Az elso jatekos mozgatasahoz nyomja meg a 'd' gombot");
    		Scanner scanner = new Scanner(System.in);
        	String asw = scanner.nextLine();  
	        if(asw.equals("d")) {

	    		t2.playerVisit(p1);
	            }
	        
	        System.out.println("Az elso jatekos mozgatasahoz nyomja meg a 'd' gombot");
	        
	        Scanner scanner1 = new Scanner(System.in);
	        asw = scanner1.nextLine();
	        if(asw.equals("d")) {
	    		t2.playerVisit(p2);
	        }
        System.out.println("Elso jatekos thp-ja: "+p1.getThp() +
        		"\t Masodik jatekos thp-ja: "+ p2.getThp() + 
        		"\n Ha mmind a ketto 0 akkor jo a teszt.");
        scanner.close();
        scanner1.close();
		
	}
    
    public static void inventoryTest() {
    	Scanner scanner= new Scanner(System.in);
    	StableTable st= new StableTable();
    	Eskimo eskimo= new Eskimo(st);
    	Storable item;
    	outerloop:
    	while(true) {
	    	 System.out.println("Adjon hozza valamit az inventoryhoz:\n"
	    	 		+ "0: FlareGunPart\n"
	    	 		+ "1: Rope\n"
	    	 		+ "2: ScubaSuit\n"
	    	 		+ "3: Shovel\n"
	    	 		+ "4:Kilepes\n");
	    	int answer= Integer.valueOf(scanner.nextLine());
	    	switch(answer) {
	    	case 0: item= new FlareGunPart(); break;
	    	case 1: item= new Rope(); break;
	    	case 2: item= new ScubaSuit(); break;
	    	case 3: item= new Shovel(); break;
	    	case 4: break outerloop;
	    	default:item= new Shovel(); break;
	    	}
	    	st.setFrozenItem(item);
	    	eskimo.pickUp();
	    	System.out.println("A jatekos eszkoztara: ");
	    	for (Storable it : eskimo.getInventory()) {
	    		System.out.println(it==null ? "semmi": it.getClass().toString());
			}
    	}
    	scanner.close();
    }
    
    
    public static void main(String[] args){
        System.out.print("1. ropeTest\n" +
                "2. scubaSuitTest\n" +
                "3. digTest\n" +
                "4. shovelDigTest\n" +
                "5. unstableTableTest\n"+ 
                "6. inventoryTest\n");
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        switch (input) {
            case "1": ropeTest();
            case "2": scubaSuitTest();
            case "3": digTest();
            case "4": shovelDigTest();
            case "5": unstableTableTest();
            case "6": inventoryTest();
        }
        scanner.close();
    }
}
