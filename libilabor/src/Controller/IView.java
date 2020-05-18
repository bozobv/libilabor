package Controller;
public interface IView {
	
	void refreshGraphics(IModell modell);
	
	void initializeMenu(Controller controller);
	
	void initializeEndGame(Controller controller);
	
	void initializeGameArea(IModell modell);

    void dispose();

	void scientistSkillWindow(int cap);
}
