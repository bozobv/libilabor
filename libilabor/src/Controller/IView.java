package Controller;
public interface IView {
	/**
	 * frissiti a kinezetet a nezetnek a modell alapjan
	 * @param modell ami alapjan frissiti a nezetet
	 */
	void refreshGraphics(IModell modell);
	
	/**
	 * inicializalja a menu ablakot
	 * @param controller a controller amelyik inicializalja
	 */
	void initializeMenu(Controller controller);
	
	/**
	 * inicializalja a jatek vege ablakot
	 * @param controller a controller amelyik inicializalja
	 */
	void initializeEndGame(Controller controller);
	
	/**
	 * inicializalja a jatek ablakot
	 * @param controller a controller amelyik inicializalja
	 */
	void initializeGameArea(IModell modell);

	/**
	 * megsemmisiti a nezetet
	 */
    void dispose();

    /**
     * inicializalja a tudos kepessegehez szukseges ablakot
     * @param cap a ho mennyiseg amit a kepesegevel lat a tudos
     */
	void scientistSkillWindow(int cap);
}
