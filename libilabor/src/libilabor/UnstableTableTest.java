package libilabor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UnstableTableTest {
	
	
	public void test() {
		
		StableTable t1 = new StableTable();
		UnstableTable t2 = new UnstableTable(1);
		Eskimo p1 = new Eskimo(t1);
		Eskimo p2 = new Eskimo(t1);
		System.out.println("A jelenlegi ket jegtablabol all."
				+ "Egy stabilbol es egy instabilbol."
				+ "A jatékosok most a satbil jegtablan vannak");
      
    		System.out.println("Az elso jatekos mozgatasahoz nyomja meg a 'd' gombot");
    		Scanner scanner = new Scanner(System.in);
        	String asw=scanner.nextLine();  
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
		
	}

}
