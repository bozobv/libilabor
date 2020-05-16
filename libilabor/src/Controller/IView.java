package Controller;
import Graphics.*;
public interface IView {
	
	public void initialize();
	
	public void refreshGraphics();
	
	public Menu initializeMenu();
	
	public EndGame initializeEndGame();
	
	public GameArea initializeGameArea();
	
}
