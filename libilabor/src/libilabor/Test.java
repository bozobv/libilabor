package libilabor;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    //elvileg jobb oldalt lesz a kimentesre varo inas
    static void ropeTest(){
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
    //jobbra lesz a lik, oda kene belezugni
    static void scubaSuitTest(){
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
    static void digTest(){
        StableTable s=new StableTable();
        Eskimo p=new Eskimo(s);
        s.playerVisit(p);
        s.setSnowHeight(4);
        p.dig();
    }
    static void shovelDigTest(){
        StableTable s =new StableTable();
        Eskimo p=new Eskimo(s);
        Shovel shovel = new Shovel();
        p.addToInventory(shovel);
        s.playerVisit(p);
        p.dig();
    }
    public static void main(String[] args){
        System.out.print("1. ropeTest\n" +
                "2. scubaSuitTest\n" +
                "3. digTest\n" +
                "4. shovelDigTest\n" +
                "5. ");
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        switch (input) {
            case "1": ropeTest();
            case "2": scubaSuitTest();
            case "3": digTest();
            case "4": shovelDigTest();
        }
    }
}
