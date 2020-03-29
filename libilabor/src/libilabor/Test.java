package libilabor;

public class Test {
    void RopeTest(){
        Eskimo p1,p2;
        Rope r=new Rope();
        StableTable s=new StableTable();
        Hole h=new Hole();
        IceField i=new IceField(3,3);
        p1=new Eskimo(s);
        p2=new Eskimo(h);
        s.setFrozenItem(r);
        p1.PickUp();
        p1.UseItem();
    }
}
