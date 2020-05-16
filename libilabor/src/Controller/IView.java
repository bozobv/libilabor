package Controller;
import Graphics.*;
public interface IView {
	
	public void initialize();
	
	public void refreshGraphics(IModell modell);
	
	public void initializeMenu();
	
	public void initializeEndGame();
	
	public void initializeGameArea();
	
}
