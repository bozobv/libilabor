package libilabor;

import java.util.ArrayList;

public class UnstableTableTest {
	
	
	public void test() {
		
		StableTable t1 = new StableTable();
		UnstableTable t2 = new UnstableTable(1);
		Eskimo p1 = new Eskimo(t1);
		Eskimo p2 = new Eskimo(t1);
		System.out.println("");
		t1.playerVisit(p1);
		System.out.println("");
		t1.playerVisit(p2);
		ArrayList<IceTable>  ifield= new ArrayList<IceTable>();
		ifield.add(t1);
		ifield.add(t2);
		
	}

}
