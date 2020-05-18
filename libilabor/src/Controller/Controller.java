package Controller;

import Graphics.*;
import Modell.*;


import java.io.Serializable;

public class Controller implements Serializable
{
	/**
	 *  A modell az mvc architecturaban
	 */
	IModell modell;
	/**
	 * A nezet az mvc architecturaban
	 */
	IView view = new Graphics();
	
	/**
	 * 
	 * @param height : a magassaga a mapnak
	 * @param width	 : a szelessege a mapnak
	 * @param FrozenItemDrop : a szazalek amivel a befagyott targy gyakorisagot sulyozzuk
	 * @param snowHeight : a ho magassaga
	 */
	public void initializeMap(int height, int width, int FrozenItemDrop, int snowHeight) {
        modell = new Map(height,width,FrozenItemDrop, snowHeight, this);
	}
	
	/**
	 * elinditja a jatekot
	 */
	public void startGame()
	{
		view.initializeGameArea(modell);
	}
	/**
	 * befejezi a jatekot
	 */
	public void endGame()
	{
		view.initializeEndGame(this);
	}
	
	/**
	 * setter
	 */
	public void setIfController(){
		modell.setIfController(this);
	}
	
	/**
	 * inicializalja a menut
	 */
	public void initializeMenu(){
	    view.initializeMenu(this);
    }
	/**
	 * modell getter
	 * @return aktualis model tagvaltozo
	 */
	public IModell getModell() {
		return modell;
	}
	/**
	 * model setter
	 * @param modell a beallítando modell
	 */
	public void setModell(IModell modell) {
		this.modell = modell;
	}

	/**
	 * megsemmisiti a nezetet
	 */
	public void dispose() {
		view.dispose();
	}
	
	/**
	 * betolti a mentett jatekot
	 */
	public void loadGame()
	{
		initializeMap(8, 8, /*jcbItems.getSelectedIndex() +*/ 1, /*jcbSnow.getSelectedIndex() + */1);
		getModell().load("asd");
		modell.setIfController(this);
		setIfController();
		startGame();
	}
	
	/**
	 * uj jatekot kezd
	 */
	public void newGame(){
		initializeMap(8, 8, /*jcbItems.getSelectedIndex() +*/ 1, /*jcbSnow.getSelectedIndex() + */1);
		getModell().load("new");
		setIfController();
		startGame();
	}

	/**
	 * nyeresnel hivodik meg, nyerest kezeli
	 */
	public void win() {
		Win nyeres=new Win(this);
	}
	
	/**
	 * A tudos kepessegehez inicializal ablakot
	 * @param cap : a ho mennyisege amit a kepessegevel lat a tudos
	 */
	public void scientistSkillWindow(int cap){
		view.scientistSkillWindow(cap);
	}

}
