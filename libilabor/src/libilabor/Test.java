package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void ropeTest(){

        Eskimo p1,p2;
        Rope r = new Rope();
        Hole h = new Hole();
        StableTable s = new StableTable();
        IceField i = new IceField(3,3);
        ArrayList<IceTable> neighbours = i.getIceTables().get(5).getNeighbours();
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
    
    public static void scientistUseSkillTest() {
    	StableTable st = new StableTable();
    	Hole h = new Hole();
    	UnstableTable ust = new UnstableTable(10);
    	IceField ifield = new IceField(3, 3);
    	ArrayList<IceTable> temp = new ArrayList<IceTable>();
    	temp.add(st);
    	temp.add(h);
    	temp.add(ust);
    	ifield.setIceTables(temp);
    	st.setIceField(ifield);
    	h.setIceField(ifield);
    	ust.setIceField(ifield);
    	
    	temp = new ArrayList<IceTable>();
    	temp.add(h);
    	temp.add(ust);
    	st.setNeighbours(temp);
    	
    	Scientist sct= new Scientist(st);
    	sct.useSkill();
    }

    public static void scubaSuitTest(){
    	
    	System.out.println("Stabil tabla peldanyositva!");
        StableTable t=new StableTable();
        System.out.println("Lyuk peldanyositva!");
        Hole h=new Hole();
        System.out.println("Eszkimo peldanyositva!");
        Eskimo p = new Eskimo(t);
        System.out.println("B�v�rruha peldanyositva!");
        ScubaSuit s = new ScubaSuit();
        IceField i= new IceField(3,3);
        System.out.println("A p Eszkimo felveszi a b�v�rruh�t!");
        p.addToInventory(s);
        h.setIceField(i);
        System.out.println("Nyomja meg a d-t hogy az Eszkimo a lyukba l�pjen.");
        Scanner scanner = new Scanner(System.in);
    	String asw = scanner.nextLine();  
        if(asw.equals("d")) {

    		h.playerVisit(p);
    		System.out.println("p1 Eszkimo Lyukba l�pett!");
            }
        if(!i.getPalyerInWater()) {
        	System.out.println("A teszt sikeres volt a j�t�kos a buv�rruha miatt nincs vesz�lyben!");
        }
        scanner.close();
        
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
    	System.out.println("Stabil t�bla peldanyostiva!");
		StableTable t1 = new StableTable();
		System.out.println("Instabil t�bla peldanyostiva!");
		UnstableTable t2 = new UnstableTable(2);
		t2.setCapacity(1);
		System.out.println("p1 Eszkimo peldanyostiva!");
		Eskimo p1 = new Eskimo(t1);
		System.out.println("p2 Eszkimo peldanyostiva!");
		Eskimo p2 = new Eskimo(t1);
		System.out.println("i IceField peldanyostiva!");
		IceField i = new IceField(3, 3);
		t2.setIceField(i);
		System.out.println("A jelenlegi ket jegtablabol all."
				+ "Egy stabilbol es egy instabilbol."
				+ "A jat�kosok most a satbil jegtablan vannak"
				+ "\n \"Az elso jatekos mozgatasahoz nyomja meg a 'd' gombot");
    		Scanner scanner = new Scanner(System.in);
        	String asw = scanner.nextLine();  
	        if(asw.equals("d")) {

	    		t2.playerVisit(p1);
	    		System.out.println("p1 Eszkimo Instabil j�gt�bl�ra l�pett!");
	            }
	        
	        System.out.println("Az elso jatekos mozgatasahoz nyomja meg a 'd' gombot");
	        
	        Scanner scanner1 = new Scanner(System.in);
	        asw = scanner1.nextLine();
	        if(asw.equals("d")) {
	    		t2.playerVisit(p2);
	    		System.out.println("p1 Eszkimo Instabil j�gt�bl�ra l�pett!");
	        }
        System.out.println("Elso jatekos thp-ja: "+p1.getThp() +
        		"\t Masodik jatekos thp-ja: "+ p2.getThp() + 
        		"\n Ha mmind a ketto 0 akkor jo a teszt.");
        scanner.close();
        scanner1.close();
		
	}
    

    public static void holeTest() {

    	System.out.println("Stabil tabla peldanyositva!");
        StableTable t=new StableTable();
        System.out.println("Lyuk peldanyositva!");
        Hole h=new Hole();
        System.out.println("Eszkimo peldanyositva!");
        Eskimo p = new Eskimo(t);
        System.out.println("IceField peldanyositava!");
        IceField i= new IceField(3,3);
        h.setIceField(i);
        System.out.println("Nyomja meg a d-t hogy az Eszkimo a lyukba l�pjen.");
        Scanner scanner = new Scanner(System.in);
    	String asw = scanner.nextLine();  
        if(asw.equals("d")) {

    		h.playerVisit(p);
    		System.out.println("p1 Eszkimo Lyukba l�pett!");
            }
        if(i.getPalyerInWater()) {
        	System.out.println("A teszt sikeres volt a j�t�kos vesz�lyben van!");
        }
        scanner.close();    	
}
    public static void inventoryTest() {
    	System.out.println("Scanner scanner= new Scanner(System.in);");
    	Scanner scanner= new Scanner(System.in);
    	System.out.println("StableTable st= new StableTable();");
    	StableTable st= new StableTable();
    	System.out.println("Eskimo eskimo= new Eskimo(st);");
    	Eskimo eskimo= new Eskimo(st);
    	System.out.println("Storable item;");
    	Storable item;
    	outerloop:
    	while(true) {
	    	 System.out.println("\nAdjon hozza valamit az inventoryhoz:\n"
	    	 		+ "0: FlareGunPart\n"
	    	 		+ "1: Rope\n"
	    	 		+ "2: ScubaSuit\n"
	    	 		+ "3: Shovel\n"
	    	 		+ "4:Kilepes\n");
	    	 System.out.println("int answer= Integer.valueOf(scanner.nextLine());");
	    	int answer= Integer.valueOf(scanner.nextLine());
	    	switch(answer) {
	    	case 0: System.out.println("case 0: item= new FlareGunPart(); break;");item= new FlareGunPart(); break;
	    	case 1: System.out.println("case 1: item= new Rope(); break;");item= new Rope(); break;
	    	case 2: System.out.println("case 2: item= new ScubaSuit(); break;");item= new ScubaSuit(); break;
	    	case 3: System.out.println("case 3: item= new Shovel(); break;");item= new Shovel(); break;
	    	case 4: System.out.println("case 4: break outerloop;");break outerloop;
	    	default: System.out.println("default:item= new Shovel(); break;");item= new Shovel(); break;
	    	}
	    	System.out.println("st.setFrozenItem(item);");
	    	st.setFrozenItem(item);
	    	System.out.println("eskimo.pickUp();");
	    	eskimo.pickUp();
	    	System.out.println("\nA jatekos eszkoztara: ");
	    	for (Storable it : eskimo.getInventory()) {
	    		System.out.println(it==null ? "semmi": it.getClass().toString());
			}
    	}
    	System.out.println("scanner.close();");
    	scanner.close();
    }
    
    public static void playerVisitTest() {
    	System.out.println("1. stabil jegtabla peldanyositva!");
    	StableTable it1= new StableTable();
    	System.out.println("2. stabil jegtabla peldanyositva!");
    	StableTable it2= new StableTable();
    	System.out.println("Eszkimo peldanyositva! Az eszkimo az elso jegtablan all.");
    	Eskimo p = new Eskimo(it1);
    	System.out.println("Eszkimo atlep a masik jegtablara!");
    	it2.playerVisit(p);
    	
    }
    
    public static void eskimoAdrenalinTest() {
    	System.out.println("Stabil jegtabla peldanyositva!");
    	StableTable st = new StableTable();
    	System.out.println("Eszkimo peldanyositva a stabil jegtablan!");
    	Eskimo e = new Eskimo(st);
    	System.out.println("Eszkimo munkaja:" + e.getWork());
    	System.out.println("Adrenalin peldanyositva!");
    	Adrenalin a = new Adrenalin();
    	System.out.println("Eszkimo Adrenalint vesz magahoz!");
    	a.pickedUpBy(e);
    	System.out.println("A munka eggyel megn�tt. 5 --> 6");
    	System.out.println("Eszkimo munkaja:" + e.getWork());	
    }

    public static void eskimoUseSkillTest()
    {
    	System.out.println("stabil jegtabla peldanyositva!");
    	StableTable it1= new StableTable();
    	System.out.println("Eszkimo peldanyositva! Az eszkimo a jegtablan all.");
    	Eskimo p = new Eskimo(it1);
    	System.out.println("iglu epitve");
    	p.useSkill();
    	
    }
    
    public static void blizzardTest() {
    	System.out.println("Egy jegmezo letrejott");
    	IceField i = new IceField(3,3);
    	
    	System.out.println("e1 eszkimo l�trejott");
    	Eskimo e1 = new Eskimo(i.getIceTables().get(0));
    	System.out.println("e2 letrejott");
    	Eskimo e2 = new Eskimo(i.getIceTables().get(1));
    	
    	i.getIceTables().get(0).getPlayers().add(e1);
    	i.getIceTables().get(1).getPlayers().add(e2);
    	System.out.println("e1 thp:" + e1.getThp());
    	System.out.println("e2 thp:" + e2.getThp());
    	
    	System.out.println("e1 iglut epit");
    	e2.useSkill();
    	
    	System.out.println("Hvihat lefut");
    	i.Blizzard();
    	
    	System.out.println("e1 thp:" + e1.getThp());
    	System.out.println("e2 thp:" + e2.getThp());
    	
    	
    }
    
    
        
    public static void main(String[] args){
    	boolean testrunning = true;
    	Scanner scanner = new Scanner(System.in);
    	while(testrunning == true)
    	{
    		String input = null;
    		System.out.print("Irja be a tesztelni kivant eset szamat \n"+
    				"1. ropeTest\n" +
    				"2. scubaSuitTest\n" +
    				"3. digTest\n" +
    				"4. shovelDigTest\n" +
    				"5. unstableTableTest\n"+ 
    				"6. inventoryTest\n"+
    				"7. playerVisitTest\n" +
    				"8. eskimoAdrenalinTest\n"+
    				"9. eskimoUseSkillTest\n"+
    				"10. holeTest\n"+
    				"11. scientistUseSkill\n"+
    				"12. blizzardTest\n"+
    				"13. exit\n");
    		
    		input = scanner.nextLine();
    		switch (input) {

    			case "1": ropeTest(); break;
    			case "2": scubaSuitTest(); break;
    			case "3": digTest(); break;
    			case "4": shovelDigTest(); break;
    			case "5": unstableTableTest(); break;
    			case "6": inventoryTest(); break;
    			case "7": playerVisitTest(); break;
    			case "8": eskimoAdrenalinTest(); break;
    			case "9": eskimoUseSkillTest(); break;
    			case "10": holeTest(); break;
    			case "11": scientistUseSkillTest(); break;
    			case "12": blizzardTest(); break;
    			case "13": testrunning = false; break;
    		}
    		System.out.println();
    		
    	}
    	scanner.close();

       

    }
}
