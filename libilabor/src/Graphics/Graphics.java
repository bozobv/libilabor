package Graphics;
import Controller.*;
import Modell.*;
/**
 * 
 * A nezet interfacet valositja meg, osszefoglalja a grafikai elemeket
 *
 */
public class Graphics implements IView {
	/**
	 * a menu
	 */
	Menu menu;
	/**
	 * a jatek nezet
	 */
	GameArea garea;
	/**
	 * a jatek vege nezet
	 */
	EndGame eg;

	/**
	 * letrehozza a menut
	 */
	@Override
	public void initializeMenu(Controller controller) {
		menu = new Menu(controller);
	}
	/**
	 * letrehozza a jatek vege nezetet
	 */
	public void initializeEndGame(Controller controller) {
		eg = new EndGame(controller);

	}
	
	/**
	 * letrehozza a jatekteret
	 */
	@Override
	public void initializeGameArea(IModell modell) {
			garea= new GameArea((Map) modell);
	}

	/**
	 * eltavolitja a jatekteret
	 */
	@Override
	public void dispose() {
		garea.dispose();
	}
	/**
	 * a tudos kepessegehez szukseges ablakot hozza letre
	 */
	@Override
	public void scientistSkillWindow(int cap) {
		garea.scientistSkillWindow(cap);
	}
}
