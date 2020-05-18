package Modell;

/**
 * interfesz, ami a jegtablara epitheto dolgokat fogja ossze
 */
public interface Construction extends java.io.Serializable {
    /**
     * ez a fv hivodik meg, mikor a jegtabla amin az adott epitmeny van, jegesmedve tamadasa ala esik
     * @param p egy jatekos aki a jegtablan tartozkodik
     */
    void attacked(Player p);

    /**
     * kiirja a dolgokat
     */

     abstract String writeOut();


}
