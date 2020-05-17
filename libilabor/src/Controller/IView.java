package Controller;
import Graphics.*;
public interface IView {
	
	public void initialize();
	
	public void refreshGraphics(IModell modell);
	
	public void initializeMenu(Controller controller);
	
	public void initializeEndGame();
	
	public void initializeGameArea(IModell modell);
	
}
