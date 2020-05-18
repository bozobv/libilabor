package Controller;
import Graphics.*;
public interface IView {
	
	public void initialize();
	
	public void refreshGraphics(IModell modell);
	
	public void initializeMenu(Controller controller);
	
	public void initializeEndGame(Controller controller);
	
	public void initializeGameArea(IModell modell);

    void dispose();

	void scientistSkillWindow(int cap);
}
